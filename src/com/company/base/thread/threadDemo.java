package com.company.base.thread;


/*
Thread 和 Runnable 的不同点：
        1、Thread 是类，而Runnable是接口；
        2、Thread本身是实现了Runnable接口的类。
        我们知道“一个类只能有一个父类，但是却能实现多个接口”，因此Runnable具有更好的扩展性。
        此外，Runnable还可以用于“资源的共享”，即多个线程都是基于某一个Runnable对象建立的，它们会共享Runnable对象上的资源。
        通常，建议通过“Runnable”实现多线程！
* */
public class threadDemo {

    /*
    (01) MyThread继承于Thread，它是自定义个线程。每个MyThread都会卖出10张票。
    (02) 主线程main创建并启动3个MyThread子线程。每个子线程都各自卖出了10张票。
    * */
    public static void main(String[] args) {
        // 启动3个线程t1,t2,t3；每个线程各卖10张票！
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.run();
        t2.run();
        t3.run();
    }
}




