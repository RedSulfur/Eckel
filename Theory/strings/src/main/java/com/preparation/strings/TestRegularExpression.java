package com.preparation.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sulfur on 22.04.16.
 */
public class TestRegularExpression {


    public static void main(String[] args) {

        String test = "abcabcabcabcdefabc";
        /*
        re{ n,}	Matches n or more occurrences of preceding expression.
        */
        String[] patterns = new String[]{"abc+", "(abc)+", "(abc){2,}"};

        for(String pattern : patterns) {
        //  обьект Pattern представляет собой откомпилированную версию регулярного выражения
        /*  метод matcher() и входная строка используются для создания обьекта Matcher
        на базе откомпилированного обьекта Pattern  */
            System.out.println("Regular expression " + pattern);
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(test);
            /*
            public boolean find()
            Attempts to find the next subsequence of the input sequence that matches the pattern.
            */
            while(m.find()) {
            //  group - returns the input subsequence matched by the previous match.
            System.out.println("Match " + m.group() + " at positions: "
            //  start - returns the start index of the previous match.
            //  end - returns the offset after the last character matched.
            + m.start() + " " + (m.end() - 1));
            }
        }
    }
}
