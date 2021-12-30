import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;


public class Functional_Unit_Test {
    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        ChromeOptions ops=new ChromeOptions();
        ops.addArguments("--headed");
        driver=new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

}
//--TC_Login_001---//
// Chceked Login Functionality with User's valid Email and valid password //
@Test
public void valid_Email_valid_Password() throws IOException, InterruptedException {


    driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    driver.findElement(By.id("email")).sendKeys("purno.ecomclips@gmail.com");
    driver.findElement(By.id("passwd")).sendKeys("SQAlover2021");
    driver.findElement(By.xpath("//span[contains(.,'Sign in')]")).click();
    sleep(2000);
    String text = driver.findElement(By.xpath("//span[contains(.,'Purno SQA')]")).getText();
    Assert.assertTrue(text.contains("Purno SQA"));

    //---takeScreenShot--//
    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
    String fileWithPath = "./src/test/resources/screenshots/" + time + ".png";
    File DestFile = new File(fileWithPath);
    FileUtils.copyFile(screenshotFile, DestFile);


    System.out.println("Actual Value is :- "+ text);

}

    //--TC_Login_001---//
// Chcek Login Functionality with valid User Email and Invalid password //
    @Test
    public void valid_Email_Invalid_Password() throws IOException, InterruptedException {


        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.id("email")).sendKeys("purno.ecomclips@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("12345678");
        driver.findElement(By.xpath("//span[contains(.,'Sign in')]")).click();
        sleep(2000);
        String text = driver.findElement(By.xpath("//li[contains(.,'Authentication failed.')]")).getText();
        Assert.assertTrue(text.contains("Authentication failed."));

        //---takeScreenShot--//
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWithPath = "./src/test/resources/screenshots/" + time + ".png";
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(screenshotFile, DestFile);


        System.out.println("Actual Value is :- "+ text);

    }

    //--TC_Login_001---//
// Chcek Login Functionality with Invalid User Email and valid password //
    @Test
    public void Invalid_Email_valid_Password() throws IOException, InterruptedException {


        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.id("email")).sendKeys("purno.ecomc.com");
        driver.findElement(By.id("passwd")).sendKeys("SQAlover2021");
        driver.findElement(By.xpath("//span[contains(.,'Sign in')]")).click();
        sleep(2000);
        String text = driver.findElement(By.xpath("//li[contains(.,'Invalid email address.')]")).getText();
        Assert.assertTrue(text.contains("Invalid email address."));

        //---takeScreenShot--//
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWithPath = "./src/test/resources/screenshots/" + time + ".png";
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(screenshotFile, DestFile);


        System.out.println("Actual Value is :- "+ text);

    }

    //--TC_Login_001---//
// Chcek Login Functionality with Invalid User Email and Invalid password //
    @Test
    public void Invalid_Email_Invalid_Password() throws IOException, InterruptedException {


        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.id("email")).sendKeys("purno.ecomc.com");
        driver.findElement(By.id("passwd")).sendKeys("SQA");
        driver.findElement(By.xpath("//span[contains(.,'Sign in')]")).click();
        sleep(2000);
        String text = driver.findElement(By.xpath("//li[contains(.,'Invalid email address.')]")).getText();
        Assert.assertTrue(text.contains("Invalid email address."));

        //---takeScreenShot--//
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWithPath = "./src/test/resources/screenshots/" + time + ".png";
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(screenshotFile, DestFile);


        System.out.println("Actual Value is :- "+ text);

    }
    //--TC_Login_001---//
// Chcek Login Functionality with valid User Email and Null password //
    @Test
    public void valid_Email_Blank_Password() throws IOException, InterruptedException {


        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.id("email")).sendKeys("purno.ecomclips@gmail.com");

        driver.findElement(By.xpath("//span[contains(.,'Sign in')]")).click();
        sleep(2000);
        String text = driver.findElement(By.xpath("//li[contains(.,'Password is required.')]")).getText();
        Assert.assertTrue(text.contains("Password is required."));

        //---takeScreenShot--//
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWithPath = "./src/test/resources/screenshots/" + time + ".png";
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(screenshotFile, DestFile);


        System.out.println("Actual Value is :- "+ text);

    }

    //--TC_Login_001---//
// Chcek Login Functionality with valid User Email and Null password //
    @Test
    public void Blank_Email_Password() throws IOException, InterruptedException {


        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

        driver.findElement(By.id("passwd")).sendKeys("SQAlover2021");
        driver.findElement(By.xpath("//span[contains(.,'Sign in')]")).click();
        sleep(2000);
        String text = driver.findElement(By.xpath("//li[contains(.,'An email address required.')]")).getText();
        Assert.assertTrue(text.contains("An email address required."));

        //---takeScreenShot--//
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWithPath = "./src/test/resources/screenshots/" + time + ".png";
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(screenshotFile, DestFile);


        System.out.println("Actual Value is :- "+ text);

    }


}
