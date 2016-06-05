package com.preparation.strings;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class ThreatAnalyzer {

    static String threat =
            "11.133.15.31@02/12/2015\n" +
            "141.141.11.75@12/08/2015\n" +
            "13.154.17.15@08/04/2016\n" +
            "15.184.11.85@04/10/2015\n" +
            "18.135.12.45@01/10/2016\n" +
            "[Next long section with different data format]";
    public static void main(String[] args) {

        Scanner sc = new Scanner(threat);
//        [] - mathces any single character in brackets
        String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" +
                "(\\d{2}/\\d{2}/\\d{4})";
//        re{n} - Matches exactly n number of occurrences of preceding expression.


        while (sc.hasNext(pattern)) {
            /*
            при использованни next() с конкретным шаблоном этот шаблон применяется к следующей
            входной лексеме. Для получения доступа к результату применяется метод match()
            */
            sc.next(pattern);
            MatchResult matchResult = sc.match();
            String ip = matchResult.group(1);

            //  соответствует второму выражению в круглых скобках
            String date = matchResult.group(2);

            System.out.format("Threat on %s from %s \n", date, ip);
        }

    }

}
