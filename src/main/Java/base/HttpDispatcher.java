package base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HttpDispatcher {
    private String jsonBody = null;

    public HttpResponse<JsonNode> send(GatewayRequest gatewayRequest){
        HttpRequest request = null;
        HttpResponse response = null;

        final String url = gatewayRequest.getBody().getEndpointUrl();
        final HttpMethod method = gatewayRequest.getBody().getHttpMethod();

        try {
            request = new HttpRequestWithBody(method, url);
            request.headers(gatewayRequest.getHeader().getHeaders());
            request.header("Content-type", "application/json");

            jsonBody = new Gson().toJson(gatewayRequest.getBody());

            try{
                response = ((HttpRequestWithBody) request).body(jsonBody).asJson();
                gatewayRequest.setHttpResponse(response);

            }catch (UnirestException e) {
                response = ((HttpRequestWithBody) request).body(jsonBody).asString();
            }
            try{
                if(gatewayRequest.getResponseObjectType()!=null){
                    gatewayRequest.setSerializationResponse(new Gson().fromJson(response.getBody().toString(), gatewayRequest.getResponseObjectType()));

                }
            }
            catch (Exception e){

            }

        }catch (Exception e){

            try {

                response = ((HttpRequestWithBody) request).body(jsonBody).asString();
            }catch (UnirestException ex){
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        }
//        logToReport(request, response);
        return response;
    }

    private void logToReport(HttpRequest request, HttpResponse response) {
        String reqLog = String.format("\nREQUEST\n---------\nMETHOD: %s\nURL: %s\nHEADERS: %s\n", new Object[]{request.getHttpMethod(), request.getUrl(), request.getHeaders()});

        if(request.getBody() != null){
            ByteArrayOutputStream os = new ByteArrayOutputStream();

            try{

                request.getBody().getEntity().writeTo(os);
                reqLog =reqLog.concat(String.format("BODY: %s\n", os.toString()));
            }
            catch (IOException e){

            }
        }

        String respLog = String.format("\nRESPONSE\n-----------\nSTATUS_CODE: %d\nSTATUS_TEXT: %s\nHEADERS: %s\nBODY: %s\n",
                response.getStatus(), response.getStatusText(), response.getHeaders(), response.getBody());

        ExtentTest reporter = BaseTest.getTestReporter();
        reporter.info(MarkupHelper.createCodeBlock(reqLog));
        reporter.info(MarkupHelper.createCodeBlock(respLog));
    }
}
