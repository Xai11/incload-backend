package incload.request;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class SearhRequest {
    private String request;
    private ArrayList<String> urlFoundSites = new ArrayList<String>();
    public SearhRequest(String request){
        this.request = request;
    }
    public void Searh() {
        String replacedRequest = request.replaceAll(" ", "+");
        String url = "https://yandex.ru/search/xml?folderid=b1gh2cb3337u5i588rg2&apikey=AQVNxRhJDQhhufnpqJKc2TkDUT-pnXCBzdPu86Pq&query=" + replacedRequest + "&l10n=ru&sortby=rlv.order%253Ddescending&filter=strict&maxpassages=1&groupby=attr%253D.mode%253Dflat.groups-on-page%253D10.docs-in-group%253D1";

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

                System.out.println("GET Response Code: " + responseCode);

                System.out.println(response);
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                InputSource is = new InputSource(new StringReader(response.toString()));
                Document doc = builder.parse(is);

                NodeList nodeList = doc.getElementsByTagName("url");
                String urlSite;
                for (int i = 0; i < nodeList.getLength() && i < 5; i++) {
                    Element element = (Element) nodeList.item(i);
                    urlSite = element.getTextContent();
                    urlFoundSites.add(urlSite);
                    System.out.println(urlSite);
                }
                System.out.println(urlFoundSites);

            } else {
                System.out.println("GET request failed with code: " + responseCode);
                urlFoundSites.add("");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public ArrayList<String> getUrlFoundSites(){
        return urlFoundSites;
    }
}
