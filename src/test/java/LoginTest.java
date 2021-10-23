import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd=new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");


    }
    @Test
    public void loginPositiveTest(){
        WebElement loginBtn = wd.findElement(By.xpath("//*[text()='LOGIN']"));
        loginBtn.click();

        WebElement emailInput=wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("Irina@gmail.com");
        WebElement passwordInput=wd.findElement(By.xpath("//input[2]"));
        passwordInput.click();
        passwordInput.clear();
        emailInput.sendKeys("Irina14$");

        wd.findElement(By.xpath("//button[1]")).click();

        //Assert.assertTrue(wd.findElements(By.xpath("//button[text()='SingOut']")).size()>0);


    }
    @AfterMethod
    public void tearDown(){
        wd.quit();
    }







}
