public class CreateUser extends BaseTest {
    private CreateUser;

    @Test
    public void test_create_user(){
        GatewayRequest gatewayRequest = new GatewayRequest()
                .usingHeader(MandatoryHeaders.getHeaders())
                .forService()
                .userService()
                .createUser(CreateUser)
                .send();

        AssertHelper.asserResponseCode(gatewayRequest, 200);
        CreateUser response = (CreateUser) gatewayRequest.getSerialization

                .
    }
}