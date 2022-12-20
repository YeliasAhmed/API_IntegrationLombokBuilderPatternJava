package controllers;

import base.GatewayRequest;

public class StoreService {

    private GatewayRequest gatewayRequest;

    public StoreService(GatewayRequest gatewayRequest){
        this.gatewayRequest = gatewayRequest;
    }



//    public GatewayRequest createPost(CreatePostReq createPostReq){
//        gatewayRequest.setBody(createPostReq);
//        gatewayRequest.setResponseObjectType(CreatePostResp.class);
//        return gatewayRequest;
//    }
//
//    public GatewayRequest updatePost(UpdatePostReq updatePostReq){
//        gatewayRequest.setBody(updatePostReq);
//        gatewayRequest.setResponseObjectType(UpdatePostResp.class);
//        return gatewayRequest;
//    }


}
