/**
 * Created by kushalkanavi on 6/7/17.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        crawlerEngine engine = new crawlerEngine("https://www.yahoo.com");

        for (int i=0;i<10;++i){
            Thread test =  new crawlerThread(engine);
            test.start();
            test.join();
        }
    }
}
