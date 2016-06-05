package com.preparation.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sulfur on 22.04.16.
 */
public class Finding {

    private static String test = "A CharSequence is a readable sequence of char values." +
            " This interface provides uniform, read-only access to many different kinds of char sequences. ";

    private static String regex = "\\w+";


    public static void main(String[] args) {

        //  обьект Pattern представляет собой откомпилированную версию регулярного выражения
        /*  метод matcher() и входная строка используются для создания обьекта Matcher
        на базе откомпилированного обьекта Pattern  */

        Matcher m = Pattern.compile(regex).matcher(test);
        /*
        метод find() может использоваться для нахождения множественных сопадений шаблона в
        обьекте CharSequence
        */

        while (m.find()) {
            System.out.print(m.group() + " ");
        }
    }
}
