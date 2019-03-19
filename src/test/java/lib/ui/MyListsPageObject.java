package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;


abstract public class MyListsPageObject extends MainPageObject {

    protected static String
           FOLDER_BY_NAME_TPL,
           ARTICLE_BY_TITLE,
           MY_SAVED_ARTICLE,
           REMOVE_FROM_SAVED_BUTTON,
           MY_SAVED_WEB_ARTICLE;

    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE.replace("{TITLE}", article_title);
    }

    private static String getRemoveButtonByTitle(String article_title)
    {
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }

    public MyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);

        this.waitForElementPresent (folder_name_xpath,
                "Cannot find folder by name" + name_of_folder,
                5

        );

        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name" + name_of_folder,
                5

        );
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(article_xpath,"Cannot find saved article by title " + article_title,15);
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPesent(article_xpath,"Saved article still present with title" + article_title,15);
    }

    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        if(Platform.getInstance().isIOS()|| Platform.getInstance().isAndroid()){
        this.swipeElementToLeft(
                article_xpath,
                "Cannot find saved article"
        );}else {
            String remove_locator = getRemoveButtonByTitle(article_title);
            this.waitForElementAndClick(
                    remove_locator,
                    "Cannot click button to remove article from saved",
                    10
            );
        }
        if(Platform.getInstance().isIOS()){
            this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find article");
        }
        if(Platform.getInstance().isMW()){
            driver.navigate().refresh();
        }

        this.waitForArticleToDisappearByTitle(article_title);
    }

    public WebElement waitForIdElement()
    {
        return this.waitForElementPresent(MY_SAVED_ARTICLE,"Cannot find article on list!",15);
    }

    public String getArticle()
    {
        WebElement id_element = waitForIdElement();
        return id_element.getAttribute("id");
    }

    public void openAndCheckMySavedListArticles()
    {
        this.waitForElementPresent(
                MY_SAVED_ARTICLE,
                "1.Cannot find saved article 'FrogPad'",
                5
        );
    }

    public WebElement waitForMySavedWebArticleByXpath(){

       return this.waitForElementPresent(
                MY_SAVED_WEB_ARTICLE,
                "Cannot find my saved web-article 'FrogPad'",
                5
        );
    }

    public String getMySavedWebArticle()
    {
        WebElement xpath_element = waitForMySavedWebArticleByXpath();
        return xpath_element.getAttribute("xpath");
    }

}
