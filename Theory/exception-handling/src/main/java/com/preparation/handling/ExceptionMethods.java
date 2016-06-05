package com.preparation.handling;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class TestException extends Exception {

    int x;

    public TestException() {}

    public TestException(String msg) {
        super(msg);
    }

    public TestException(String msg, int x) {
        super(msg);
        this.x = x;
    }

    @Override
    public String getMessage() {
        return "Более детальное описание: " + super.getMessage();
    }
}


public class ExceptionMethods {

    static final String fileOut = "/home/sulfur/IdeaProjects/Preparation/" +
            "Theory/exception-handling/src/main/java/traceInFile.out";

    public static void main(String[] args) throws IOException {

        try {
            throw new TestException("This goes to file", 13);
        } catch (TestException e) {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)));
            out.write("Argument as char[] but accepts String object???");
            out.write("\n\n");
            e.printStackTrace(out);
            System.out.println("Intercepted");
            System.out.println("Common message: " + e.getMessage());
            System.out.println("Localized message: " + e.getLocalizedMessage());
            System.out.println("toString: " + e.toString());
            System.out.println(e.getClass().getName());
            System.out.println(e.getClass().getSimpleName());
            e.printStackTrace(System.out);
            out.close();
        }
    }
}
