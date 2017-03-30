package com.pluralsight.generics.extensible_enum;

public class ExtendedOperationDemo {

    public static void main(String[] args) {

        double x = 2.0;
        double y = 3.0;
        test(ExtendedOperation.class, x, y);
    }

    private static <T extends Enum<T> & Operation>
            void test(Class<T> operation, double x, double y) {

        for (T op : operation.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
