package com.xuge.javatest;

public class ThreadLocalTest {
    public static final void main(String[] args) {
        final ThreadLocal<Boolean> booleanThreadLocal = new ThreadLocal<>();
        booleanThreadLocal.set(true);
        print(booleanThreadLocal);

        new Thread(new Runnable() {
            @Override
            public void run() {
                booleanThreadLocal.set(false);
                print(booleanThreadLocal);
            }
        }, "Thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                print(booleanThreadLocal);
            }
        }, "Thread2").start();
    }

    private static void print(ThreadLocal<Boolean> booleanThreadLocal) {
        System.out.println("Thread : " + Thread.currentThread().getName()
                + "  -->  booleanThreadLocal = " + booleanThreadLocal.get());
    }

}
