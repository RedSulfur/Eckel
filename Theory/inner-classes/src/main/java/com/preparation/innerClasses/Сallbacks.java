package com.preparation.innerClasses;

class Callee1 implements Incrementable {
    private int i = 0;
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement {
    public static void f(MyIncrement mi) {
        mi.increment();
    }
    public void increment() {
        System.out.println("Совершенно другой метод");
    }
}

class Callee2 extends MyIncrement{

    private int i = 0;
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    /*
    Класс Closure просто реализует интерфейс Incrementable,
    предоставляя при этом связь с обьектом Callee2, но эта
    связь безопасна. Кто бы не получил ссылку на Incrementable
    он в состоянии вызвать лишь метод increment(), и других
    возможностей у него нет.
     */
    class Closure implements Incrementable {
        public void increment() {
            Callee2.this.increment();
        }
    }
    Incrementable getCallBackReference() {
        return new Closure();
    }
}

class Caller {
    private Incrementable callbackreference;

    Caller(Incrementable cbr) {
        callbackreference = cbr;
    }

    void go() {
        callbackreference.increment();
    }
}

public class Сallbacks {

    public static void main(String[] args) {

    Callee1 c1 = new Callee1();
    Callee2 c2 = new Callee2();

    MyIncrement.f(c2);
    Caller cal1 = new Caller(c1);
    Caller cal2 = new Caller(c2.getCallBackReference());
    cal1.go();
    cal1.go();
    cal2.go();
    cal2.go();

    }

}


























