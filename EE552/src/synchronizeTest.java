///**
// * @author Donglin Chen
// * @create 2020-02-21-23:17
// */
//public class synchronizeTest {
//    public static void main(String[] args) throws InterruptedException {
//        ticketBunker tb=new ticketBunker();
//
//        Thread win1=new Thread(tb);
//        Thread win2=new Thread(tb);
//        Thread win3=new Thread(tb);
//
//
//        win1.start();
//
//        win2.start();
//
//        win3.start();
//    }
//}
//
//class ticketBunker implements Runnable {
//    int ticket = 200;
//    Integer i=new Integer(5);
//
//    @Override
//    public void run() {
//
//        synchronized (i) {
//            while (ticket > 0) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                System.out.println(Thread.currentThread().getName() + "票号：" + ticket);
//                ticket--;
//            }
//        }
//
//    }
//}
class Window1 implements Runnable{

    private int ticket = 10000;
    //    Object obj = new Object();
//    Dog dog = new Dog();
    @Override
    public void run() {
//        Object obj = new Object();
        while(true){
            synchronized (this){//此时的this:唯一的Window1的对象   //方式二：synchronized (dog) {

                if (ticket > 0) {

//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);


                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}


public class synchronizeTest {
    public static void main(String[] args) throws InterruptedException {
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
        while(true){
            t1.yield();
            t2.yield();
            t3.yield();
        }

    }

}