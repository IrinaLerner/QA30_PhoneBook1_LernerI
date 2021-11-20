package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase{
    @BeforeMethod
    public void precondition(){
        if(!app.getUser().islogged()){
            app.getUser().login(new User()
                    .withEmail("noa@gmail.com")
                    .withPassword("Nnoa12345$"));
        }
    }
    @Test
    public void removeOneContact(){

        int result = app.contact().removeOneContact();
        Assert.assertEquals(result,-1);

    }
    public void removeAllContact(){
        app.contact().removeAllContacts();
        Assert.assertTrue(app.contact().isContactNotHere());
    }



}
