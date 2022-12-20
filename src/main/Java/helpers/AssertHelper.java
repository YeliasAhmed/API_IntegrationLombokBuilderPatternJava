package helpers;

import base.BaseTest;
import base.GatewayRequest;
import base.Serializer;
import com.aventstack.extentreports.Status;
import com.mashape.unirest.http.HttpResponse;
import services.ErrorMessage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AssertHelper {
    public static void assertResponseCode(GatewayRequest gateway, int actual){
        assertThat("Unexpected HTTP Response Status Code", gateway.getHttpResponse().getStatus(), is(actual));
//        BaseTest.getTestReporter().log(Status.PASS, "Valid HTTP Response Status Code is " +actual);

    }
    public static void assertResponseBodyContains(String fieldName, String actualValue, String expectedValue){
        assertThat("Unexpected Value field " + fieldName, actualValue, is(expectedValue));
//        BaseTest.getTestReporter().log(Status.PASS, String.format("Validated field [%s]", fieldName, expectedValue));
    }

    public static void assertResponseBodyContains(String fieldName, int actualValue, int expectedValue){
        assertThat("Unexpected Value field " + fieldName, actualValue, is(expectedValue));
//        BaseTest.getTestReporter().log(Status.PASS, String.format("Validated field [%d]", fieldName, expectedValue));
    }

    public static void assertResponseBodyContains(String fieldName, boolean actualValue, boolean expectedValue){
        assertThat("Unexpected Value field " + fieldName, actualValue, is(expectedValue));
//        BaseTest.getTestReporter().log(Status.PASS, String.format("Validated field [%s] is [%b]", fieldName, expectedValue));
    }

    public static void assertResponseBodyValueIsNotNull(String fieldName, int value){
        assertThat("Unexpected Value field " + fieldName, value, is(notNullValue()));
//        BaseTest.getTestReporter().log(Status.PASS, String.format("Validated field [%s] is not null", fieldName));
    }
    public static void assertResponseBodyValueIsNotEmptyString(String fieldName, String value){
        assertThat("Unexpected Value field " + fieldName, value, not(emptyOrNullString()));
//        BaseTest.getTestReporter().log(Status.PASS, String.format("Validated field [%s] is not empty or null", fieldName));
    }
    public static  void assertMissingMandatoryHeadersErrorMessage(HttpResponse response){
        ErrorMessage errorMessage = (ErrorMessage) Serializer.serialize(response, ErrorMessage.class);

        assertResponseBodyContains("Code", errorMessage.getCode(), 400);
        assertResponseBodyContains("Message", errorMessage.getMessage(), "Required headers are missing, please verify and try again");
        assertResponseBodyContains("Status", errorMessage.getStatus(), 400);
    }
    public static void assertListContains(String fieldName, List<Integer>list, int value){
        assertThat(fieldName + " does not contain value", list, hasItem(value));
//        BaseTest.getTestReporter().log(Status.PASS, String.format("Validated field [%d]", fieldName, value));
    }

}
