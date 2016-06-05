package com.preparation.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {


    private static String text = "C'est un mot qu'on dirait inventé pour elle\n" +
            "Quand elle danse et qu'elle met\n" +
            "Son corps а jour, tel\n" +
            "Un oiseau qui étend ses ailes pour s'envoler\n" +
            "Alors je sens l'enfer s'ouvrir\n" +
            "Sous mes pieds\n" +
            "J'ai posé mes yeux sous sa robe de gitane\n";
    /*
    \ - обратная косая черта регулярного выражения, значит следующий
    символ имеет специальное значение.
    */
    private static String regex = "(?m)(\\S+)\\s+((\\S+)\\s+(\\S+)$)";

    public static void main(String[] args) {

        /*
        Группы представляют собой части регулярного выражения, заключенные в кргулые скобки,
        к которым можно обращаться по номеру группы.
        */
        /*
        0 соответстует совпадению всего выражения
        1 соответствует совпадению первого подвыражения в круглых скобках
        */

        Matcher m = Pattern.compile(regex).matcher(text);

        while (m.find()) {

            for (int j = 0; j <= m.groupCount(); j++) {
                System.out.print("[" + m.group(j) + "]");
            }
            System.out.println("\n");
        }
    }


}
