import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kushalkanavi on 6/7/17.
 */
public class Main {

    public void run(String[] args) throws InterruptedException {
        ExecutorService executer = Executors.newFixedThreadPool(10);

        CrawlerQueue queue = new CrawlerQueue("https://www.yahoo.com");

        for (int i=0; i<2; ++i) {
            System.out.println("Starting thread " + i);
            executer.execute(new CrawlerThread(queue));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Main().run(args);
    }
}