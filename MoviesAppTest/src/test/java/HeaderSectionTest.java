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
import org.testng.annotations.Test;

import java.time.Duration;
public class HeaderSectionTest {

    public WebDriver driver;
    LoginPage loginPage;
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage = new LoginPage(driver);
        loginPage.loginToApplication("rahul", "rahul@2021");
        WebElement loginButtonEl = driver.findElement(By.className("login-button"));
        loginButtonEl.submit();


    }

    @Test
    public void imageElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        Assert.assertTrue(element.isDisplayed(), "image Didn't macth");
    }

    @Test
    public void navBarElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='list-item']")));
        Assert.assertTrue(element.isDisplayed(), "navbar elements Didn't macth");
    }
    @Test
    public void testHomePage() {


        String expectedUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualUrl =driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URLs do not match");
    }
    @Test
    public void testPopularPage() {
        driver.navigate().to("https://qamoviesapp.ccbp.tech/popular");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/popular";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl =driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URLs do not match");
    }
    @Test
    public void testAccountsPage() {
        driver.navigate().to("https://qamoviesapp.ccbp.tech/account");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/account";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URLs do not match");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
