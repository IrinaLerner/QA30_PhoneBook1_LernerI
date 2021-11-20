package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getUser().islogged()){
            app.getUser().logout();
        }
    }

        @Test(groups = {"web"})
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
