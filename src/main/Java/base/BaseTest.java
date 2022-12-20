package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {

    @Getter
    private static Gson gson =new Gson();

    @Getter
    private static ExtentReports extentReports;

    @Getter
    @Setter
    private static ExtentTest testReporter;

    private static ExtentTest testClassReporter;


    @BeforeSuite
    public void beforeTestSuiteSetup(){
        String reportName = String.format("test-report", getDateTime());
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(Properties.REPORT_LOCATION+ reportName);
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);

    }

    @BeforeClass(alwaysRun = true)
    public void beforeClassSetup(ITestContext context){
        testClassReporter = null;
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeTestSetup(Method method){
        if(testClassReporter==null){
            String[] tmp = method.getDeclaringClass().getPackageName().split("[.]");
            String name = tmp[tmp.length-1] + "." + method.getDeclaringClass().getSimpleName();
            testClassReporter =extentReports.createTest(name);
        }
        testClassReporter = testClassReporter.createNode(method.getName());
        Test t = method.getAnnotation(Test.class);
        testClassReporter.assignCategory(t.groups());
    }

    @AfterMethod
    public void afterTestTearDown(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE)
            testClassReporter.fail(result.getThrowable());
        else if(result.getStatus()==ITestResult.SKIP)
            testClassReporter.skip(result.getThrowable());
        else
            testClassReporter.pass("Test passed");

        extentReports.flush();
    }

    private String getDateTime(){
        String timeColonPattern = "d-MM-yyyy--HH-mm-ss";
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(timeColonPattern);
        LocalDateTime rightNow = LocalDateTime.now();
        return timeFormatter.format(rightNow);
    }

}
