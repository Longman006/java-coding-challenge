package unbabel.app.tomasz.szypula.model;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class HttpURLConnectionHandler {
    private String username;
    private String apikey;

    public HttpURLConnectionHandler(String username, String apikey) {
        this.username = username;
        this.apikey = apikey;
    }

    public void sendPost(Translation translation) throws Exception {
        String url = "https://sandbox.unbabel.com/tapi/v2/translation/";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        /**
         * request method
         */
        con.setRequestMethod("POST");

        /**
         * request header
         */
        con.setRequestProperty("Authorization", "ApiKey "+username+":"+apikey);
        con.setRequestProperty("Content-Type","application/json");

        /**
         * Creating JSON String
         */
        HashMap<String,String> postHeaderMap = new HashMap<>();
        postHeaderMap.put("text_format","text");
        postHeaderMap.put("text",translation.getOriginalText());
        postHeaderMap.put("target_language",translation.getTargetLanguage());

        String jsonInputString = JsonParser.getJsonStringFromHashMap(postHeaderMap);

        /**
         * To make sure the connection will send data
         */
        con.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(jsonInputString);
        wr.flush();


        /**
         * Could use the response code in the future to handle different errors and answers
         */
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + jsonInputString);
        System.out.println("Response Code : " + responseCode);

        StringBuffer response = new StringBuffer();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());

        /**
         * Extract data from response
         */
        HashMap<String,String> responseHashMap = JsonParser.getHashMapFromJson(response.toString());
        translation.setStatus(responseHashMap.get("status"));
        translation.setSourceLanguage(responseHashMap.get("source_language"));
        translation.setUid(responseHashMap.get("uid"));

    }

    public void sendGet(Translation translation) throws Exception {

        String url = "https://sandbox.unbabel.com/tapi/v2/translation/" + translation.getUid() + "/";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        /**
         * request header
         */
        con.setRequestProperty("Authorization", "ApiKey "+username+":"+apikey);
        con.setRequestProperty("Content-Type","application/json");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
        HashMap<String,String> responseHashMap = JsonParser.getHashMapFromJson(response.toString());
        System.out.println(responseHashMap);
        translation.setStatus(responseHashMap.get("status"));
        translation.setTranslatedText(responseHashMap.get("translatedText"));

    }
}
