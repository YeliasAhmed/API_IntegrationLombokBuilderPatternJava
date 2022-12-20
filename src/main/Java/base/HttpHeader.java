package base;

import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.experimental.Accessors;

import java.util.HashMap;

@Getter
@Setter
@Accessors
public class HttpHeader {

    @Singular private HashMap<String, String> headers = new HashMap<>();
    public void addHeader(String key, String value){headers.put(key, value);}
    public void removeHeader(String key){headers.remove(key);}
}
