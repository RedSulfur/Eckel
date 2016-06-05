package com.preparation.algorithms;

import java.util.Arrays;

public class TheStack {

    private int stackSize;
    private String stackArray[];

    public TheStack(int stackSize) {
        this.stackSize = stackSize;
        stackArray = new String[stackSize];
        Arrays.fill(stackArray, "-1");
    }

    // a case when the stack is empty
    private int topOfStack = -1;

    public void push(String value) {

        if(topOfStack + 1 < stackSize) {

            stackArray[++topOfStack] = value;
        } else {
            System.out.println("The stack is full");
        }
        displayTheStack();
        System.out.println("PUSH " + value + " was added to the stack\n\n");
    }

    public String pop() {

        if (topOfStack >= 0) {

            System.out.println("POP " + stackArray[topOfStack] + " was removed from the stack");
            stackArray[topOfStack] = "-1";
            displayTheStack();
            return stackArray[topOfStack--];
        } else {
            displayTheStack();
            System.out.println("Sorry but the stack is empty");
            return "-1";
        }
    }

    public String peek() {

        if (topOfStack >= 0) {
            System.out.println("PEEK " + stackArray[topOfStack] + " is at the top of the stack");
            displayTheStack();
            return stackArray[topOfStack];
        } else {
            System.out.println("Sorry but the stack is empty");
            return "-1";
        }
    }

    public void popAll() {

        for (int i = topOfStack; i >= 0; i--) {
            pop();
        }
    }

    public void pushMany(String value) {

        String parts[] = value.split(" ");

        for (String part :
                parts) {
            push(part);
        }
    }

    public void displayTheStack() {

        for(int n = 0; n < 61; n++)System.out.print("-");
        System.out.println();

        for(int n = 0; n < stackSize; n++) {

            System.out.format("| %2s " + " ", n);
        }

        System.out.println("|");
        for(int n = 0; n < 61; n++)System.out.print("-");
        System.out.println();

        for(int n = 0; n < stackSize; n++){
            if(stackArray[n].equals("-1")) System.out.print("|     ");
            else System.out.print(String.format("| %2s "+ " ", stackArray[n]));
        }
        System.out.println("|");
        for(int n = 0; n < 61; n++)System.out.print("-");
        System.out.println();
    }


    public static void main(String[] args) {

        TheStack theStack = new TheStack(10);
        theStack.push("10");
        theStack.push("16");
//        theStack.pop();
//        theStack.pop();
        theStack.peek();
        theStack.pushMany("12 13 14 15");
        theStack.popAll();


    }


}
