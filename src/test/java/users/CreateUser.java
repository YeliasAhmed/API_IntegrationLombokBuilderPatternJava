package users;

import base.BaseTest;
import base.GatewayRequest;
import base.Serializer;
import helpers.AssertHelper;
import helpers.MandatoryHeaders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.users.CreateUserReq;
import services.users.CreateUserResp;

public class CreateUser extends BaseTest {
    private CreateUserReq createUserReq;

    @Test
    public void test_create_user(){
        GatewayRequest gatewayRequest = new GatewayRequest()
                .usingHeaders(MandatoryHeaders.getHeaders())
                .forService()
                .userService()
                .createUserRq(createUserReq)
                .send();

        AssertHelper.assertResponseCode(gatewayRequest, 200);
        CreateUserResp resp = (CreateUserResp) gatewayRequest.getSerializationResponse();
        AssertHelper.assertResponseBodyContains("code", resp.getCode(), 200);
        AssertHelper.assertResponseBodyContains("type", resp.getType(), "unknown");
        AssertHelper.assertResponseBodyContains("message", resp.getMessage(), "101");

    }
    @Test
    public void test_create_invalid_user(){}

    @BeforeClass
    public void setupRequest(){
        createUserReq = (CreateUserReq) Serializer.convertJsonStringToObject("CreateUser.json", CreateUserReq.class);
    }
}
