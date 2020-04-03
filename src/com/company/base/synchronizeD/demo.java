package com.company.base.synchronizeD;

/*
* synchronized原理：
*  1、在java中，每一个对象有且仅有一个同步锁。这也意味着，同步锁是依赖于对象而存在
*  2、当我们调用某对象的synchronized方法时，就获取了该对象的同步锁。例如，synchronized(obj)就获取了“obj这个对象”的同步锁
*  3、不同线程对同步锁的访问是互斥的。也就是说，某时间点，对象的同步锁只能被一个线程获取到！通过同步锁，我们就能在多线程中，实现对“对象/方法”的互斥访问。 例如，现在有两个线程A和线程B，它们都会访问“对象obj的同步锁”。假设，在某一时刻，线程A获取到“obj的同步锁”并在执行一些操作；而此时，线程B也企图获取“obj的同步锁” —— 线程B会获取失败，它必须等待，直到线程A释放了“该对象的同步锁”之后线程B才能获取到“obj的同步锁”从而才可以运行
*
*    synchronized的基本规则总结为下面3条，并通过实例对它们进行说明。
*/
public class demo {
    public static void main(String[] args) {
                //rule1();  //第一条: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
                //rule1_1();
                //rule2();           //第二条: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程仍然可以访问“该对象”的非同步代码块。
                //rule3();         //第三条: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对“该对象”的其他的“synchronized方法”或者“synchronized代码块”的访问将被阻塞。

                block();       //代码块和方法
    }



    public static void  rule1(){
        Runnable demo = new MyRunable();     // 新建“Runnable对象”
        Thread t1 = new Thread(demo, "t1");  // 新建“线程t1”, t1是基于demo这个Runnable对象
        Thread t2 = new Thread(demo, "t2");  // 新建“线程t2”, t2是基于demo这个Runnable对象
        t1.start();                          // 启动“线程t1”
        t2.start();                          // 启动“线程t2”
    }
    public static void  rule1_1(){
        MyThread t1 = new MyThread("t1");   // 新建“线程t1”
        MyThread t2 = new MyThread("t2");  // 新建“线程t2”
        t1.start();                          // 启动“线程t1”
        t2.start();                          // 启动“线程t2”
    }
    public static void  rule2(){
            //主线程中新建了两个子线程t1和t2。t1会调用count对象的synMethod()方法，该方法内含有同步块；而t2则会调用count对象的nonSynMethod()方法，该方法不是同步方法。t1运行时，虽然调用synchronized(this)获取“count的同步锁”；但是并没有造成t2的阻塞，因为t2没有用到“count”同步锁。
            final Count count = new Count();
            Thread t1 = new Thread(          // 新建t1, t1会调用“count对象”的synMethod()方法
                   new Runnable() {
                       @Override
                       public void run() {
                           count.synMethod();
                       }
                   }, "t1");


           Thread t2 = new Thread(          // 新建t2, t2会调用“count对象”的nonSynMethod()方法
                   new Runnable() {
                       @Override
                       public void run() {
                           count.nonSynMethod();
                       }
                   }, "t2");


           t1.start();  // 启动t1
           t2.start();  // 启动t2
    }

    public static void  rule3(){
        //主线程中新建了两个子线程t1和t2。t1和t2运行时都调用synchronized(this)，这个this是Count对象(count)，而t1和t2共用count。因此，在t1运行时，t2会被阻塞，等待t1运行释放“count对象的同步锁”，t2才能运行。
        final Count count = new Count();
        Thread t1 = new Thread(          // 新建t1, t1会调用“count对象”的synMethod()方法
                new Runnable() {
                    @Override
                    public void run() {
                        count.synMethod();
                    }
                }, "t1");


        Thread t2 = new Thread(          // 新建t2, t2会调用“count对象”的nonSynMethod()方法
                new Runnable() {
                    @Override
                    public void run() {
                        count.nonSynMethod();
                    }
                }, "t2");


        t1.start();  // 启动t1
        t2.start();  // 启动t2
    }
    public static void  block(){
        synchronizedBlock demo = new synchronizedBlock();
        long start, diff;
        start = System.currentTimeMillis();                // 获取当前时间(millis)
        demo.synMethod();                                // 调用“synchronized方法”
        diff = System.currentTimeMillis() - start;        // 获取“时间差值”
        System.out.println("synMethod() : "+ diff);

        start = System.currentTimeMillis();                // 获取当前时间(millis)
        demo.synBlock();                                // 调用“synchronized方法块”
        diff = System.currentTimeMillis() - start;        // 获取“时间差值”
        System.out.println("synBlock()  : "+ diff);
    }

}





