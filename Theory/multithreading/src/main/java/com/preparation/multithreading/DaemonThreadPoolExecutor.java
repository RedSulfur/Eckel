package com.preparation.multithreading;

import java.util.concurrent.*;

public class DaemonThreadPoolExecutor
        extends ThreadPoolExecutor{

    DaemonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(), new DaemonThreadFactory());
    }

}
