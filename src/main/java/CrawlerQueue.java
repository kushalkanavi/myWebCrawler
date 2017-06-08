import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by kushalkanavi on 6/7/17.
 */
public class CrawlerQueue {

     Queue<String> q = new ConcurrentLinkedQueue<String>();
     String url;

    public CrawlerQueue(String url) {
        q.add(url);
    }

    public Queue<String> getQ() {
        return q;
    }

    public void addURL(String url) {
        q.offer(url);
    }

    public String getUrl() {
        return q.poll();
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPageLink(){
        //url = q.poll();
        return url;
    }
}