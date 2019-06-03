package unbabel.app.tomasz.szypula.model;

import java.util.HashMap;
import java.util.function.ToDoubleBiFunction;


public final class JsonParser {
    private JsonParser(){}

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
                //Getting rid of quotation marks and all white spaces before and after
                for (int i = 0 ;i<keyValue.length ; i++){
                    try{
                        keyValue[i] = keyValue[i].substring(keyValue[i].indexOf("\"")+1, keyValue[i].lastIndexOf("\""));
                    }
                    catch (Exception e){
                        System.out.println(e);
                        //TODO
                    }
                }
                hashMap.put(keyValue[0],keyValue[1]);
            }
        }
        return hashMap;

    }
}
