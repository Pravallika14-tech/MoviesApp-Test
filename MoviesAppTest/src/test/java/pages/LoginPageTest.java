import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginPageTest {

    WebDriver driver;
    LoginPage loginPage;

    @DataProvider
    public Object[][] loginData() {
        return new Object[][] {
                {" "," "},
                { "rahul","rahul@2021"}

        };
    }

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
    }


    @Test(priority = 1, dataProvider = "loginData")
    public void loginWithValidCredentials(String username, String password) {

        loginPage.loginToApplication(username, password);

        String expectedUrl = "https://qamoviesapp.ccbp.tech/login";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "URLs do not match");
    }

    @Test(priority = 2)
    public void loginWithInvalidCredentials() {

        loginPage.loginToApplication("rahul", "rashul@2021");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        WebElement errorMessageEl = driver.findElement(By.className("error-message"));
        String errorMessage = errorMessageEl.getText();
        Assert.assertEquals(errorMessage,"*username and password didn't match");

    }

    @Test(priority = 3)
    public void testMoviesAppUI() {
        Assert.assertTrue(loginPage.findAppImage().isDisplayed(), "App image is not displayed");
        Assert.assertEquals(loginPage.getHeadingText(), "Login", "Heading text does not match");
        Assert.assertTrue(loginPage.findUserName().isDisplayed(), "username is not displayed");
        Assert.assertTrue(loginPage.findPassword().isDisplayed(), "password is not displayed");
        Assert.assertTrue(loginPage.findLoginButton().isDisplayed(), "Login Button is not displayed");

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}