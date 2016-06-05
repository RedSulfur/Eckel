package com.preparation.handling;



class oneException extends Exception {
    public oneException(String s) {
        super(s);
    }
}

class twoException extends Exception {
    public twoException(String s) {
        super(s);
    }
}

public class RethrowNew {
    public static void f() throws oneException {
        System.out.println("Creating exception in f()");
        throw new oneException("in f()");
    }

    /*
    При возбуждении исключения, отличающегося от изначально перехваченного
    эффект будет такой же как и при использовании метода fillInStackTrace(),
    информация об изначальном месте зарождения теряется и остается только то,
    что относится к новой команде throw.
     */
    public static void main(String[] args) {

        try {
            try {
                f();
            } catch (oneException e) {
                System.out.println("Intercepted in the inner try");
                e.printStackTrace(System.out);
                throw new twoException("from inner try");
            }
        }catch (twoException e) {
            System.out.println("Intercepted in the outer try");
            e.printStackTrace(System.out);
            }


    }

}
