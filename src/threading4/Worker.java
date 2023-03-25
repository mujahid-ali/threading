package src.threading4;

import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Worker {

    private Random random = new Random();

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();
 
    //private synchronized void stageOne() {
    // this will increase the time as there is only one lock for the object and this method will acquire that lock, hence no benefit
    // of threading in place of using method sync block sync is more useful

    private void stageOne() {

        
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        synchronized(lock1) {
            list1.add(random.nextInt(100));
        }

    }

    private synchronized void stageTwo() {

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        synchronized(lock2) {
            list2.add(random.nextInt(100));
        }
    }

    private void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public void main() {
        
        System.out.println("Starting........");
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                process();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("Time Taken " + (end - start));
        System.out.println("List1 " + list1.size() + " List2 " + list2.size() );

    }
    
}
