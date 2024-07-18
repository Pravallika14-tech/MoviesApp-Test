import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.annotations.*;
import org.testng.Assert;
import Pages.LoginPage;
import Pages.HomePage;

public class HomePageTest {

    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.loginToApplication("rahul", "rahul@2021");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "URLs do not match");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void testHomePage() {
        //Assert.assertTrue(homePage.findAppImage().isDisplayed(), "App image is not displayed");
        Assert.assertEquals(homePage.getHeadingText1(),"Trending Now","heading text didn't match");
        Assert.assertEquals(homePage.getHeadingText2(),"Originals","heading text didn't match");
        Assert.assertTrue(homePage.findPlayButton().isDisplayed(), "play button didn't displayed");
        Assert.assertTrue(homePage.findMoviesDisplay().isDisplayed(), "movies is not displayed");
        Assert.assertTrue(homePage.findContactUsSection().isDisplayed(),"contact us section is not display");
    }

}