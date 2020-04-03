package com.company.base.startAndRun;


/*
*
* start() : 它的作用是启动一个新线程，新线程会执行相应的run()方法。start()不能被重复调用。
* run()   : run()就和普通的成员方法一样，可以被重复调用。单独调用run()的话，会在当前线程中执行run()，而并不会启动新线程！
* */

class MyThread extends Thread{
    public MyThread(String name) {
          super(name);
     }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is running");
    }
}


/*
*
*(01) Thread.currentThread().getName()是用于获取“当前线程”的名字。当前线程是指正在cpu中调度执行的线程。
*(02) mythread.run()是在“主线程main”中调用的，该run()方法直接运行在“主线程main”上。
*(03) mythread.start()会启动“线程mythread”，“线程mythread”启动之后，会调用run()方法；此时的run()方法是运行在“线程mythread”上。
* */
public class demo {
    public static void main(String[] args) {
        Thread mythread=new MyThread("mythread");

        System.out.println(Thread.currentThread().getName()+" main mythread.run()");
        mythread.run();

        System.out.println(Thread.currentThread().getName()+" call mythread.start()");
        mythread.start();   //start()实际上是通过本地方法start0()启动线程的。而start0()会新运行一个线程，新线程会调用run()方法。


    }
}
