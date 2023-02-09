package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailInput(){
        return driver.findElement(By.cssSelector("#email"));
    }
    public WebElement getPasswordInput(){
        return driver.findElement(By.cssSelector("#password"));
    }
    public WebElement getStatusPopUp(){
        return driver.findElement(By.cssSelector("div[role='status']"));
    }
    public WebElement getStatusErrorMessage(){
        return driver.findElement(By.cssSelector("div[role='status'] li"));
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("*[type='submit']"));
    }
}
