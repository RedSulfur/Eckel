package com.preparation.innerClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by sulfur on 07.04.16.
 */
public class AnonymousInnerClassTest {

    public static void main(String[] args) {

        TalkingClock2 clock = new TalkingClock2();
        clock.start(1000,true);
        JOptionPane.showMessageDialog(null,"Exit program?");
        System.exit(0);
    }
}

    class TalkingClock2 {

        public void start(final int interval, final boolean beep){

        ActionListener listener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                System.out.println("At the tone time is: " + date);
                if(beep) Toolkit.getDefaultToolkit().beep();
                }

            };
            Timer timer = new Timer(interval,listener);
            timer.start();
        }

    }

