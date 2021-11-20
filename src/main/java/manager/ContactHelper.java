package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        should(By.xpath("//a[@href='/add']"), 15);
        click(By.xpath("//a[@href='/add']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastname());
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
        for (WebElement el : contactEmails) {
            if (el.getText().contains(email)) ;
            return true;
        }
        return false;
    }

    public void openListContacts() {
        click(By.xpath("//a[.='CONTACTS']"));
    }

    public int removeOneContact() {
        int countBefore = countOfContacts();
        logger.info("Count of Contacts before" + countBefore);

        if (!isContactListEmpty()) {
            String phone = wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3")).getText();
            logger.info("The element that was deleted has phone number -->" + phone);
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[.='Remove']"));
            pause(500);
        }
        int countAfter = countOfContacts();
        logger.info("Count of Contacts after" + countAfter);
        return countAfter - countBefore;


    }

    public boolean isContactListEmpty() {
        return wd.findElements(By.cssSelector(".contact-item__card2SOIM")).isEmpty();
    }

    public int countOfContacts() {

        return wd.findElements(By.cssSelector(".contact-item__card2SOIM")).size();
    }


    public void removeAllContacts() {
        while (wd.findElements(By.cssSelector(".contact-item__card2SOIM")).size() != 0) {
            removeOneContact();

        }

    }

    public boolean isContactNotHere() {

        return shouldHave(By.cssSelector(".contact-page_message__2qafk h1"), "No Contacts here!", 10);
    }

    public void providerOfContacts() {
        int index = (int) (System.currentTimeMillis());
        for (int i = 0; i < 3; i++) {
            Contact contact = Contact.builder()
                    .name("Lis")
                    .lastname("Snow")
                    .phone("1" + i + index)
                    .email(i + "l" + index + "@gmail.com")
                    .address("Haifa")
                    .description("friend").build();

            openContactForm();
            fillContactForm(contact);
            submitContactForm();
            pause(1000);
        }
    }
}