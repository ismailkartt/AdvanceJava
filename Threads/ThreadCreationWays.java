package Threads;

public class ThreadCreationWays {

    public static void main(String[] args) {
        // ilk çalışan thread main thread dir, kontrol edelim :
        System.out.println("Current Thread : " + Thread.currentThread().getName()); // main

        MyThread thread1 = new MyThread();
        //thread1.run();
        thread1.start(); // thread sınıfında run() metodunda yazılanlar işlenmeye başlar
        // run() diyerekte çağırdığımızda method yine çalışıyor , start() ile çağırmamız
            // arasındaki fark : run() ile çağırıldığında thread değişmez sadece methos çalışır
            // start() da ise önce thread ayağa kalkar daha sonra içindeki run() metodu çalışır

        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        // !!! isimsiz olarak thread oluşturma , annonymous (Interface)
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000); // 3 saniye uyu
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Current Thread : " + Thread.currentThread().getName());
                System.out.println("Bu isimsiz sınıf yoluyla oluşturulan iş parçacığıdır");
            }
        });

        thread3.setName("Thread3"); // thread 3 e isim verdik
        thread3.start();

        // !!! isimsiz olarak thread oluşturalım 2.yol
        Thread thread4 = new Thread(()->{
            System.out.println("lambda ile yazıldı");
        });
        thread4.start();

        System.out.println("Main metodu bitti"); // bu yazı çıktının neresinde gözükeceği ile ilgili kesin birşey diyemeyiz

        Thread thread5 = new Thread(()->{
            System.out.println("thread5 çalıştı");
        });
        thread5.start();
    }


}
// Threadleri Nasıl Oluşturabiliriz ?
// 1.yol : Thread classını extend ederek
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread threadı calışıyor");
    }
}

// 2.yol : Runnable Interfacei implement ederek
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable Interfaceden türetilen thread çalıştı");
    }
}
