import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

public class Main {
    static List<Integer> getCodes() throws Exception {
        System.setIn(new FileInputStream("TEST.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Set<Integer> codes = new HashSet<>();
        String line = "";
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(br.readLine());
            int code = Integer.parseInt(st.nextToken().substring(0, 5));
            System.out.println(st.nextToken());
            codes.add(code);
        }
        System.out.println(codes.size());
        return new ArrayList<>(codes);
    }

    static void saveXML(int code) {
        String apiKey = "achd2XS22Ewnyyh1h1%2F%2FVT5GOayHGPrV94Dk2aev3fbYlbVTDjt4BSEW22Yprr2as2oeDY5QvrR%2FuHedoT2pqA%3D%3D";
        String LAWD_CD = String.valueOf(code);
        String DEAL_YMD = "202301";

        try {
            String url = "http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTrade?";
            url += "serviceKey=" + URLEncoder.encode(apiKey, "UTF-8");
            url += "&" + URLEncoder.encode("LAWD_CD", "UTF-8") + "=" + URLEncoder.encode(LAWD_CD, "UTF-8");
            url += "&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "=" + URLEncoder.encode(DEAL_YMD, "UTF-8");
            System.out.println(url);

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            InputSource inputSource = new InputSource(new StringReader(response.toString()));
            Document doc = dBuilder.parse(inputSource);

            doc.getDocumentElement().normalize();

            NodeList itemList = doc.getElementsByTagName("item");

            JSONArray jsonArray = new JSONArray();

            for (int i = 0; i < itemList.getLength(); i++) {
                Node itemNode = itemList.item(i);
                if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element itemElement = (Element) itemNode;

                    String roadName = itemElement.getElementsByTagName("도로명").item(0).getTextContent().trim();
                    String roadNumCode = itemElement.getElementsByTagName("도로명건물본번호코드").item(0).getTextContent().trim();
                    String apartment = itemElement.getElementsByTagName("아파트").item(0).getTextContent().trim();
                    String transactionAmount = itemElement.getElementsByTagName("거래금액").item(0).getTextContent().trim();
                    String floor = itemElement.getElementsByTagName("층").item(0).getTextContent().trim();

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("도로명", roadName);
                    jsonObject.put("도로명건물본번호코드", roadNumCode);
                    jsonObject.put("아파트", apartment);
                    jsonObject.put("거래금액", transactionAmount);
                    jsonObject.put("층", floor);

                    jsonArray.add(jsonObject);
                }
            }

            FileWriter fileWriter = new FileWriter("output.json");
            fileWriter.write(jsonArray.toString()); // 4는 들여쓰기 수준
            fileWriter.close();

            System.out.println("JSON 파일이 생성되었습니다.");

            System.out.println(response); // 서버에서 받은 데이터 출력
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
    static void detailSaveXML(int code) {
        String apiKey = "8bNMSXgVBuMruOkav59Ebi3f1S24GGm5ls7ojz3aapZD1nH5P2uPp4pswd8jjZVendxDhFf38ZgyJSfvlTP2nw==";
        String LAWD_CD = String.valueOf(code);
        String DEAL_YMD = "202301";

        try {
            String url = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?";
            url += "serviceKey=" + URLEncoder.encode(apiKey, "UTF-8");
            url += "&" + URLEncoder.encode("LAWD_CD", "UTF-8") + "=" + URLEncoder.encode(LAWD_CD, "UTF-8");
            url += "&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "=" + URLEncoder.encode(DEAL_YMD, "UTF-8");
            url += "&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(1), "UTF-8");
            url += "&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(30), "UTF-8");

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            InputSource inputSource = new InputSource(new StringReader(response.toString()));
            Document doc = dBuilder.parse(inputSource);

            doc.getDocumentElement().normalize();

            NodeList itemList = doc.getElementsByTagName("item");

            JSONArray jsonArray = new JSONArray();

            for (int i = 0; i < itemList.getLength(); i++) {
                Node itemNode = itemList.item(i);
                if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element itemElement = (Element) itemNode;

                    String apartment = itemElement.getElementsByTagName("아파트").item(0).getTextContent().trim();
                    String floor = itemElement.getElementsByTagName("층").item(0).getTextContent().trim();
                    String area = itemElement.getElementsByTagName("전용면적").item(0).getTextContent().trim();
                    String dong = itemElement.getElementsByTagName("법정동").item(0).getTextContent().trim();
                    String transactionAmount = itemElement.getElementsByTagName("거래금액").item(0).getTextContent().trim();
                    String sojae = itemElement.getElementsByTagName("중개사소재지").item(0).getTextContent().trim();
                    String jibun = itemElement.getElementsByTagName("지번").item(0).getTextContent().trim();

                    JSONObject jsonObject = new JSONObject();

                    jsonObject.put("apt", apartment);
                    jsonObject.put("floor", floor);
                    jsonObject.put("area", area);
                    jsonObject.put("dong", dong);
                    jsonObject.put("price", transactionAmount);
                    jsonObject.put("sojae", sojae);
                    jsonObject.put("jibun", jibun);

                    jsonArray.add(jsonObject);
                }
            }

            FileWriter fileWriter = new FileWriter(String.valueOf(code) + ".json");
            fileWriter.write(jsonArray.toString()); // 4는 들여쓰기 수준
            fileWriter.close();

            System.out.println("JSON 파일이 생성되었습니다.");

            System.out.println(response); // 서버에서 받은 데이터 출력
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws Exception {
        List<Integer> codes = getCodes();
        for(int code: codes) {
            detailSaveXML(code);
        }
    }
}
