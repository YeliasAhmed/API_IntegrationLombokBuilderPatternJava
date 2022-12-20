package base;

import controllers.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.request.HttpRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


public class GatewayRequest {

    @Getter(AccessLevel.PUBLIC)
    private final HttpHeader header = new HttpHeader();

    @Setter
    @Getter(AccessLevel.PROTECTED)
    private  AbstractHttpSpecification body;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private HttpRequest httpRequest;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private HttpResponse httpResponse;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private Object serializationResponse;

    @Setter
    @Getter(AccessLevel.PROTECTED)
    private Class responseObjectType;

    public GatewayRequest forService(){return this;}

    public GatewayRequest usingHeaders(final HttpHeader httpHeader){
        this.headers = httpHeader;
        return this;
    }

    public PostsService postsService() {
        return new PostsService(this);
    }

    public UserService userService() {
        return new UserService(this);
    }

    public GatewayRequest send() {
        new HttpDispatcher().send(this);
        return this;
    }


}
