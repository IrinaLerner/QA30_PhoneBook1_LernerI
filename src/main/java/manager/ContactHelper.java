package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase{
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
       click(By.xpath("//a[.='ADD']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last name']"), contact.getLastname());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());

    }

    public void submitContactForm() {
        click(By.xpath("//button[.='Save']"));
    }

    public boolean isContactCreated(String email) {

        List<WebElement> contactEmails = wd.findElements(By.cssSelector("h3"));
        for(WebElement el: contactEmails){
            if(el.getText().contains(email));
            return true;
        }
         return false;
    }

    public void openListContacts(){
        click(By.xpath("//a[.='CONTACTS']"));
    }
    public int removeOneContact(){
        int countBefore = countOfContacts();
        logger.info("Count of Contacts before" +countBefore);

        if(!isContactListEmpty()){
            String phone = wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3")).getText();
            logger.info("The element that was deleted has phone number -->"+phone);
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
        pause(5000);
    }
        int countAfter =countOfContacts();
        logger.info("Count of Contacts after"+ countAfter);
        return countAfter-countBefore;


}

    public boolean isContactListEmpty() {
        return wd.findElements(By.cssSelector(".contact-item__card2SOIM")).isEmpty();
    }
    public int countOfContacts(){
        return wd.findElements(By.cssSelector(".contact-item__card2SOIM")).size();
    }


    public void removeAllContacts() {
        while (wd.findElements(By.cssSelector(".contact-item__card2SOIM")).size()!=0){
            removeOneContact();

        }


    }

    public boolean isContactNotHere() {
        return shouldHave(By.cssSelector(".contact-page_message__2"));
    }
}
