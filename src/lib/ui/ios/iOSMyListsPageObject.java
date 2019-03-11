package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class iOSMyListsPageObject extends MyListsPageObject
{
  static {
            ARTICLE_BY_TITLE = "xpath://XCUIElementTypeLink[contains(@name='{TITLE}')]";
            MY_SAVED_ARTICLE = "xpath://XCUIElementTypeCollectionView[contains(@id='FrogPad')]";
  }
  public iOSMyListsPageObject(AppiumDriver driver)
  {
    super(driver);
  }
}
