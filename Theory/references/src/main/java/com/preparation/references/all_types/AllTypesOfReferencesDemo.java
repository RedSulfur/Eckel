package com.preparation.references.all_types;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

class runTests {
    public static void main(String[] args) {
        AllTypesOfReferencesDemo demo = new AllTypesOfReferencesDemo();
        demo.testSoftReferences();
    }
}

class BigObject {
    private int value;

    public BigObject(Integer value) {
        this.value = value;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("BigObject (" + value + ") finalize()");
    }

    @Override
    public String toString() {
        return value + "";
    }
}

public class AllTypesOfReferencesDemo {

    List<BigObject>            strongList;      // сильные ссылки
    List<Reference<BigObject>> softList;        // мягкие ссылки
    List<Reference<BigObject>> weakList;        // слабые ссылки
    List<Reference<BigObject>> phantomList;     // фантомные ссылки
    ReferenceQueue<BigObject>  queue;           // очередь
    List<String>               loadMemoryList;  // здесь будут храниться ссылки на строки, которые
                                                // используются для загрузки памяти
    public void testSoftReferences() {
        init();
        System.gc();
        System.out.println("garbage collector invoked");
        printLists();
        System.out.println("memory usage increased");
        loadMemory(); // загрузка памяти
        System.out.println("loadMemoryList.size() = "+loadMemoryList.size());
        System.gc();
        System.out.println("garbage collector invoked");
        printLists();
    }

    private void init(){
        strongList = new ArrayList<>();
        softList = new ArrayList<>();
        weakList = new ArrayList<>();
        phantomList = new ArrayList<>();
        loadMemoryList = new ArrayList<>();
        queue = new ReferenceQueue<>();
        for (int i=0; i<3; i++){
            strongList.add(new BigObject(i));
            softList.add(new SoftReference<>(new BigObject(i)));

            weakList.add(new WeakReference<>(new BigObject(i)));
            phantomList.add(new PhantomReference<>(new BigObject(i), queue));
        }
        printLists();
    }

    private void loadMemory(){
        for (int i=0; i < 1200000; i++){
            loadMemoryList.add(i + "");
        }
    }

    private void printLists() {

        System.out.println("Strong references: ");
        for (BigObject bo : strongList) System.out.print(bo + " ");
        System.out.println();
        System.out.println("SoftReferences: ");
        printList(softList);
        System.out.println("WeakReferences: ");
        printList(weakList);
        System.out.println("PhantomReferences: ");
        printList(phantomList);
    }

    private void printList(List<Reference<BigObject>> pList){
        for (Reference<BigObject> ref : pList)
            // get() - вернет strong-ссылку на объект в случае, если GC не удалил его
            // из памяти. В другом случае вернется null.
            System.out.print(ref.get()+" ");

        System.out.println();
    }
}
