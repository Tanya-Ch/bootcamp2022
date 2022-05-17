import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMap3 {
    public static void main(String args[]) throws InterruptedException {
        Map<TempValue, TempValue> myMap = new ConcurrentHashMap<>(); // Concurrent access to a map III
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

        for (Thread thread : listOfThreads) {
            thread.join();
        }
        System.out.println("Count should be 30000, actual is : " + myMap.size());
    }
}