package base;

import com.mashape.unirest.http.HttpMethod;

public abstract class AbstractHttpSpecification {

    protected abstract HttpMethod getHttpMethod();
    protected abstract  String getEndpointUrl();


}
