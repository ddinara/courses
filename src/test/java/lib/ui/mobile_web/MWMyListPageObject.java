package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListPageObject extends MyListsPageObject {
    static {
        ARTICLE_BY_TITLE = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}')]";
        REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}')]/../../div[contains(@class,'watchlist')]";
        MY_SAVED_ARTICLE = "xpath://XCUIElementTypeCollectionView[contains(@id='FrogPad')]";
        MY_SAVED_WEB_ARTICLE = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'FrogPad')]";
    }
    public MWMyListPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
