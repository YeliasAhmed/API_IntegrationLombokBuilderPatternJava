package helpers;

import base.HttpHeader;

import java.util.HashMap;

public class MandatoryHeaders {

    public static HttpHeader getHeaders(){
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-type", "application/json");
        map.put("Accept", "*/*");

        HttpHeader headers = new HttpHeader();
        headers.setHeaders(map);
        return headers;
    }
}
