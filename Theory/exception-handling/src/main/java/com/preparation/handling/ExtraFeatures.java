package com.preparation.handling;

class MyException extends Exception {

    int x;

    public MyException() {}
        /*
        Для того, чтобы описать конструктор, принимающий в качестве аргумента строку,
        в которую можно моместить подходящую для описания исключения строку, необходимо
        воспользоваться конструктором родительского класса, вызываемого ключевым
        словом super
         */
    public MyException(String msg) {
        super(msg);
    }

    public MyException(String msg, int x) {
        super(msg);
        this.x = x;
    }

    public int val() {
        return x;
    }


    /*
    Переопределение метода Throwable.getMessage() для получения более содержательного
    сообщения
     */
    @Override
    public String getMessage() {
        return "Подробное сообщение: " + super.getMessage();
    }
}

public class ExtraFeatures {

    public static void f() throws MyException {
        System.out.println("Возбуждаем exception в f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Возбуждаем exception в g()");
        throw new MyException("Создано в g()");
    }

    public static void h() throws MyException {
        System.out.println("Возбуждаем exception в h()");
        throw new MyException("Создано в h()",46);
    }

    public static void main(String[] args) {

        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
        try {
            h();
        } catch (MyException e) {
            e.printStackTrace(System.out);
            System.out.println("e.val() = " + e.val());
        }

    }

}
