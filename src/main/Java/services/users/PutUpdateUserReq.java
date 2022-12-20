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

@Getter
@Setter
@Builder
@Accessors(chain = true)
public class PutUpdateUserReq extends AbstractHttpSpecification {


        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("username")
        @Expose
       public String username;
        @SerializedName("firstName")
        @Expose
        public String firstName;
        @SerializedName("lastName")
        @Expose
       public String lastName;
        @SerializedName("email")
        @Expose
        public String email;
        @SerializedName("password")
        @Expose
        public String password;
        @SerializedName("phone")
        @Expose
        public String phone;
        @SerializedName("userStatus")
        @Expose
        public Integer userStatus;

        @Override
        protected HttpMethod getHttpMethod() {
                return HttpMethod.PUT;
        }

        @Override
        protected String getEndpointUrl() {
                return Properties.JSONPLACEHOLDER_API + "/user/" + username;
        }
}
