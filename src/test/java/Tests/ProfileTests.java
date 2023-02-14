package Tests;

import com.sun.org.glassfish.gmbal.Description;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BasicTest {

    @Test(priority = 10)
    @Description("Visits the profile page")
    public void visitProfilePage() {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();

        navPage.getMyProfileLink().click();
        waitForUrl("/profile");

        wait.until(ExpectedConditions.invisibilityOf(profilePage.getProgressbar()));

        Assert.assertEquals(profilePage.getEmailInput().getAttribute("value"),
                "admin@admin.com",
                "Email input is incorrect");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        String emailValue = (String) js.executeScript("return arguments[0].getAttribute('value');",
//                profilePage.getEmailInput());
//        Assert.assertEquals(emailValue, email,"Value is incorrect");

        navPage.getLogoutButton().click();
    }

    @Test(priority = 20)
    @Description("Checks input types")
    public void checkInputTypes() throws InterruptedException {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();

        navPage.getMyProfileLink().click();
        waitForUrl("/profile");

        wait.until(ExpectedConditions.invisibilityOf(profilePage.getProgressbar()));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String attrDisabled = (String) js.executeScript("return arguments[0].getAttribute('disabled');",
                profilePage.getEmailInput());

        Assert.assertEquals(profilePage.getEmailInput().getAttribute("type"),
                "email",
                "Type is incorrect");
        Assert.assertEquals(attrDisabled,
                "disabled",
                "Disabled value is incorrect");
        Assert.assertEquals(profilePage.getNameInput().getAttribute("type"),
                "text",
                "Type is incorrect");
        Assert.assertEquals(profilePage.getCityInput().getAttribute("type"),
                "text",
                "Type is incorrect");
        Assert.assertEquals(profilePage.getCountryInput().getAttribute("type"),
                "text",
                "Type is incorrect");
        Assert.assertEquals(profilePage.getTwitterUrlInput().getAttribute("type"),
                "url",
                "Value is incorrect");
        Assert.assertEquals(profilePage.getGitHubUrlInput().getAttribute("type"),
                "url",
                "Type is incorrect");
        Assert.assertEquals(profilePage.getPhoneInput().getAttribute("type"),
                "tel",
                "Type is incorrect");

        navPage.getLogoutButton().click();
    }
    @Test(priority = 30)
    @Description("Edits profile")
    public void editProfile(){
        String email = "admin@admin.com";
        String password = "12345";
        String name = "Nemanja Nikolic";
        String phone = "+38161283223";
        String city = "Bucaramanga";
        String country = "Spain";
        String twitter = "https://twitter.com/profile/milan1232";
        String gitHub = "https://github.com/nemanja1893";

        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();

        navPage.getMyProfileLink().click();
        wait.until(ExpectedConditions.invisibilityOf(profilePage.getProgressbar()));

//        profilePage.clearData(profilePage.getEmailInput());
//        profilePage.getEmailInput().sendKeys(email);

        profilePage.clearData(profilePage.getNameInput());
        profilePage.getNameInput().sendKeys(name);

        profilePage.clearData(profilePage.getPhoneInput());
        profilePage.getPhoneInput().sendKeys(phone);

        profilePage.clearData(profilePage.getCityInput());
        profilePage.getCityInput().sendKeys(city);

        profilePage.clearData(profilePage.getCountryInput());
        profilePage.getCountryInput().sendKeys(country);

        profilePage.clearData(profilePage.getTwitterUrlInput());
        profilePage.getTwitterUrlInput().sendKeys(twitter);

        profilePage.clearData(profilePage.getGitHubUrlInput());
        profilePage.getGitHubUrlInput().sendKeys(gitHub);

        profilePage.getSaveButton().click();

        wait.until(ExpectedConditions.visibilityOf(profilePage.getSuccessDiv()));
        Assert.assertTrue(profilePage.getSuccessDiv().getText().contains("Profile saved successfuly"),
                "Message is incorrect");

        Assert.assertEquals(profilePage.getNameInput().getAttribute("value"),
                name,
                "Value is incorrect");
        Assert.assertEquals(profilePage.getPhoneInput().getAttribute("value"),
                phone,
                "Value is incorrect");
        Assert.assertEquals(profilePage.getCityInput().getAttribute("value"),
                city,
                "Value is incorrect");
        Assert.assertEquals(profilePage.getCountryInput().getAttribute("value"),
                country,
                "Value is incorrect");
        Assert.assertEquals(profilePage.getTwitterUrlInput().getAttribute("value"),
                twitter,
                "Value is incorrect");
        Assert.assertEquals(profilePage.getGitHubUrlInput().getAttribute("value"),
                gitHub,
                "Value is incorrect");

        navPage.getLogoutButton().click();
    }


}