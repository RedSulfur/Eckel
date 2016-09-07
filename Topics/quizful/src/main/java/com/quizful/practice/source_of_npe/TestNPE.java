package com.quizful.practice.source_of_npe;

public class TestNPE {

    public static String handle(WrongFormatter f, String s) {
        if("".equals(s)) {
            return "(none)";
        }
        return f.format(s.trim());
    }
}
