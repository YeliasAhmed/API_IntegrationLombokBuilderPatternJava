package base;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;
import java.io.InputStream;

public class Serializer {


    public static Object serialize(HttpResponse<JsonNode> response, Class responseObjectType) {

        return serialize(response.getBody().toString(), responseObjectType);
    }

    public static Object serialize(String json, Class responseObjectType) {

        return new Gson().fromJson(json, responseObjectType);
    }

    public static Object convertJsonStringToObject(String filename, Class objectType) {

        JSONObject json = readJson(filename);
        return new Gson().fromJson(json.toString(), objectType);
    }


    private static JSONObject readJson(String filename) {

        JSONObject json;

        String file = "/templates/" + filename;
        InputStream is = Serializer.class.getResourceAsStream(file);

        if (is == null) {
            Assert.fail("Failed to find the file " + file);
        }

        String jsonTxt = null;
        try {
            jsonTxt = IOUtils.toString(is, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        json = new JSONObject(jsonTxt);

        return json;
    }
}



