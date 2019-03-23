package java_base;

/**
 * Created by hbs on 2019/3/22.
 */
class MyRunable implements Runnable {
    Integer a=new Integer(10);

    @Override
    public void run() {
        synchronized(a) {
//            try {
//                for (int i = 0; i < 5; i++) {
//                    Thread.sleep(100); // 休眠100ms
//                    System.out.println(Thread.currentThread().getName() + " loop " + i);
//                }
//            } catch (InterruptedException ie) {
//            }

            for (int i = 0; i < 5; i++) {
                System.out.println(a--);

            }



        }
    }
}

public class Demo1_1 {

    public static void main(String[] args) {
        Runnable demo = new MyRunable();     // 新建“Runnable对象”

//        Thread t1 = new Thread(demo, "t1");  // 新建“线程t1”, t1是基于demo这个Runnable对象
//        Thread t2 = new Thread(demo, "t2");  // 新建“线程t2”, t2是基于demo这个Runnable对象
//        t1.start();                          // 启动“线程t1”
//        t2.start();                          // 启动“线程t2”

        MyThread t1 = new MyThread();  // 新建“线程t1”, t1是基于demo这个Runnable对象
        MyThread t2 = new MyThread();  // 新建“线程t2”, t2是基于demo这个Runnable对象
        t1.start();                    // 启动“线程t1”
        t2.start();                          // 启动“线程t2”
    }
}