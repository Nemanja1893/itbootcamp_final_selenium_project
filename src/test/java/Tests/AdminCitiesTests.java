package Tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{
    @Test(priority = 10)
    @Description("Test #1: Visits the admin cities page and list cities")
    public void visitAdminCitiesPage(){
        String adminEmail = "admin@admin.com";
        String adminPassword = "12345";

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(adminEmail);
        loginPage.getPasswordInput().sendKeys(adminPassword);
        loginPage.getLoginButton().click();

        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();

        waitForUrl("/admin/cities");
    }
    @Test(priority = 20)
    @Description("Test #2: Checks input types for create/edit new city")
    public void createEditCityInput(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();

        citiesPage.getNewItemButton().click();
        wait.until(ExpectedConditions.visibilityOf(citiesPage.getNewItemDialog()));
        Assert.assertEquals(citiesPage.getNewItemInput().getAttribute("type"),
                "text",
                "Input type is incorrect");


    }
    @Test(priority = 30)
    @Description("Test #3: Create new city")
    public void createNewCity(){
        String city = "Nemanja Nikolic's city";

        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();

        citiesPage.getNewItemButton().click();
        wait.until(ExpectedConditions.visibilityOf(citiesPage.getNewItemDialog()));
        citiesPage.getNewItemInput().sendKeys(city);
        citiesPage.getSaveButton().click();

        wait.until(ExpectedConditions.visibilityOf(citiesPage.getSuccessPopUp()));
        Assert.assertTrue(citiesPage.getSuccessPopUp()
                        .getText()
                        .contains("Saved successfully"),"Message is incorrect");


    }
    @Test(priority = 40)
    @Description("Test #4: Edit city")
    public void editCity(){
        String oldCityName = "Nemanja Nikolic's city";
        String newCityName = "Nemanja Nikolic's city Edited";

        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();

        citiesPage.getSearchInput().sendKeys(oldCityName);
        citiesPage.getAllCities(1);
        citiesPage.getEditButton(1).click();

        wait.until(ExpectedConditions.visibilityOf(citiesPage.getEditItemDialog()));
        citiesPage.getEditItemInput().clear();
        citiesPage.getEditItemInput().sendKeys(newCityName);
        citiesPage.getEditItemSaveButton().click();

        wait.until(ExpectedConditions.visibilityOf(citiesPage.getSuccessPopUp()));
        Assert.assertTrue(citiesPage.getSuccessPopUp()
                .getText()
                .contains("Saved successfully"),"Message is incorrect");


    }
    @Test(priority = 50)
    @Description("Test #5: Search city")
    public void searchCity(){
        String cityName = "Nemanja Nikolic's city";

        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();

        citiesPage.getSearchInput().sendKeys(cityName);
        citiesPage.getAllCities(1);


        Assert.assertTrue(citiesPage.getAnyCellFromCitiesTable(1,2).getText().contains(cityName),
                "Name cell doesn't contain text form search input");


    }
    @Test(priority = 60)
    @Description("Test #6: Delete city")
    public void deleteCity(){
        String cityName = "Nemanja Nikolic's city";

        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();

        citiesPage.getSearchInput().sendKeys(cityName);
        citiesPage.getAllCities(1);

        Assert.assertTrue(citiesPage.getAnyCellFromCitiesTable(1,2).getText().contains(cityName),
                "Name cell doesn't contain text form search input");

        citiesPage.getDeleteButton(1).click();
        wait.until(ExpectedConditions.visibilityOf(citiesPage.getDeleteDialog()));

        citiesPage.getDeleteButtonFromDialog().click();

        wait.until(ExpectedConditions.visibilityOf(citiesPage.getSuccessPopUp()));
        Assert.assertTrue(citiesPage.getSuccessPopUp()
                .getText()
                .contains("Deleted successfully"),"Message is incorrect");


    }
}
