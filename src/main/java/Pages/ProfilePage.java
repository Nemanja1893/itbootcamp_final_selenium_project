package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Method;

public class ProfilePage extends BasePage{

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailInput(){
        return driver.findElement(By.cssSelector("#email"));
    }
    public WebElement getProgressbar(){
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .cssSelector(".v-dialog--persistent")));
    }
    public WebElement getNameInput(){
        return driver.findElement(By.cssSelector("#name"));
    }
    public WebElement getCityInput(){
        return driver.findElement(By.cssSelector("#city"));
    }
    public WebElement getCountryInput(){
        return driver.findElement(By.cssSelector("#country"));
    }
    public WebElement getTwitterUrlInput(){
        return driver.findElement(By.cssSelector("#urlTwitter"));
    }
    public WebElement getGitHubUrlInput(){
        return driver.findElement(By.cssSelector("#urlGitHub"));
    }
    public WebElement getPhoneInput(){
        return driver.findElement(By.cssSelector("#phone"));
    }
    public WebElement getSaveButton(){
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }
    public WebElement getSuccessPopup(){
        return driver.findElement(By.cssSelector(".success"));
    }
    public void clearData(WebElement element){
        element.click();
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.BACK_SPACE);
    }
    public WebElement getSuccessDiv(){
        return driver.findElement(By.cssSelector(".success div[role='status']"));
    }

}
