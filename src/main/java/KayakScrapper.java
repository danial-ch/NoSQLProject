
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class KayakScrapper {

    String url;

    public KayakScrapper(String url) {
        this.url = url;
    }

    public List<KayakFlights> getresult(){
        List<KayakFlights> flights = new LinkedList<>();
//        try {
////            final Document document = Jsoup.connect(url).get();
//////            List<Element> mainDiv = document.select(".Base-Results-ResultsList.Flights-Results-FlightResultsList");
////            final File f = new File("filename.html");
////            FileUtils.writeStringToFile(f, document.outerHtml(), StandardCharsets.UTF_8);
////            for (int i = 1 ; i < mainDiv.size(); i++) {
////                String departureTime = mainDiv.get(i).select("div.resultWrapper div.resultInner div").get(0).select("mainInfo div ol li div div").get(1).select("div span span").get(0).text();
////                System.out.println(departureTime);
////            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return flights;
    }
}
