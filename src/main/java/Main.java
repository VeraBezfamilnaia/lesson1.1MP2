import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> task1 = new MyCallable();
        Callable<Integer> task2 = new MyCallable();
        Callable<Integer> task3 = new MyCallable();
        Callable<Integer> task4 = new MyCallable();

        Collection<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        executeAllTasksAndGetResults(tasks);
        System.out.println("_______________________");
        executeAllTasksAndGOneResult(tasks);
    }

    private static void executeAllTasksAndGOneResult(Collection<Callable<Integer>> tasks) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        printResult(pool.invokeAny(tasks));
        pool.shutdown();
    }

    private static void executeAllTasksAndGetResults(Collection<Callable<Integer>> tasks) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (Callable<Integer> task : tasks) {
            Future<Integer> future = pool.submit(task);
            printResult(future.get());
        }
        pool.shutdown();
    }

    private static void printResult(Integer result) {
        System.out.println(result);
    }
}
