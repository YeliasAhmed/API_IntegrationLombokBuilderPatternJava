package users;

import base.BaseTest;
import base.GatewayRequest;
import base.Serializer;
import helpers.AssertHelper;
import helpers.MandatoryHeaders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.users.CreateUserReq;
import services.users.PutUpdateUserReq;
import services.users.PutUpdateUserResp;

public class PutUpdateUser extends BaseTest {

    private PutUpdateUserReq putUpdateUserReq;

    @Test
    public void test_put_update_user(){
        putUpdateUserReq.firstName="QualityUp";
        putUpdateUserReq.lastName="service";
        GatewayRequest gatewayRequest = new GatewayRequest()
                .usingHeaders(MandatoryHeaders.getHeaders())
                .forService()
                .userService()
                .putUpdateUserReq(putUpdateUserReq)
                .send();

        AssertHelper.assertResponseCode(gatewayRequest, 200);
        PutUpdateUserResp resp = (PutUpdateUserResp) gatewayRequest.getSerializationResponse();
        AssertHelper.assertResponseBodyContains("code", resp.getCode(), 200);
        AssertHelper.assertResponseBodyContains("type", resp.getType(), "unknown");
        AssertHelper.assertResponseBodyContains("message", resp.getMessage(), "101");




    }

    @BeforeClass
    public void setupRequest(){
        putUpdateUserReq = (PutUpdateUserReq) Serializer.convertJsonStringToObject("CreateUser.json", PutUpdateUserReq.class);
    }


}
