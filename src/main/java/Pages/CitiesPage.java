package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CitiesPage extends BasePage{

    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNewItemButton(){
        return driver.findElement(By.cssSelector(".btnNewItem"));
    }
    public WebElement getNewItemDialog(){
        return driver.findElement(By.cssSelector(".dlgNewEditItem"));
    }
    public WebElement getNewItemInput(){
        return driver.findElement(By.cssSelector("#name"));
    }
    public WebElement getSaveButton(){
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btnSave")));
    }
    public WebElement getSearchInput(){
        return driver.findElement(By.cssSelector("#search"));
    }
    public List<WebElement> getAllCities(int expectedNumOfElements){
        return wait.until(ExpectedConditions.numberOfElementsToBe(By
                .cssSelector("tbody tr"), expectedNumOfElements));
    }
    private WebElement getAnyRow(int row){
        return driver.findElement(By.cssSelector("tbody tr:nth-child("+ row +")"));
    }
    public WebElement getEditButton(int row){
        return getAnyRow(row).findElement(By.cssSelector("#edit"));
//      driver.findElement(By.cssSelector("tbody tr:nth-child("+ row +") #edit"));
    }
    public WebElement getDeleteButton(int row){
        return getAnyRow(row).findElement(By.cssSelector("#delete"));
    }
    public WebElement getAnyCellFromCitiesTable(int row, int column){
        return driver.findElement(By.cssSelector("tbody tr:nth-child("+row+") td:nth-child("+column+")"));
    }
    public WebElement getEditItemDialog(){
        return driver.findElement(By.cssSelector(".dlgNewEditItem"));
    }
    public WebElement getDeleteDialog(){
        return driver.findElement(By.cssSelector(".v-dialog"));
    }
    public WebElement getDeleteButtonFromDialog(){
        return driver.findElement(By.cssSelector(".v-dialog .red--text"));
    }
    public WebElement getEditItemInput(){
        return getEditItemDialog().findElement(By.cssSelector("#name"));
    }
    public WebElement getEditItemSaveButton(){
        return  getEditItemDialog().findElement(By.cssSelector(".btnSave"));
    }
    public WebElement getSuccessPopUp(){
        return driver.findElement(By.cssSelector(".success"));
    }
}
