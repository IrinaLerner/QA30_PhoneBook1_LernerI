import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;


    @BeforeSuite
    public void init(){
        wd=new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @BeforeMethod
    public void preCondition(){
        if(islogged() == true){
            logout();
        }
    }

    private void logout() {
        if(islogged()==true){
            click(By.xpath("//button[text()='Sign Out']"));
        }
    }

    private boolean islogged() {
        wd.findElements(By.xpath("//button[text()='Sign Out']"));
        return true;
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size()>0;
    }

    public void submitRegistration() {
        click(By.xpath("//button[2]"));
    }

    public void fillLoginRegistrationForm(String email, String password) {

        type(By.xpath("//input[1]") ,email);
        type(By.xpath("//input[2]"),password);

    }

    public void type(By locator,String text){

        if(text!=null){
            WebElement element =wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }

    }


    public void openLoginRegistrationForm() {

        click(By.xpath("//a[text()='LOGIN']"));
    }

    public void click(By locator){

        wd.findElement(locator).click();
    }
    public void submitlogin(){
        click(By.xpath("//button[1]"));
    }
    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void tearDown(){
        wd.quit();
    }




}
