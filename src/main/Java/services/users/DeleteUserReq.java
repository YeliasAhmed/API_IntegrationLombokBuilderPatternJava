package services.users;

import base.AbstractHttpSpecification;
import base.Properties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mashape.unirest.http.HttpMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Builder
@Getter
@Setter
@Accessors(chain = true)
public class DeleteUserReq extends AbstractHttpSpecification {

    @SerializedName("username")
    @Expose
    private String username;

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.DELETE;
    }

    @Override
    protected String getEndpointUrl() {
        return Properties.JSONPLACEHOLDER_API + "/user/" + username;
    }
}
