import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by kushalkanavi on 6/7/17.
 */

public class CrawlerThread extends Thread{

    CrawlerEngine ce;
    String url;

    public CrawlerThread(CrawlerEngine Engine) {
        ce = Engine;
    }


    public void run() {

        url = ce.getUrl();

        try {
            Document document = Jsoup.connect(url).get();
            Elements linksonpage = document.select("a[href]");

            for(Element e : linksonpage) {

                String Link = e.attr("abs:href");
                ce.addURL(Link);
            }
            System.out.println(Thread.currentThread().getName()+"-"+ce.getQ());

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}