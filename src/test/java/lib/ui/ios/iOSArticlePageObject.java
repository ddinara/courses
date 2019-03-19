package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSArticlePageObject extends ArticlePageObject
{
  static {
    TITLE = "id:Happy Hacking Keyboard";
    FOOTER_ELEMENT = "id:View article in browser";
    OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
    CLOSE_ARTICLE_BUTTON = "id:Back";
    ADD_ARTICLE_TO_MY_READING_LIST = "xpath://XCUIElementTypeButton[@name='Add “Happy Hacking Keyboard” to a reading list?']";
    SAVED_FOLDER = "xpath://*[@resource-id='org.wikipedia:id/item_container']//*[@text='keyboard']";
    SAVED_ARTICLE = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='FrogPad']";
    CHECK_ARTICLE_BY_TITLE_TPL = "id:org.wikipedia:id/view_page_title_text";
    CLOSE_WINDOW = "xpath://XCUIElementTypeButton[@name='places auth close']";
  }

  public iOSArticlePageObject(RemoteWebDriver driver)
  {
    super(driver);
  }
}
