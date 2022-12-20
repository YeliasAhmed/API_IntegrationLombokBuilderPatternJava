package users;

import base.BaseTest;
import base.GatewayRequest;
import base.Serializer;
import helpers.AssertHelper;
import helpers.MandatoryHeaders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.users.GetLoginReq;
import services.users.GetLoginResp;

public class GetLogin extends BaseTest {

    private GetLoginReq getLoginReq;

    @Test
    public void test_get_login_user(){
        GatewayRequest gatewayRequest = new GatewayRequest()
                .usingHeaders(MandatoryHeaders.getHeaders())
                .forService()
                .userService()
                .getLoginReq(GetLoginReq.builder()
                        .username("qups1")
                        .password("1238")
                        .build())
                .send();

        AssertHelper.assertResponseCode(gatewayRequest, 200);
        GetLoginResp resp = (GetLoginResp) gatewayRequest.getSerializationResponse();
        AssertHelper.assertResponseBodyContains("code", resp.getCode(), 200);
        AssertHelper.assertResponseBodyContains("type", resp.getType(), "unknown");
//        AssertHelper.assertResponseBodyContains("message", resp.getMessage(), "101");

    }

    @BeforeClass
    public void setGetLoginReq(){
        getLoginReq =(GetLoginReq) Serializer.convertJsonStringToObject("CreateUser.json", GetLoginReq.class);
    }

}
