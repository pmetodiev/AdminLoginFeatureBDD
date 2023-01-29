import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AdminLoginStepDef {
    private static final String LOGIN_ADMIN_URL = "https://shop.pragmatic.bg/admin/";

    private static final By LOC_USERNAME = By.id("input-username");
    private static final By LOC_PASSWORD = By.id("input-password");
    private static final By LOC_LOGIN_BUTT = By.cssSelector(".btn.btn-primary");
    private static final By LOC_LOGOUT_BUTTON = By.xpath("//a[contains(@href, 'logout')]");


    @Given("the user is on the admin login page")
    public void the_user_is_on_the_admin_login_page() {
        Browser.driver.get(LOGIN_ADMIN_URL);
    }

    @When("the user logs in using username {string} and password {string}")
    public void theUserLogsInUsingUsernameAndPassword(String username, String password) {
        Browser.driver.findElement(LOC_USERNAME).sendKeys(username);
        Browser.driver.findElement(LOC_PASSWORD).sendKeys(password);
    }

    @And("the user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        Browser.driver.findElement(LOC_LOGIN_BUTT).click();
    }

    @Then("the user should successfully log in into the admin panel")
    public void theUserShouldSuccessfullyLogInIntoTheAdminPanel() {
        String actualTitle = Browser.driver.getTitle();
        Assert.assertEquals(actualTitle, "Dashboard");
    }

    @And("the user logs out via the logout button")
    public void theUserLogsOutViaTheLogoutButton() {
        Browser.driver.findElement(LOC_LOGOUT_BUTTON).click();
    }
}
