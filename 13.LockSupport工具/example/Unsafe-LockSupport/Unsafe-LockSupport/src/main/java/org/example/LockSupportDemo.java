package org.example;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Mark
 * @version 1.0
 * @project Unsafe-LockSupport
 * @description locksupport 工具的demo
 * @date 2024/3/17 20:27:41
 */
public class LockSupportDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            //当前线程 被调用 park方法，线程状态转为 WAITTING
            long timeMillis = System.currentTimeMillis();
            System.out.println("当前线程" + Thread.currentThread().getName() + "被阻塞（park）" + "时间是 " + timeMillis);
            LockSupport.park();
            //当前线程 被其他线程 调用的 unpark方法唤醒，继续先下执行
            System.out.println(Thread.currentThread().getName() + "被唤醒");
            System.out.println("被唤醒时间是 " + (System.currentTimeMillis() - timeMillis));
        });
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(thread);
    }
}
