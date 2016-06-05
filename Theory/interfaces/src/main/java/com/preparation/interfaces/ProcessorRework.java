package com.preparation.interfaces;

import java.util.Arrays;


/**
 * Created by sulfur on 05.04.16.
 */



        interface ProcessorVol2 {
        Object process(Object input);
        String name();
        }


public class ProcessorRework {

public static void process(ProcessorVol2 p,Object s){
        System.out.println("Using processor "+p.name());
        System.out.println(p.process(s));
        }
        }

        abstract class StringProcessor implements ProcessorVol2 {

            public String name() {
                return getClass().getSimpleName();
            }

            public abstract String process(Object input);

            public static String s = "A pleasure that will take my mind " +
                    "off the reality of my life, my past life";

            public static void main(String[] args) {
                ProcessorRework.process(new UpperCase(), s);
                ProcessorRework.process(new LowerCase(), s);
                ProcessorRework.process(new Splitter(), s);
            }

        }

class UpperCase extends StringProcessor {
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class LowerCase extends StringProcessor {
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends StringProcessor {
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}







