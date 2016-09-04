package com.preparation.strings;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheReplacements {

    public static void main(String[] args) {

        /*!   C'est un mot qu'on dirait inventé        pour elle
        Quand elle danse et qu'elle met
        Son corps а        jour, tel
               Un oiseau qui étend ses ailes pour s'envoler
        Alors je sens l'enfer s'ouvrir
        Sous mes pieds
             J'ai posé mes          yeux sous sa robe de gitane
        malgama-lab.com/songs/n/notre_dame_de_paris/belle.html
        lgama-lab.comsdgfdgdfgfgdfgfdgfdgfdgdgdg/. !*/


        try {
            String text = BufferedInputFile.read("/home/sulfur/IdeaProjects/Preparation/Theory/practice/src/main/java/com/preparation/practice/TheReplacements.java");
            Pattern pattern = Pattern.compile("/\\*!(.*)!\\*/",Pattern.DOTALL);
            String inner;
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                inner = matcher.group(1);

                // 2 or more occurrences of the preceding expression
                inner = inner.replaceAll(" {2,}", " ");

                // В режиме Multiline выражение ^ совпадает с началом логических строк
                // re+ Matches 1 or more of the previous thing
                inner = inner.replaceAll("(?m)^ +", "");

                inner = inner.replaceFirst("[aeiou]", "(VOWEL1)");

                StringBuffer stringBuffer = new StringBuffer();
                Pattern p = Pattern.compile("[aeiou]");
                Matcher m = p.matcher(inner);

                while (m.find()) {
                    m.appendReplacement(stringBuffer,m.group().toUpperCase());
                }
                m.appendTail(stringBuffer);

                System.out.println(stringBuffer);
//                System.out.println(text);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
