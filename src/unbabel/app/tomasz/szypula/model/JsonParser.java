package unbabel.app.tomasz.szypula.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



public final class JsonParser {
    private JsonParser(){}

    /**
     * A very simple extracter for the soul purpose of this java challenge. In the future I would require to at least take into account situations where braces {}
     * occcur inside text and situations where interesting values are not strings for example : order number
     *
     * @param jsonInput The input string containing a simple JSON object with no nested classes
     * @return a hashmap containing key value pairs extracted from JSON string
     */
    public static HashMap<String,String> getHashMapFromJson(String jsonInput){
        /**
         * first string key, second value
         */
        HashMap<String,String> hashMap = new HashMap<>();

        //Get rid of braces
        jsonInput = jsonInput.replaceFirst("\\{"," ").replace("}"," ");

        //Get an array of key value pairs
        String[] tokens = jsonInput.split("[,]",0);

        //Insert keys and values to hashmap
        for (String string : tokens){
            String[] keyValue = string.split("[:]");
            if (keyValue.length == 2){
                //Getting rid of quotation marks and all white spaces before and after actual text
                for (int i = 0 ;i<keyValue.length ; i++){
                    try{
                        keyValue[i] = keyValue[i].substring(keyValue[i].indexOf("\"")+1, keyValue[i].lastIndexOf("\""));
                    }
                    catch (Exception e){
                        System.out.println(e);
                        //TODO what to do when the keyValue does not contain quotation marks
                    }
                }
                hashMap.put(keyValue[0],keyValue[1]);
            }
        }
        return hashMap;
    }

    public static String getJsonStringFromHashMap(HashMap<String,String> hashMap){
        /**
         * For iterating purposes
         * Extract Set from HashMap
         */
        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();

        /**
         * A StringBuffer to create JSON String
         */
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");

        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            stringBuffer.append("\""+ entry.getKey() + "\" : \"" + entry.getValue() + "\"");

            if (iterator.hasNext())
                stringBuffer.append(", ");
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
