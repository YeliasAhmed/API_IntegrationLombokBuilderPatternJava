package users;

import base.BaseTest;
import base.GatewayRequest;
import base.Serializer;
import helpers.AssertHelper;
import helpers.MandatoryHeaders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.users.DeleteUserReq;
import services.users.DeleteUserResp;
import services.users.PutUpdateUserReq;
import services.users.PutUpdateUserResp;

public class DeleteUser extends BaseTest {

    DeleteUserReq deleteUserReq;

    @Test
    public void test_delete_user(){
        deleteUserReq.setUsername("qups");
        GatewayRequest gatewayRequest = new GatewayRequest()
                .usingHeaders(MandatoryHeaders.getHeaders())
                .forService()
                .userService()
                .deleteUserReq(deleteUserReq)
                .send();

        AssertHelper.assertResponseCode(gatewayRequest, 200);
        DeleteUserResp resp = (DeleteUserResp) gatewayRequest.getSerializationResponse();
        AssertHelper.assertResponseBodyContains("code", resp.getCode(), 200);
        AssertHelper.assertResponseBodyContains("type", resp.getType(), "unknown");
        AssertHelper.assertResponseBodyContains("message", resp.getMessage(), "qups");

    }

    @BeforeClass
    public void setupRequest(){
        deleteUserReq = (DeleteUserReq) Serializer.convertJsonStringToObject("CreateUser.json", DeleteUserReq.class);
    }
}
