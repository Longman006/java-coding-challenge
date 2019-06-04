package unbabel.app.tomasz.szypula.test;

import org.junit.jupiter.api.Test;
import unbabel.app.tomasz.szypula.model.JsonParser;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonParserTest {

    @org.junit.jupiter.api.Test
    public void JsonObjectToHashMapTest () throws Exception {
        String jsonInputString = "{\"text\" : \"Testing data output stream\", \"target_language\" : \"pt\", \"text_format\" : \"text\"}";
        HashMap<String, String> hmap = JsonParser.getHashMapFromJson(jsonInputString);

        HashMap<String,String> expectedHMap = new HashMap<>();
        expectedHMap.put("text","Testing data output stream");
        expectedHMap.put("target_language","pt");
        expectedHMap.put("text_format","text");

        assertTrue(expectedHMap.equals(hmap));
    }

    /**
     * Since elements in a hashmap don't have a specified order. In order to compare the output of JsonParser.getJsonStringFromHashMap(hashMap)
     * I will compare the input hashmap with the hashmap created from the String produced by JsonParser.getJsonStringFromHashMap(...)
     * @throws Exception
     */
    @Test
    public void HashMapToJsonStringTest() throws Exception {
        String expectedJsonString = "{\"text\" : \"Testing data output stream\", \"target_language\" : \"pt\", \"text_format\" : \"text\"}";

        HashMap<String,String> expectedHashMap = new HashMap<>();
        expectedHashMap.put("text","Testing data output stream");
        expectedHashMap.put("target_language","pt");
        expectedHashMap.put("text_format","text");

        String jsonString = JsonParser.getJsonStringFromHashMap(expectedHashMap);
        HashMap<String,String> hashMap = JsonParser.getHashMapFromJson(jsonString);

        assertTrue(expectedHashMap.equals(hashMap));

    }
}
