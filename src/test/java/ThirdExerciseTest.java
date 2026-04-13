import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class ThirdExerciseTest {

    @BeforeGroups("Smoke")
    public void beforeSmoke(){
        System.out.println("testing Smoke group");
    }

    @Test(groups={"Smoke"})
    public void testHomepageLoads() {System.out.println("home page loading");}

    @Test(groups={"Smoke"})
    public void testLoginPageVisible() {System.out.println("login page visible");}

    @Test(groups={"Smoke"})
    public void testFooterLinks() {System.out.println("footer links");}

    @AfterGroups("Smoke")
    public void afterSmoke(){
        System.out.println("Smoke group finished");
    }

    @BeforeGroups("Regression")
    public void beforeRegression(){
        System.out.println("testing Regression group");
    }

    @Test(groups={"Regression"})
    public void testLoginValidCreds() {System.out.println("login valid");}

    @Test(groups={"Regression"})
    public void testLoginInvalidCreds() {System.out.println("login invalid");}

    @Test(groups={"Regression"})
    public void testPasswordReset() {System.out.println("password resetting");}

    @Test(groups={"Regression"})
    public void testAccountBalance() {System.out.println("checking account balance");}

    @AfterGroups("Regression")
    public void afterRegression(){
        System.out.println("Regression group finished");
    }
}
