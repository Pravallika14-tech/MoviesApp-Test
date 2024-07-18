import Pages.LoginPage;
import Pages.PopularPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class PopularPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    PopularPage popularPage;

    @DataProvider
    public Object[][] loginData() {
        return new Object[][] {
                { "rahul","rahul@2021"}

        };
    }
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");

        loginPage = new LoginPage(driver);
        popularPage = new PopularPage(driver);
    }
    @Test(priority = 1, dataProvider = "loginData")
    public void testPopular(String username, String password){
        loginPage.loginToApplication(username, password);


        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "URLs do not match");
    }
    @Test(priority = 2)
    public void testPopularPage(){
        loginPage.loginToApplication("rahul", "rahul@2021");
        driver.navigate().to("https://qamoviesapp.ccbp.tech/popular");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/popular";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl =driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URLs do not match");
        //Assert.assertTrue(popularPage.findMovieList().isDisplayed(), "movie is not displayed");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
