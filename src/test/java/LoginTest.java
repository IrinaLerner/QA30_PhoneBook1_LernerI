import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{


    @Test
    public void loginPositiveTest(){
        //open login/Reg form
        WebElement loginBtn = wd.findElement(By.xpath("//*[text()='LOGIN']"));
        loginBtn.click();
        //fill login/Reg form
        WebElement emailInput=wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("Irina@gmail.com");
        WebElement passwordInput=wd.findElement(By.xpath("//input[2]"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Irina14$");
        //click  Login button
        wd.findElement(By.xpath("//button[1]")).click();
        //Assert if button Logout is
        Assert.assertTrue(wd.findElements(By.xpath("//button[text()='Sign Out']")).size()>0);
        //Assert.assertTrue(wd.findElements(By.xpath("//button[.='Sign Out']")).size()>0);
    }
        @Test
    public void loginTest2(){
        String email = "Irina@gmail.com";
        String password ="Irina14$";

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email,password);
        submitlogin();
        pause(5000);
        Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
        }




}
