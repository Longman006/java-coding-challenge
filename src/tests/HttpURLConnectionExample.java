package tests;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionExample {


    public static void main(String[] args) throws Exception {

        try {
            HttpURLConnectionExample http = new HttpURLConnectionExample();

            System.out.println("Testing 1 - Send Http GET request");
            http.sendGet();

            System.out.println("\nTesting 2 - Send Http POST request");
            http.sendPost();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }


    }

    // HTTP GET request
    private void sendGet() throws Exception {

        String url = "https://sandbox.unbabel.com/tapi/v2/translation/dfb3944663/";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("Authorization", "ApiKey fullstack-challenge:9db71b322d43a6ac0f681784ebdcc6409bb83359");
        con.setRequestProperty("Content-Type","application/json");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    // HTTP POST request
    private void sendPost() throws Exception {

        String url = "https://sandbox.unbabel.com/tapi/v2/translation/";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        //add request header
        con.setRequestProperty("Authorization", "ApiKey fullstack-challenge:9db71b322d43a6ac0f681784ebdcc6409bb83359");
        con.setRequestProperty("Content-Type","application/json");

        String jsonInputString = "{\"text\" : \"Testing data output stream\", \"target_language\" : \"pt\", \"text_format\" : \"text\"}";
        //String urlParameters = URLEncoder.encode(urlParametersRaw,"UTF-8");
        System.out.println(jsonInputString);

        // Ensure the Connection Will Be Used to Send Content
        con.setDoOutput(true);

//        try(OutputStream os = con.getOutputStream()) {
//            byte[] input = jsonInputString.getBytes("utf-8");
//            os.write(input, 0, input.length);
//        }

        try(DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.writeBytes(jsonInputString);
            wr.flush();
            wr.close();
        }
        catch(IOException exception) {
            throw exception;
        }

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + jsonInputString);
        System.out.println("Response Code : " + responseCode);

        try(BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

}
