import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class FirstExerciseTest {
    WebDriver driver;

    @BeforeTest
    public void openWebSite(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        System.out.println("opening site");
        driver.navigate().to("https://www.google.com");
    }


    @Test(priority = 1)
    public void signUp() {
        System.out.println("Sign Up");
    }

    @Test(priority = 2)
    public void logIn() {
        System.out.println("Login");
    }

    @Test(priority = 3)
    public void addToCart() {
        System.out.println("Added product");
    }

    @AfterTest
    public void logOut() {
        System.out.println("Logging out and closing browser.");
        driver.quit();
    }


}
