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
public class CreateUserReq extends AbstractHttpSpecification{


      @SerializedName("id")
      @Expose
      private Integer id;
      @SerializedName("username")
      @Expose
      private String username;
      @SerializedName("firstName")
      @Expose
      private String firstName;
      @SerializedName("lastName")
      @Expose
      private String lastName;
      @SerializedName("email")
      @Expose
      private String email;
      @SerializedName("password")
      @Expose
      private String password;
      @SerializedName("phone")
      @Expose
      private String phone;
      @SerializedName("userStatus")
      @Expose
      private Integer userStatus;

      @Override
      protected HttpMethod getHttpMethod(){return HttpMethod.POST;}


      protected String getEndpointUrl(){ return Properties.JSONPLACEHOLDER_API + "/user";}
}
