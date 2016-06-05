package com.preparation.multithreading;

/*
Интерфейс Runnable представляет собой отдельную задачу,
которая выполняет некоторую работу, но не возвращает значения.
Если нужно, чтобы задача возвращала значение, необходимо
реализовать интерфейс Callable
*/

import java.util.ArrayList;
import java.util.concurrent.*;

public class TaskWithResult implements Callable<String>{

    private int id = 0;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "TaskWithResult " + id;
    }


    public static void main(String[] args) {

    // Обьект Future представляет собой результат асинхронного вычисления
        ArrayList<Future<String>> list = new ArrayList<>();
        ExecutorService exec = Executors.newCachedThreadPool();
        
        for (int i = 0; i < 10; i++) {
            list.add(exec.submit(new TaskWithResult(i)));
        }

        for (Future<String> fs : list) {
            if (fs.isDone()) {
                try {
                    System.out.println(fs.get());
                } catch (InterruptedException e) {
                    System.out.println(e);
                } catch (ExecutionException e) {
                    System.out.println(e);
                } finally {
                    exec.shutdown();
                }
            }
        }
    }

}
