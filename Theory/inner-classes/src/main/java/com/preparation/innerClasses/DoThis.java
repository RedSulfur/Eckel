package com.preparation.innerClasses;

/**
 * Created by sulfur on 06.04.16.
 */
public class DoThis {
    private int i = 0;
    private void f() {
        System.out.println("DoThis f()");
    }

    /*
    Если вам потребуется получить ссылку на обьект внешнего класса,
    то просто укажите имя внешнего класса с .this
    (ссылка проверяется во время компиляции поэтому не требует затрат
    ресурсов во время выполнения)
     */

    class Inner {
        DoThis outer() {
            return DoThis.this;
//            this без уточнения соответствует обьекту Inner
        }
    }
    Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DoThis dt = new DoThis();
        /*
        Для непосредственного создания обьекта внутреннего класса
        указывается не имя внешнеог класса, а обьект внешнего класса.

        Это происходит потому что обьект внутреннего класса незаметно
        связывается с обьектом внешнего класса на базе которого он был создан.
         */
        DoThis.Inner dti = dt.inner();
//        приказать создать обьекту один из его внутренних классов
//        DoThis.Inner dti = dt.new Inner();
        dti.outer().f();

    }


}
