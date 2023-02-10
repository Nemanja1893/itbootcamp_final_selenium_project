package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage{

    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getVerifyAccountDialog(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".v-dialog--active")));
    }
    public WebElement getVerifyAccountDialogButton(){
        return driver.findElement(By.cssSelector(".btnClose"));
    }
    public WebElement getVerifyAccountMessage(){
        return driver.findElement(By.cssSelector("dlgVerifyAccount"));
    }
    public WebElement getStatusPopUp(){
        return driver.findElement(By.cssSelector("*[role='status']"));
    }
    public WebElement getStatusErrorMessage(){
        return driver.findElement(By.cssSelector("*[role='status'] li"));
    }
}
