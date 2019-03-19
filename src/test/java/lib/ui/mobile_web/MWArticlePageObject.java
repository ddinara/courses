package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-action  li#ca-watch.mw-ui-icon-mf-watch button";
        ADD_ARTICLE_TO_MY_READING_LIST = "xpath://div[@class=mw-ui-icon mw-ui-icon-element watch-this-article view-border-box mw-ui-icon-mf-watched watched]";
        OPTION_REMOVE_FROM_MY_LIST_BUTTON = "css:#page-action li#ca-watch.mw-ui-icon-mf-watched button";
        SAVED_FOLDER = "xpath://*[@resource-id='org.wikipedia:id/item_container']//*[@text='keyboard']";
        SAVED_ARTICLE = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='FrogPad']";
        CHECK_ARTICLE_BY_TITLE_TPL = "id:org.wikipedia:id/view_page_title_text";
        CLOSE_WINDOW = "xpath://XCUIElementTypeButton[@name='places auth close']";
    }

    public MWArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
