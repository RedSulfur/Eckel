package com.preparation.innerClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


/**
 * @author Some guy
 */

public class InnerClassTest {

    public static void main(String[] args) {

        TalkingClock talkingClock = new TalkingClock(true,1000);
        talkingClock.start();
        JOptionPane.showMessageDialog(null, "Close this window?");
        System.exit(0);
    }
}

class TalkingClock {

    /**
     * @param beep defines whether it will be a sonic signal or not
     * @param interval defines the time domain between the signals
     */

    private boolean beep;
    private int interval;

    public TalkingClock(boolean beep, int interval) {
        this.beep = beep;
        this.interval = interval;
    }

    public void start() {

        /*
        В случае, если имя класса используется лишь однажды: например при создании обьекта
        данного типа в определенном методе, класс можно определить локально в отдельном методе
        */

        /*
        Область действия таких классов всегда определяется блоком, в котором они определены
         */

        class TimePrinter implements ActionListener {

            public void actionPerformed(ActionEvent e) {

                Date now = new Date();
                System.out.println("At the tone the date is: " + now);
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }

        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval,listener);
    }
    /*
    class TimePrinter implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Date now = new Date();
            System.out.println("At the tone the date is: " + now);
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
    */


}
