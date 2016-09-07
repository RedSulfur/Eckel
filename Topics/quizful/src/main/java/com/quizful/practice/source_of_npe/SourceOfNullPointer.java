package com.quizful.practice.source_of_npe;

public class SourceOfNullPointer {

    public static void main(String[] args) {

        WrongFormatter f = new WrongFormatter();
        TestNPE test = new TestNPE();

        System.out.println(TestNPE.handle(f, null));
    }
}
