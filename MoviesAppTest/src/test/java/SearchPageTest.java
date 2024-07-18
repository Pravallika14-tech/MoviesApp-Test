import Pages.SearchPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;

import java.time.Duration;

public class SearchPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    SearchPage searchPage;

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"rahul", "rahul@2021"}

        };
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");

        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test(priority = 1, dataProvider = "loginData")
    public void testSearch(String username, String password) {
        loginPage.loginToApplication(username, password);


        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "URLs do not match");
    }
    @Test(priority = 2)
    public void testSearchPage() {
        loginPage.loginToApplication("rahul", "rahul@2021");

        // Navigate to search page
        driver.navigate().to("https://qamoviesapp.ccbp.tech/search");

        // Wait for search page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/search"));

        // Verify search bar is displayed
        Assert.assertTrue(searchPage.findSearchBar().isDisplayed(), "Search bar is not displayed");

        // Perform first search for "avatar"
        WebElement searchField = driver.findElement(By.xpath("/html/body/div/div/nav/div[2]/div/input"));
        searchField.sendKeys("avatar");

        WebElement searchButton = driver.findElement(By.xpath("/html/body/div/div/nav/div[2]/div/button"));
        searchButton.click();

        // Perform second search for "No Time to Die"
        WebElement searchField1 = driver.findElement(By.xpath("/html/body/div/div/nav/div[2]/div/input"));
        searchField1.clear();  // Clear the previous input
        searchField1.sendKeys("No Time to Die");

        WebElement searchButton1 = driver.findElement(By.xpath("/html/body/div/div/nav/div[2]/div/button"));
        searchButton1.click();
        // Perform third search for "Clifford"
        WebElement searchField2 = driver.findElement(By.xpath("/html/body/div/div/nav/div[2]/div/input"));
        searchField2.clear();  // Clear the previous input
        searchField2.sendKeys("Clifford");

        WebElement searchButton2 = driver.findElement(By.xpath("/html/body/div/div/nav/div[2]/div/button"));
        searchButton2.click();
        // Perform fourth search for "Shang-Chi and the Legend of the Ten Rings"
        WebElement searchField3 = driver.findElement(By.xpath("/html/body/div/div/nav/div[2]/div/input"));
        searchField3.clear();  // Clear the previous input
        searchField3.sendKeys("Shang-Chi and the Legend of the Ten Rings");

        WebElement searchButton3 = driver.findElement(By.xpath("/html/body/div/div/nav/div[2]/div/button"));
        searchButton3.click();

        // Find all the search results
        List<WebElement> searchResult = driver.findElements(By.xpath("//img"));
        System.out.println("count of movies "+searchResult.size()+" are displayed");
    }
    @Test(priority = 3)
    public void testSearchPageFailureCase() {
        loginPage.loginToApplication("rahul", "rahul@2021");

        // Navigate to search page
        driver.navigate().to("https://qamoviesapp.ccbp.tech/search");

        // Wait for search page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/search"));
        // Perform first search for "avatar"
        WebElement searchField3 = driver.findElement(By.xpath("/html/body/div/div/nav/div[2]/div/input"));
        searchField3.sendKeys("aaaa");
        WebElement searchButton = driver.findElement(By.xpath("/html/body/div/div/nav/div[2]/div/button"));
        searchButton.click();


    }
    }
