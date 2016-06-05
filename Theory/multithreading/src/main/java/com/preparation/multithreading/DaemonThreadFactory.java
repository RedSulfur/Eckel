package com.preparation.multithreading;


import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread d = new Thread(r);
        d.setDaemon(true);
        return d;
    }
}
