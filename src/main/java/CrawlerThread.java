import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by kushalkanavi on 6/7/17.
 */

public class CrawlerThread implements Runnable {
    private CrawlerQueue ce;

    public CrawlerThread(CrawlerQueue queue) {
        this.ce = queue;
    }


    public void run() {
        while(true) {
            String url = ce.getUrl();

            if (url == null) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    // No-op
                }
                continue;
            }

            System.out.println("Crawling : " + url);

            try {
                Document document = Jsoup.connect(url).get();
                Elements linksonpage = document.select("a[href]");

                for(Element e : linksonpage) {

                    String Link = e.attr("abs:href");
                    ce.addURL(Link);
                }

                System.out.println(Thread.currentThread().getName() + "-" + ce.getQ());

            } catch (Exception e) {
                // no-op
            }
        }
    }
}