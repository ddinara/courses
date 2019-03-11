package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUi extends MainPageObject {

    protected static String
            MY_LISTS_LINK;

    public NavigationUi(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyList()
    {
        this.waitForElementAndClick(
                MY_LISTS_LINK,
                "Cannot find navigation button to My list",
                5

        );
    }

}
