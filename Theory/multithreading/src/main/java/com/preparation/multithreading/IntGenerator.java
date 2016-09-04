package com.preparation.multithreading;

public abstract class IntGenerator {
    protected boolean canceled = false;
    public abstract int next();
    public void cancel() { canceled = true; }
    public boolean isCanceled() { return canceled; }
}
