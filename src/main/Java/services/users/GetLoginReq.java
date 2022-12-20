package services.users;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Builder
@Accessors(chain = true)
public class GetLoginReq {
    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("id")
    @Expose
    private String password;
}
