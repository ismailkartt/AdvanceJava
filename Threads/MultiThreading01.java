package Threads;

// Burada amacımız thread kullanılan işlemlerim threadsiz işlemlere göre hız farkı
public class MultiThreading01 {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        CounterWithoutMultiThread counter1 = new CounterWithoutMultiThread(1);
        CounterWithoutMultiThread counter2 = new CounterWithoutMultiThread(2);

        counter1.countMe();
        System.out.println("-----------");

        counter2.countMe();
        long endTime = System.currentTimeMillis();

        System.out.println("WithoutMultiThread ile Geçen süre : " + (endTime-startTime)); // 10 saniye

        System.out.println("*******************************");

        long startTime2 = System.currentTimeMillis();

        CounterWithMultiThread counter3 = new CounterWithMultiThread(1);
        CounterWithMultiThread counter4 = new CounterWithMultiThread(2);

        counter3.start();
        System.out.println("---------------");
        counter4.start();

        counter3.join(); // counter3 thread i bitesiye kdar bekle
        counter4.join(); // counter4 threadi bitesiye kadar bekle

        long endTime2 = System.currentTimeMillis();

        System.out.println("WitMultiThread ile Geçen süre : " + (endTime2-startTime2)); // 5 saniye


    }
}

// thread kullanılmayan method
class CounterWithoutMultiThread {
    private int threadNum;

    // const.
    public CounterWithoutMultiThread(int threadNum) {
        this.threadNum = threadNum;
    }

    public void countMe() throws InterruptedException {
        for(int i=1;i<=10;i++){
            Thread.sleep(500); //0.5 saniye yavaşlattım, yavaşlatılan thread Main thread dir
            System.out.println("i"+i + "Thread number : " + threadNum);
        }
    }
}

// thread ile method
class CounterWithMultiThread extends Thread {
    private int threadNum;

    public CounterWithMultiThread(int threadNum){
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        try {
            countMe();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void countMe() throws InterruptedException {
        for(int i=1;i<=10;i++){
            Thread.sleep(500); //0.5 saniye yavaşlattım
            System.out.println("i"+i + "Thread number : " + threadNum);
        }
    }
}


