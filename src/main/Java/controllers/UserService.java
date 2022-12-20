package controllers;

import base.GatewayRequest;
import services.users.*;

public class UserService {
    private GatewayRequest gatewayRequest;
    public UserService(GatewayRequest gatewayRequest){this.gatewayRequest= gatewayRequest;}

    public GatewayRequest createUserRq(CreateUserReq createUserReq){
        gatewayRequest.setBody(createUserReq);
        gatewayRequest.setResponseObjectType(CreateUserResp.class);
        return gatewayRequest;
    }

    public GatewayRequest getLoginReq(GetLoginReq loginReq){
        gatewayRequest.setBody(loginReq);
        gatewayRequest.setResponseObjectType(GetLoginResp.class);
        return gatewayRequest;
    }

    public GatewayRequest getUserByUsernameReq(GetUserByUsernameReq userByUsernameReq){
        gatewayRequest.setBody(userByUsernameReq);
        gatewayRequest.setResponseObjectType(GetUserByUsernameResp.class);
        return gatewayRequest;
    }

    public GatewayRequest putUpdateUserReq(PutUpdateUserReq updateUserReq){
        gatewayRequest.setBody(updateUserReq);
        gatewayRequest.setResponseObjectType(PutUpdateUserResp.class);
        return gatewayRequest;
    }


    public GatewayRequest deleteUserReq(DeleteUserReq deleteUserRq){
        gatewayRequest.setBody(deleteUserRq);
        gatewayRequest.setResponseObjectType(DeleteUserResp.class);
        return gatewayRequest;
    }

}
