import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by kushalkanavi on 6/7/17.
 */

public class crawlerThread extends Thread{

    crawlerEngine ce;
    String url;

    public crawlerThread(crawlerEngine Engine) {
        ce = Engine;
    }


    public void run() {

        url = ce.getUrl();

        try {
            Document document = Jsoup.connect(url).get();
            Elements linksonpage = document.select("a[href]");

            addLinksToQueue(linksonpage);

            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void addLinksToQueue(Elements el) {
        for(Element e : el) {

            String Link = e.attr("abs:href");
            ce.addURL(Link);
        }
        System.out.println(Thread.currentThread().getName()+"-"+ce.getQ());
    }
}