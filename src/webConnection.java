import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class webConnection {
    public void readWeb() throws IOException{
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        Document document = connect.get();
        Element kurs = document.querySelector("#knowledge-currency__updatable-data-column > div.b1hJbf > div.dDoNo.ikb4Bb.gsrt > span.DFlfde.SwHCTb");
    }


}
