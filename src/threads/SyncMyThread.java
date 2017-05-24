package threads;

/**
 * Created by prubac on 5/24/2017.
 */
public class SyncMyThread extends Thread {

    String name;
    private int iterator;
    private static int n = 0;
    private static Object lock = new Object();

    public SyncMyThread(String name, int it) {
        this.name = name;
        this.iterator = it;
    }


    @Override
    public void run() {
        try {
            int i = 0;
            while (n < 30) {
                synchronized (lock) {
                    while (iterator != n - i * 3) {
                        lock.wait();
                    }
                    System.out.println(name + ": " + iterator + " finished");
                    n++;
                    lock.notifyAll();
                    System.out.println("Next iteration: " + n);
                }
                i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SyncMyThread("A", 0).start();
        new SyncMyThread("B", 1).start();
        new SyncMyThread("C", 2).start();
    }


}
