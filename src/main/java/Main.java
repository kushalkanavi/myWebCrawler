import java.util.Scanner;

/**
 * Created by kushalkanavi on 6/7/17.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        CrawlerEngine engine = new CrawlerEngine("https://www.yahoo.com");

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Number of URL's to be crawled");
        int n = scan.nextInt();

        for (int i=0;i<n;++i){
            Thread test =  new CrawlerThread(engine);
            test.start();
            test.join();
        }
    }
}
