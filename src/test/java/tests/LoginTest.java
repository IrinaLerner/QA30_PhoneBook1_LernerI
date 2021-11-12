package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getUser().islogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void loginPositiveTest(){
        /*
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

         */
    }
        @Test
    public void loginTest(){
        //String email = "Irina@gmail.com";
            String email = "noa@gmail.com";
        //String password ="Irina14$";
            String password ="Nnoa12345$";
            System.out.println(email+ "   "+password);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().submitlogin();
        app.getUser().pause(1000);
        //Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
            Assert.assertTrue(app.getUser().islogged());
        }

    @Test
    public void loginTestModel(){
        String email = "noa@gmail.com";
        String password ="Nnoa12345$";
        User user = new User().withEmail(email).withPassword(password);

        app.getUser().openLoginRegistrationForm();

        app.getUser().fillLoginRegistrationForm(user);

        app.getUser().submitlogin();
        app.getUser().pause(2500);
        //Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
        Assert.assertTrue(app.getUser().islogged());
    }




}
