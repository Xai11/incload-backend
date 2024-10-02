package incload.service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class SearchService {
    private String request;
    private List<String> urlFoundSites = new ArrayList<>();
    public SearchService(String request){
        this.request = request;
        Searh();
    }
    public void Searh() {
        String replacedRequest = request.replaceAll(" ", "+");
        String url = "https://yandex.ru/search/xml?folderid=b1gh2cb3337u5i588rg2&apikey=AQVNxRhJDQhhufnpqJKc2TkDUT-pnXCBzdPu86Pq&query="
            + replacedRequest + 
            "&l10n=ru&sortby=rlv.order%253Ddescending&filter=strict&maxpassages=1&groupby=attr%253D.mode%253Dflat.groups-on-page%253D10.docs-in-group%253D1";

        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                InputSource is = new InputSource(new StringReader(response.toString()));
                Document doc = builder.parse(is);

                NodeList nodeList = doc.getElementsByTagName("url");
                String urlSite;

                for (int i = 0; i < nodeList.getLength() && i < 10; i++) {
                    Element element = (Element) nodeList.item(i);
                    urlSite = element.getTextContent();
                    urlFoundSites.add(urlSite);
                }
                if(urlFoundSites.isEmpty()){
                    urlFoundSites.add("Incorrect question");
                }

            } else {
                urlFoundSites.add("Error request");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public List<String> getUrlFoundSites(){
        return urlFoundSites;
    }
}
