import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * Created by kushalkanavi on 6/7/17.
 */
public class crawlerThread implements Runnable{

    String url;
    List<String> l = new ArrayList<String>();

    public crawlerThread(String url) {
        this.url = url;
    }

    crawlerEngine ce = new crawlerEngine();

    public void run() {

        try {
            Document document = Jsoup.connect(url).get();
            Elements linksonpage = document.select("a[href]");

            for( int i=0;i<linksonpage.size();++i){
                Element link = linksonpage.get(i);
                System.out.println(link.attr("abs:href"));

                ce.setQ(link.attr("abs:href"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}