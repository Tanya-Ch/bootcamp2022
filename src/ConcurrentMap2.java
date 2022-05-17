import java.util.*;

public class ConcurrentMap2 implements Runnable {
    public static void main(String args[]) throws InterruptedException {
        Map<TempValue, TempValue> myMap = Collections.synchronizedMap(new HashMap<>()); // Concurrent access to a map I
        List<Thread> listOfThreads = new ArrayList<>();

        // Create 10 Threads
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {

                // Let Each thread insert 3000 Items
                for (int j = 0; j < 3000; j++) {
                    TempValue key = new TempValue();
                    myMap.put(key, key);
                }

            });
            thread.start();
            listOfThreads.add(thread);
        }

        synchronized (listOfThreads){
        for (Thread thread : listOfThreads) {
            thread.join();
        }}
        System.out.println("Count should be 30000, actual is : " + myMap.size());
    }

    @Override
    public void run() {

    }
}
