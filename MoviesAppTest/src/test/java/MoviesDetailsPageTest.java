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

public class MovieDetailsPageTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://qamoviesapp.ccbp.tech/login");

        // Login process
        WebElement usernameEl = driver.findElement(By.id("usernameInput"));
        usernameEl.sendKeys("rahul");
        WebElement passwordEl = driver.findElement(By.id("passwordInput"));
        passwordEl.sendKeys("rahul@2021");
        WebElement loginButtonEl = driver.findElement(By.className("login-button"));
        loginButtonEl.click();
    }
    @Test
    public void testMovieDetailsFromHomePage() {
        driver.get("https://qamoviesapp.ccbp.tech/");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/movies/92c2cde7-d740-443d-8929-010b46cb0305";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "URLs do not match");
    }
    @Test
    public void checkingHeadingElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movies-list-heading")));
        Assert.assertTrue(element.isDisplayed(),"heading Didn't macth");
    }
    @Test
    public void checkingDiscription() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-overview")));
        Assert.assertTrue(element.isDisplayed(),"content Didn't macth");
    }
    @Test
    public void checkingMovieReviewContainer() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-review-container")));
        Assert.assertTrue(element.isDisplayed(),"movie review container Didn't macth");
    }
    @Test
    public void checkingPopularPagePlayButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("play-button")));
        Assert.assertTrue(element.isDisplayed(),"play button Didn't macth");
    }
    @Test
    public void checkingCategoriesSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("detailed-movie-categories-container")));
        Assert.assertTrue(element.isDisplayed(),"Categories Section doesn't macth");
    }
    @Test
    public void checkingMoviesSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("similar-movies-container")));
        Assert.assertTrue(element.isDisplayed(),"Categories Section doesn't macth");
    }
    @Test
    public void checkingContactUsSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("footer-container")));
        Assert.assertTrue(element.isDisplayed(),"Categories Section doesn't macth");
    }
    @Test
    public void testMovieDetailsFromPopularPage() {
        driver.get("https://qamoviesapp.ccbp.tech/popular");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/movies/320dee56-fdb2-40cf-8df8-92b251bd781f";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "URLs do not match");
    }
    @Test
    public void checkingPopularPageHeadingElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movies-list-heading")));
        Assert.assertTrue(element.isDisplayed(),"heading Didn't macth");
    }
    @Test
    public void checkingPopularPageDiscription() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-overview")));
        Assert.assertTrue(element.isDisplayed(),"content Didn't macth");
    }
    @Test
    public void checkingPopularPageMovieReviewContainer() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-review-container")));
        Assert.assertTrue(element.isDisplayed(),"movie review container Didn't macth");
    }
    @Test
    public void checkingPlayButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("play-button")));
        Assert.assertTrue(element.isDisplayed(),"play button Didn't macth");
    }
    @Test
    public void checkingPopularPageCategoriesSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("detailed-movie-categories-container")));
        Assert.assertTrue(element.isDisplayed(),"Categories Section doesn't macth");
    }
    @Test
    public void checkingPopularPageMoviesSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("similar-movies-container")));
        Assert.assertTrue(element.isDisplayed(),"Categories Section doesn't macth");
    }
    @Test
    public void checkingPopularPageContactUsSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("footer-container")));
        Assert.assertTrue(element.isDisplayed(),"Categories Section doesn't macth");
    }
    @AfterMethod
    public void tearDown() {

            driver.quit();

    }
}

