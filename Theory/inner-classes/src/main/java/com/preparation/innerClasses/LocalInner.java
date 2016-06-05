package com.preparation.innerClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by sulfur on 06.04.16.
 */
public class LocalInner {

    public static void main(String[] args) {

        BeepingClock clock = new BeepingClock();
        clock.start(1000,true);
        JOptionPane.showMessageDialog(null,"Close window?");
        System.exit(0);
    }
}


    class BeepingClock {

        /*
        Локальные внутренние классы отличаются от обычных тем, что
        они имеют доступ не только к полям своего внешнего класса,
        но и к локальным переменным!

        Но такие локальные переменные должны быть обьявлены как final
         */

        public void start(int interval, final boolean beep) {

            class TimerPrinter implements ActionListener{

                public void actionPerformed(ActionEvent e) {
                    Date date = new Date();
                    System.out.println("At the beep the time is: " + date);
                    Toolkit.getDefaultToolkit().beep();
                }
            }

            ActionListener listener = new TimerPrinter();
            Timer t = new Timer(interval,listener);
            t.start();
        }
    }
