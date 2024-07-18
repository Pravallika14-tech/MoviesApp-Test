package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
public class PopularPage {
    WebDriver driver;
    WebDriverWait wait;
    By movieList = By.xpath("//li[@class='movie-icon-item']");
    public PopularPage(WebDriver driver) {

        this.driver = driver;
    }
    public WebElement findMovieList() {
        return driver.findElement(movieList);

    }

}
