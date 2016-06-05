package com.preparation.handling;

/**
 * Created by sulfur on 11.04.16.
 */
public class Rethrowing {
    public static void f() throws Exception {
        System.out.println("Creating exception in f()");
        throw new Exception("Created in f()");
    }

    /*
    Повторное возбуждение исключения заставляет его перейти в распоряжение
    обработчика более высокого уровня. Все последующие болки catch текущего
    блока try  игнорируются. Кроме того, вся информация обьекта, представляющего
    исключения сохраняется, таким образом обработчик более высокого уровня
    может её извлечь
     */
    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("printStackTrace in g()");
            e.printStackTrace(System.out);
            throw e;
        }
    }

    /*
    Если вы просто заново возбуждаете исключение, информация о нём, печатаемая
    методом printStackTrace, по-прежнему будет отноститься к месту, где воз-
    никло исключение, но не к месту его повторного возбуждения.
    Метод fillInStackTrace() позволяет использовать новую информацию о трасси-
    ровке стека, который возвращает исключение, созданное на основе старого, но
    с включением туда новой информации о стеке.
     */

    public static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("printStackTrace in h()");
            e.printStackTrace(System.out);
            throw (Exception) e.fillInStackTrace();
        }

    }

    public static void main(String[] args) {

        try {
            g();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }

        try {
            h();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }

    }

}
