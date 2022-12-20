package services.users;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
public class GetUserByUsernameNotFoundResp{
    @SerializedName("code")
    private Integer code;
    @SerializedName("type")
    private String type;
    @SerializedName("message")
    private String message;
}
