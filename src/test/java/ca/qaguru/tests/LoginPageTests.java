package ca.qaguru.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import sun.misc.BASE64Decoder;

public class LoginPageTests {

    WebDriver driver;
    public static final String BASE_URL = "https://opensource-demo.orangehrmlive.com";

   @BeforeSuite
   public void beforeSuite()
   {
       WebDriverManager.chromedriver().setup();
   }

   @BeforeMethod
   public void beforeMethod()
   {
       driver = new ChromeDriver();
       driver.get(BASE_URL);
   }


//   @AfterMethod
//   public void clear()
//   {
//       driver.quit();
//   }
    @Test
   public void validLogin(){

            driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
               driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
        driver.findElement(By.xpath("//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]"));
    }

    @Test
    public void invalidLogin()
    {
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123123");
        driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
           String msg =  driver.findElement(By.xpath("//p[@class=\"oxd-text oxd-text--p oxd-alert-content-text\"]")).getText();
        Assert.assertEquals(msg,"Invalid credentials");

    }
    @Test (enabled = false)
    public  void exceptionHandling()
    {
        try
        {
            float no = 3/0;
            driver.findElement(By.xpath("//input[@name=\"sername\"]"));
        }
        catch(ArithmeticException exception) {
            System.out.println("Arithematic Exception");
            // System.out.println("Exception caught - " + exception.getMessage() );
            //exception.printStackTrace();
        }
        catch(NoSuchElementException exception)
            {
                System.out.println("No such element");
            }
        catch(Exception exception)
        {
            System.out.println("Some exception occured....");
        }
        finally {
            System.out.println("Iam finally block");
        }
        System.out.println("The end of test case");
    }

}
