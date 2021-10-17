package stepDefinitions;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import pageElements.NavbarElements;
import pageElements.SignInPageElements;
import utilities.BaseDriver;
import utilities.Parent;
import io.qameta.allure.*;


@Guice(modules = {NavbarElements.class,SignInPageElements.class})
public class NewFeaturesTests extends BaseDriver {
    @Inject
    NavbarElements navbarElements;
    @Inject
    SignInPageElements signInPageElements;


    @Test(priority = 1)
    @Description("Switching windows or tabs")
    void switchingWindowsOrTabs() {
        /*
        Selenium 4 provides a new api NewWindow which creates a new tab or new window and automatically switches to it.
        Using this feature, a user can open a URL in a new tab along with the existing tab.
         */

        navbarElements.clickFunction(navbarElements.getBtnSignIn());
        Parent.delay(2);
        driver.switchTo().newWindow(WindowType.TAB).get("http://automationpractice.com/index.php");
        Parent.delay(2);
        driver.switchTo().newWindow(WindowType.WINDOW).get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        Parent.delay(2);
    }

    @Test(priority = 2)
    @Description("Minimize window")
    void minimizeWindow() {

        //Minimizes the window of current browsing context. Minimize window hides the window in the system tray.
        driver.manage().window().minimize();
        Parent.delay(2);
        driver.manage().window().fullscreen();
        Parent.delay(2);
    }

    @Test(priority = 3)
    @Description("Relative locators")
    void relativeLocator() {
       /*
            This feature help you locate elements that are nearby other elements.
            Relative locators are as follows:
                above
                below
                toLeftOf
                toRightOf
                near
         */

        navbarElements.clickFunction(navbarElements.getBtnSignIn());

        WebElement inputEmail = driver.findElement(By.id("email"));
        inputEmail.sendKeys("Type Any Email");

        // .below()
        WebElement inputPassword = driver.findElement(RelativeLocator.with(By.tagName("input"))
                        .below(inputEmail));
        inputPassword.sendKeys("Type Any Password");

        // .above()
        WebElement txtEmailAddress =
                driver.findElement(RelativeLocator.with(By.tagName("label"))
                        .above(inputEmail));

        signInPageElements.verifyElementContainsText(txtEmailAddress,"Email address");
    }


}
