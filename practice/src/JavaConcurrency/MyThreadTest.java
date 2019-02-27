package JavaConcurrency;

import java.util.concurrent.*;

/**
 * @Description 多线程实现方法，线程共四种状态：运行、就绪、挂起、结束
 * @Author ChenXiang
 * @Date 2019/02/26,14:46
 */
public class MyThreadTest {

    /**
     * 1、继承Thread类，重写run()方法，Thread类实际也是Runnable的一个实现类
     * 2、创建对象，调用Thread类的start()方法，start方法是一个native方法，它将启动一个新线程，并执行run()方法
     * 注意：调用start()方法后，并不是立即执行多线程代码，而只是使该线程变为可运行状态。
     */
    public static class  MyThread1 extends Thread{
       public void run(){
           System.out.println("Thread Body");
       }
    }

    /**
     * 1、实现Runnable接口，并实现该接口的run()方法
     * 2、创建Thread对象，用实现Runnable接口的对象作为参数实例化该Thread对象
     * 3、调用Thread的run()方法
     * 实现Runnable接口后必须重写run()方法，而且也只能重写run()方法，start()方法不能重写
     */
    public static class MyThread2 implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread Body");
        }
    }


    /**
     * Callable接口是Executor框架中的功能类，与Runnable功能类似，但是功能更强大
     * 1、可以在任务结束后提供一个返回值，Runnable不能
     * 2、它的call()方法可以抛出异常，Runnable的run()方法不能
     * 3、运行Callable可以拿到一个Future对象，Future表示一个任务的生命周期，并提供相应方法来判断是否已经完成或取消，以及获取任务的结果和取消任务等
     * 在Executor框架中，已提交但尚未开始的任务可以取消，对于已经开始的任务，只有当它们能响应中断的时候，才能取消。取消一个已经完成的任务不会有任何影响。
     * 要使用Callable来表示无返回值的任务，可以使用Callable<Void>
     * 当调用Future的get()方法获取结果时，当前线程会阻塞，直到返回结果
     */
    public static class MyThread3 implements Callable<String>{
        @Override
        public String call() throws Exception {
            return "Hello World!";
        }
    }

    public static void main(String[] args) {
        /**
         * 前两种方法实际都是通过Thread的对象API来控制线程的
         */
        MyThread1 thread1 = new MyThread1();
        thread1.start();
//      thread1.run();//这样的方法是错误的，只运行了一次run()方法，并没有启动线程，只是一个普通的方法调用

        MyThread2 thread2 = new MyThread2();
        Thread t = new Thread(thread2);
        t.start();
//        t.run();
/**
 * start()方法能够异步地调用run()方法，但是直接调用run()方法却是同步的，无法达到多线程的目的。
 */

        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //启动线程
        Future<String> future = threadPool.submit(new MyThread3());
        try {
            System.out.println("waiting thread to finish");
            System.out.println(future.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}