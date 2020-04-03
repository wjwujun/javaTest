package com.company.synchronizeD;


/*

synchronized代码块中的this是指当前对象。也可以将this替换成其他对象，例如将this替换成obj，则foo2()在执行synchronized(obj)时就获取的是obj的同步锁。
synchronized代码块可以更精确的控制冲突限制访问区域，有时候表现更高效率。下面通过一个示例来演示：

*/
public class synchronizedBlock {

    //synchronized方法 和
    public static synchronized void synMethod() {
        for(int i=0; i<1000000; i++)
            ;
    }
    //synchronized代码块
    public void synBlock() {
        synchronized( this ) {
            for(int i=0; i<1000000; i++)
                ;
        }
    }
}
