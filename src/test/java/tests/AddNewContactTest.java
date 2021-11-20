package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase{

@BeforeMethod(alwaysRun = true)
    public void precondition(){
    if(!app.getUser().islogged()){
        app.getUser().login(new User()
                .withEmail("noa@gmail.com")
                .withPassword("Nnoa12345$"));
    }

}
@Test (invocationCount = 3,groups = {"web","smoke"})
    public void addNewContactTest(){
    int index = (int)(System.currentTimeMillis()/1000)%3600;
    Contact contact = Contact.builder()
            .name("Lis")
            .lastname("Snow")
            .phone("1234560"+index)
            .email("lia"+index+"@gmail.com")
            .address("Haifa")
            .description("friend")
            .build();
    app.contact().openContactForm();
    app.contact().fillContactForm(contact);
    app.contact().submitContactForm();
    Assert.assertTrue(app.contact().isContactCreated(contact.getPhone()));
}
}
