import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentTest {

    private  static class ConcurrentArray extends ArrayList<Integer>{
        @Override
        public synchronized boolean add(Integer integer) {

            return super.add(integer);
        }
    }

    static int THREADCOUNT = 4;     // Set to no cores. If more, we also benchmark the overhead from the scheduler
    static int ITERATIONS = 10000;     // Set to no cores. If more, we also benchmark the overhead from the scheduler


    private void runCollectionTest(Collection<Integer> collection) throws InterruptedException {
        System.out.println("\nRunning test for " + collection.getClass());
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREADCOUNT ; i++) {
            threads.add(new Thread(){
                @Override
                public void run() {
                    Random r = new Random();
                    long t1 = System.nanoTime();
                    for (int j = 0; j < ITERATIONS; j++) {
                        collection.add(r.nextInt());
                        //     System.out.println(Thread.currentThread().getName());
                    }
                    long t2 = System.nanoTime();
                    System.out.println(Thread.currentThread().getName() + ": " + ((t2-t1)*1e-6));
                    super.run();

                }
            });

        }
        for(Thread t : threads){
            t.start();
            t.join();
        }


    }
    private void runMapTest(Map<Integer, Integer> collection) throws InterruptedException {
        System.out.println("\nRunning test for " + collection.getClass());
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREADCOUNT ; i++) {
            threads.add(new Thread(){
                @Override
                public void run() {
                    Random r = new Random();
                    long t1 = System.nanoTime();
                    for (int j = 0; j < ITERATIONS; j++) {
                        collection.put(r.nextInt(), r.nextInt());
                        //     System.out.println(Thread.currentThread().getName());
                    }
                    long t2 = System.nanoTime();
                    System.out.println(Thread.currentThread().getName() + ": " + ((t2-t1)*1e-6) );
                    super.run();

                }
            });

        }
        for(Thread t : threads){
            t.start();
            t.join();
        }


    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentTest ct = new ConcurrentTest();

        ct.runCollectionTest(new ArrayList<>());
        ct.runCollectionTest(new ConcurrentLinkedQueue<>());
        ct.runCollectionTest(Collections.synchronizedList(new ArrayList<>()));

        ct.runCollectionTest(new ConcurrentArray());
        ct.runCollectionTest(new CopyOnWriteArrayList<>());
        ct.runCollectionTest(new CopyOnWriteArraySet<>());

        ct.runMapTest(new HashMap<>());
        ct.runMapTest(new ConcurrentHashMap<>());
        ct.runMapTest(new LinkedHashMap<>());
        ct.runMapTest(new Hashtable<>());
        ct.runMapTest(Collections.synchronizedMap(new HashMap<Integer, Integer>()));

    }


}
