package com.company.base.runnable;

public class MyThread implements Runnable{

    private int ticket=10;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
                if (this.ticket>0){
                    System.out.println(Thread.currentThread().getName()+"---卖票"+this.ticket--);
                }
        }
    }
}
