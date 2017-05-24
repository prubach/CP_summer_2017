package threads;

/**
 * Created by prubac on 5/24/2017.
 */
public class MyThread extends Thread {

    String name;
    private int iterator;
    private OurThreads ourThreads;
    private Thread nextThread;

    public MyThread(String name, OurThreads ourThreads) {
        this.name = name;
        this.ourThreads = ourThreads;
    }

    public MyThread(String name, OurThreads ourThreads,
                    Thread nextThread) {
        this.name = name;
        this.ourThreads = ourThreads;
        this.nextThread = nextThread;
    }


    @Override
    public void run() {
        try {
            // Wait for previous thread to finish
            //if (nextThread!=null) nextThread.join();
            while (iterator < 10) {
                iterator++;
                System.out.println(name + ": " + iterator);
                ourThreads.increase(name);
                this.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
