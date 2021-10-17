package pageElements;

import com.google.inject.Binder;
import com.google.inject.Module;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;
import utilities.Parent;

public class NavbarElements extends Parent implements Module {
    public NavbarElements(){
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }


    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    private WebElement btnContactUs;
    @FindBy(css = "a[class='login']")
    private WebElement btnSignIn;

    public WebElement getBtnContactUs() {
        return btnContactUs;
    }

    public WebElement getBtnSignIn() {
        return btnSignIn;
    }

    @Override
    public void configure(Binder binder) {

    }
}
