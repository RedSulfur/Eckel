package com.preparation.structures.qeue;

public class Stack {

    String[] stackArray;
    int stackSize;
    int topOfStack = -1;

    public Stack(int stackSize) {
        this.stackSize = stackSize;
        stackArray = new String[stackSize];
    }

    public void push(String value) {
        if((topOfStack + 1) < stackSize) {
            stackArray[++topOfStack] = value;
        }
    }

    public String pop() {
        if(topOfStack >= 0) {
            return stackArray[topOfStack--];
        } else {
            System.out.println("Stack is empty");
            return "-1";
        }
    }

    public String peek() {
        return stackArray[topOfStack];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push("10");
        stack.push("15");
        stack.push("3");
        System.out.println(stack.peek());

        stack.pop();
        System.out.println(stack.peek());


    }
}
