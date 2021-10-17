package pageElements;

import com.google.inject.Binder;
import com.google.inject.Module;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;
import utilities.Parent;

public class SignInPageElements extends Parent implements Module {
    public SignInPageElements(){
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(id = "email")
    private WebElement inputEmailAddress;

    public WebElement getInputEmailAddress() {
        return inputEmailAddress;
    }

    @Override
    public void configure(Binder binder) {

    }
}
