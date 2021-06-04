package psafe;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * 假设是主物理内存
 */
class MyData {

    int  number = 0;

    public synchronized void addTo60() {
            this.number = 60;

    }

    public synchronized int getNumber() {
            return number;
    }
}

/**
 * 验证volatile的可见性
 * 1. 假设int number = 0， number变量之前没有添加volatile关键字修饰
 */
public class VolatileDemo {

    public static void main(String args []) {

        // 资源类
        MyData myData = new MyData();

        // AAA线程 实现了Runnable接口的，lambda表达式
        new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

                myData.addTo60();
        }, "AAA").start();

            while (myData.getNumber() == 0) {
                // main线程就一直在这里等待循环，直到number的值不等于零
            }


        // 按道理这个值是不可能打印出来的，因为主线程运行的时候，number的值为0，所以一直在循环
        // 如果能输出这句话，说明AAA线程在睡眠3秒后，更新的number的值，重新写入到主内存，并被main线程感知到了
        System.out.println(Thread.currentThread().getName() + "\t mission is over");

        /**
         * 最后输出结果：
         * AAA	 come in
         * AAA	 update number value:60
         * 最后线程没有停止，并行没有输出  mission is over 这句话，说明没有用volatile修饰的变量，是没有可见性
         */

    }
}