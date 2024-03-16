package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Mutex mutex = new Mutex();

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                mutex.lock();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.unlock();
                }
            });
            thread.start();
        }
    }
}
