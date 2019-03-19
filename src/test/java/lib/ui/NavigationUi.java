package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;
import lib.Platform;

abstract public class NavigationUi extends MainPageObject {

    protected static String
            MY_LISTS_LINK,
            OPEN_NAVIGATION;

    public NavigationUi(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openNavigation()
    {
        if(Platform.getInstance().isMW()){
            this.waitForElementAndClick(OPEN_NAVIGATION,"Cannot find click open navigation buton.",5);
        }else {
            System.out.println("Method openNavigation() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }
    public void clickMyList()
    {
        if(Platform.getInstance().isMW()){
            this.tryClickElementWithFewAttempts(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My list",
                    5
            );
        }
        this.waitForElementAndClick(
                MY_LISTS_LINK,
                "Cannot find navigation button to My list",
                5

        );
    }

}
