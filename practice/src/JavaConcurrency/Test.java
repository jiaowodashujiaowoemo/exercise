package JavaConcurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description synchronized和Lock
 * @Author ChenXiang
 * @Date 2019/03/01,09:46
 */
class SyncTest{
    private  int value=0;
    Lock lock=new ReentrantLock();

    public synchronized void addValueSync(){
        this.value++;
        System.out.println(Thread.currentThread().getName()+":"+value);
    }

    public void addValueLock(){
        try {
            lock.lock();
            this.value++;
            System.out.println(Thread.currentThread().getName()+":"+value);
        }finally {
            lock.unlock();
        }
    }
}

public class Test {
    public static void main(String[] args) {
        final SyncTest st=new SyncTest();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    st.addValueSync();
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    st.addValueLock();
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
