import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import Pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.AccountPage;
import java.time.Duration;

public class AccountPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    AccountPage accountPage;
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
        accountPage = new AccountPage(driver);
    }
    @Test(priority = 1, dataProvider = "loginData")
    public void testAccount(String username, String password){
        loginPage.loginToApplication(username, password);


        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "URLs do not match");
    }
    @Test(priority = 2)
    public void testAccountPage(){
        loginPage.loginToApplication("rahul", "rahul@2021");
        driver.navigate().to("https://qamoviesapp.ccbp.tech/account");

        String expectedUrl = "https://qamoviesapp.ccbp.tech/account";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "URLs do not match");
        Assert.assertEquals(accountPage.getAccountHeading(), "Account", "heading text didn't match");
        Assert.assertEquals(accountPage.getMembershipHeading(), "Member ship", "Membership text didn't match");
        Assert.assertEquals(accountPage.getMembershipUsername(), "User name : rahul", "User name text didn't match");
        Assert.assertEquals(accountPage.getMembershipPassword(), "Password : **********", "Password text didn't match");
        Assert.assertEquals(accountPage.getPlanDetails(), "Plan details", "Plan details didn't match");
        Assert.assertEquals(accountPage.getPlanDetails1(), "Premium", "premium didn't match");
        Assert.assertEquals(accountPage.getPlanDetails2(), "Ultra HD", "plan details didn't match");

        // Find the Logout button element
        WebElement logoutButtonEl = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[3]/button"));

        // Click the logout button
        logoutButtonEl.click();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    }
