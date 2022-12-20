package services.users;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetUserByUsernameReq {

    @SerializedName("username")
    @Expose
    private String username;


}
