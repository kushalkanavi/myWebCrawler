/**
 * Created by kushalkanavi on 6/7/17.
 */
public class Main {

    public static void main(String[] args){
        crawlerThread test = new crawlerThread("https://www.yahoo.com");
        Thread t = new Thread(test);

        for (int i=0; i<10;++i){
            t.start();
        }
    }
}
