package lib.ui.mobile_web;

import lib.ui.NavigationUi;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUi {
    static {
        MY_LISTS_LINK = "css:a[data-event-name='watchlist']";
        OPEN_NAVIGATION = "css:#mw-mf-main-menu-button";
    }
    public MWNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
