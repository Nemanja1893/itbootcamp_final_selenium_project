package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage{

    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailInput(){
        return driver.findElement(By.cssSelector("#email"));
    }
    public WebElement getPasswordInput(){
        return driver.findElement(By.cssSelector("#password"));
    }
    public WebElement getConfirmPasswordInput(){
        return driver.findElement(By.cssSelector("#confirmPassword"));
    }
    public WebElement getNameInput(){
        return driver.findElement(By.cssSelector("#name"));
    }
    public WebElement getSignupButton(){
        return driver.findElement(By.cssSelector("*[type='submit']"));
    }

}
