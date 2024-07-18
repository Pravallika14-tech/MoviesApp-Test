package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountPage {
    WebDriver driver;
    WebDriverWait wait;
    By accountHeadingLocactor = By.className("account-heading");
    By membershipHeadingLocator = By.className("membership-heading");
    By membershipUsernameLocator = By.className("membership-username");
    By membershipPasswordLocartor = By.className("membership-password");
    By planDetailsLocator = By.xpath("/html/body/div/div/div[1]/div[2]/p");
    By planDetails1Locator =  By.xpath("/html/body/div/div/div[1]/div[2]/div/p[1]");
    By planDetails2Locator = By.xpath("/html/body/div/div/div[1]/div[2]/div/p[2]");
    By logoutButtonLocator = By.className("logout-button");
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public String getAccountHeading(){

        return driver.findElement(accountHeadingLocactor).getText();
    }
   public String getMembershipHeading() {

       return driver.findElement(membershipHeadingLocator).getText();
   }
   public String getMembershipUsername() {

       return driver.findElement(membershipUsernameLocator).getText();
   }
   public String getMembershipPassword() {

       return driver.findElement(membershipPasswordLocartor).getText();
   }
   public String getPlanDetails(){
        return driver.findElement(planDetailsLocator).getText();
   }
   public String getPlanDetails1(){
        return driver.findElement(planDetails1Locator).getText();
   }
   public String getPlanDetails2(){
        return driver.findElement(planDetails2Locator).getText();
   }
    public void clickOnLogoutButton(){

        driver.findElement(logoutButtonLocator).click();
    }
}
