package com.xyzmst.myapplication;

import java.util.Observable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    static AtomicInteger count = new AtomicInteger();

    static Object moniter = new Object();

    static class A extends Thread {
        @Override
        public void run() {
            super.run();
            B b = new B();
            C c = new C();
            D d = new D();
            b.start();
            c.start();
            d.start();

            while (true) {
                synchronized (moniter) {
                    if (count.get() == 3) {
                        System.out.println("name: A");
                        break;
                    } else {
                        try {
                            moniter.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }

            Observable.zip(b,c,d)
                    .flatMap(new function(){
                a.
            })


        }




    }

    static class B extends Thread {
        @Override
        public void run() {
            super.run();
            synchronized (moniter){
                count.addAndGet(1);
                moniter.notifyAll();
                System.out.println("name: B");
            }

        }
    }

    static class C extends Thread {
        @Override
        public void run() {
            super.run();
            count.addAndGet(1);
            moniter.notifyAll();
            System.out.println("name: C");
        }
    }

    static class D extends Thread {
        @Override
        public void run() {
            super.run();
            count.addAndGet(1);
            moniter.notifyAll();
            System.out.println("name: D");
        }
    }


    public static void main(String[] args) {
        A a = new A();
        a.start();

        CountDownLatch c = new CountDownLatch(5);
    }

}
