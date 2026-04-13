import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class SecondExerciseTest {
    WebDriver driver;
    Login loginPage;

    @Parameters("browser") @BeforeClass
    public void beforeTest(String browser) {

        if(browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions fireFoxOptions = new FirefoxOptions();
            fireFoxOptions.addArguments("-headless");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(fireFoxOptions);
        }else if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("--headless=new");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1920,1080");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        }


        loginPage = new Login(driver);
    }


    @DataProvider(name = "data")
    public Object[][] getData() {
        return new Object[][]{
                {"test@mail.com", "123", "Invalid email or password.", "invalid"},
                {"test@mail.com", "152", "https://demo.guru99.com/test/success.html", "valid"}
        };
    }

    @Test(dataProvider = "data")
    public void login_test(String username, String password, String expectedURL, String caseType) throws InterruptedException {
        driver.get(" https://demo.guru99.com/test/login.html");
        loginPage.setEmail(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();

        Thread.sleep(3000);
        if(caseType.equalsIgnoreCase("valid")) {
            String actualURL = driver.getCurrentUrl();
            Assert.assertEquals(actualURL, expectedURL, "Valid URL navigation");
        }else{
            System.out.println("this is an invalid case");
        }

    }

    @AfterTest
    public void end(){
        driver.quit();
    }

}
