package threads;

/**
 * Created by prubac on 5/24/2017.
 */
public class OurThreads {

    Integer ourIter = 0;

    public synchronized void increase(String threadName) {
        System.out.println("Thread: " + threadName +
                " our iter: " + ourIter);
        ourIter++;
    }

    /*
    public void increase(String threadName) {
        //Object o = new Object();
        synchronized (ourIter) {
            System.out.println("Thread: " + threadName +
                    " our iter: " + ourIter);
            ourIter++;
        }
    }
*/

    public static void main(String[] args) {
        OurThreads ourThreads = new OurThreads();

        int numThreads = 5;
        MyThread[] threads = new MyThread[numThreads];
        Thread prevThread = null;
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new MyThread("T_" + i, ourThreads, prevThread);
            prevThread = threads[i];
        }
        for (int i = 0; i < numThreads; i++) {
            threads[i].start();
        }


/*
        MyThread threadA = new MyThread("A",  ourThreads);
        MyThread threadB = new MyThread("B",  ourThreads);
        MyThread threadC = new MyThread("C",  ourThreads);

        //threadA.run();
        //threadB.run();

        threadA.start();
        threadB.start();
        threadC.start();
*/

    }
}
