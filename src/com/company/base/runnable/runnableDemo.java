package com.company.base.runnable;

/*
Thread 和 Runnable 的不同点：
        1、Thread 是类，而Runnable是接口；
        2、Thread本身是实现了Runnable接口的类。
        我们知道“一个类只能有一个父类，但是却能实现多个接口”，因此Runnable具有更好的扩展性。
        此外，Runnable还可以用于“资源的共享”，即多个线程都是基于某一个Runnable对象建立的，它们会共享Runnable对象上的资源。
        通常，建议通过“Runnable”实现多线程！
* */
public class runnableDemo {

    /*
    *
    * 和上面“MyThread继承于Thread”不同；这里的MyThread实现了Thread接口。
    * 主线程main创建并启动3个子线程，而且这3个子线程都是基于“mt这个Runnable对象”而创建的。运行结果是这3个子线程一共卖出了10张票。这说明它们是共享了MyThread接口的。
    * */
    public static void main(String[] args) {
        // 启动3个线程t1,t2,t3(它们共用一个Runnable对象)，这3个线程一共卖10张票！
        MyThread mt = new MyThread();
        Thread t1=new Thread(mt);
        Thread t2=new Thread(mt);
        Thread t3=new Thread(mt);
        t1.run();
        t2.run();
        t3.run();
    }
}
