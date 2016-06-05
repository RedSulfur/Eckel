package com.preparation.innerClasses;


public class Sequence {

    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if(next != items.length) {
            items[next++] = x;
        }
    }
    private class SequenceSelector implements Selector {
        private int i = 0;
        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if(i < items.length) i++;
        }
    }

    /*
    Для конструирования обьекта внутреннего класса необходима
    ссылка на обьект внешнего класса. Если компилятор не сумеет
    обнаружить её он сообщит об ошибке
     */

    /*
    При обращении к члену окружающего класса эта ссылка используется
    для вызова нужного члена
     */

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence s = new Sequence(10);
        for (int i = 0; i < 10; i ++) {
            s.add(Integer.toString(i));
        }
        Selector selector = s.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}

interface Selector {
    boolean end();
    Object current();
    void next();
}



