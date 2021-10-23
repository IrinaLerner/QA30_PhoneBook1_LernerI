import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
        //if(isLogger()){
          //  logout();
       // }
    }



    @Test
    public void registrationTestPositive() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "niko"+i+"@gmail.com";
        String password = "Nniko12345$";
        System.out.println("Email: " + email);

    openLoginRegistrationForm();
    fillLoginRegistrationForm(email,password);
    submitRegistration();

        Assert.assertTrue(isElementPresent(By.xpath("//button[text()='SingOut']")));
    }


    @Test
        public void registrationTestWrongEmail() {

            int i = (int) (System.currentTimeMillis() / 1000) % 3600;
            String email = "niko" + i + "gmail.com";
            String password = "Nniko12345$";
            System.out.println("Email: " + email);

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email,password);
        submitRegistration();
        Assert.assertTrue(isElementPresent(By.xpath("//button[text()='SingOut']")));
        }

}
