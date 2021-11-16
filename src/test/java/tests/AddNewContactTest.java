package tests;

import models.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase{

@BeforeMethod
    public void precondition(){
    if(app.getUser().islogged()){
       // app.getUser().
    }

}
@Test (invocationCount = 4)
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
}
}
