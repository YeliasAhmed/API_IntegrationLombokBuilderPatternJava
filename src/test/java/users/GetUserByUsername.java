package users;

import base.BaseTest;
import base.GatewayRequest;
import base.Serializer;
import helpers.AssertHelper;
import helpers.MandatoryHeaders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.users.GetLoginReq;
import services.users.GetUserByUsernameNotFoundResp;
import services.users.GetUserByUsernameReq;
import services.users.GetUserByUsernameResp;

public class GetUserByUsername extends BaseTest {

    private GetUserByUsernameReq getUserByUsernameReq;


    @Test
    public void test_get_user_by_username(){
        GatewayRequest gatewayRequest = new GatewayRequest()
                .usingHeaders(MandatoryHeaders.getHeaders())
                .forService()
                .userService()
                .getUserByUsernameReq(GetUserByUsernameReq.builder()
                        .username("unirest123")
                        .build())
                .send();

        AssertHelper.assertResponseCode(gatewayRequest, 200);
        GetUserByUsernameResp resp = (GetUserByUsernameResp) gatewayRequest.getSerializationResponse();
        AssertHelper.assertResponseBodyContains("id",resp.getId(), 101);
        AssertHelper.assertResponseBodyContains("username", resp.getUsername(), "unirest123");
        AssertHelper.assertResponseBodyContains("firstName", resp.getFirstName(), "Uni");
        AssertHelper.assertResponseBodyContains("lastName", resp.getLastName(), "Rest");
        AssertHelper.assertResponseBodyContains("email", resp.getEmail(), "unirest@gmail.com");
        AssertHelper.assertResponseBodyContains("password", resp.getPassword(), "12345");
        AssertHelper.assertResponseBodyContains("phone", resp.getPhone(), "98596252");
        AssertHelper.assertResponseBodyContains("userStatus",resp.getUserStatus(), 0);

    }

    @Test
    public void test_get_user_by_username_user_not_found(){
        GatewayRequest gatewayRequest = new GatewayRequest()
                .usingHeaders(MandatoryHeaders.getHeaders())
                .forService()
                .userService()
                .getUserByUsernameReq(GetUserByUsernameReq.builder()
                        .username("tryu")
                        .build())
                .send();

        AssertHelper.assertResponseCode(gatewayRequest, 404);
        GetUserByUsernameNotFoundResp resp = (GetUserByUsernameNotFoundResp) Serializer.serialize(gatewayRequest.getHttpResponse(), GetUserByUsernameNotFoundResp.class);
        AssertHelper.assertResponseBodyContains("code", resp.getCode(), 1);
        AssertHelper.assertResponseBodyContains("type", resp.getType(), "error");
        AssertHelper.assertResponseBodyContains("message", resp.getMessage(), "User not found");
    }



//    @BeforeClass
//    public void setupRequest(){
//        getUserByUsernameReq =(GetUserByUsernameReq) Serializer.convertJsonStringToObject("CreateUser.json", GetUserByUsernameReq.class);
//    }
}
