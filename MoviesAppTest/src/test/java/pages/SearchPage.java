package Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
     WebDriver driver;
     WebDriverWait wait;
    By searchBarLocactor = By.xpath("/html/body/div/div/nav/div[2]");
    //By searchMoviesContainerLocator = By.xpath("/html/body/div/div/ul/li[1]");
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public WebElement findSearchBar(){

        return driver.findElement(searchBarLocactor);
    }
   public WebElement findSearchMoviesContainer() {
        return driver.findElement(searchMoviesContainerLocator);

    }
}
