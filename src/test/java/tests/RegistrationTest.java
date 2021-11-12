package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {


    @BeforeMethod
    public void preCondition() {
        if (app.getUser().islogged()) {
            app.getUser().logout();
        }
    }

    @Test
    public void registrationTestPositive() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "niko" + i + "@gmail.com";
        String password = "Nniko12345$";
        System.out.println("Email: " + email);
        logger.info("Test Registration Positive starts with >>> "+ email+ " &&& "+password);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
        Assert.assertTrue(app.getUser().islogged());
        //Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
    }


    @Test
    public void registrationTestWrongEmail() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "niko" + i + "gmail.com";
        String password = "Niko12345$";
        System.out.println("Email: " + email);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
        app.getUser().pause(2500);
       // Assert.assertFalse(app.getUser().islogged());
        // Assert.assertFalse(isElementPresent(By.xpath("//button[text()='Sign Out']")));
        Assert.assertTrue(app.getUser().isErrorMessageWrongFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
