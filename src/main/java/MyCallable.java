import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() {
        int consoleOutputCounter = 0;
        try {
            Thread.sleep(2500);
            System.out.println("Всем привет! Я - " + Thread.currentThread().getName());
            consoleOutputCounter++;

        } catch (InterruptedException ignored) {
        }
        return consoleOutputCounter;
    }
}
