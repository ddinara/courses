package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import lib.Platform;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
            TITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            ADD_ARTICLE_TO_MY_READING_LIST,
            SAVED_FOLDER,
            SAVED_ARTICLE,
            CHECK_ARTICLE_BY_TITLE_TPL,
            CLOSE_WINDOW;


    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String checkArticleByTitle(String title)
    {
        return CHECK_ARTICLE_BY_TITLE_TPL.replace("{TITLE}",title);
    }
    /* TEMPLATES METHODS */

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE,"Cannot find article title on page!",15);
    }


    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        if(Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        }else {
            return title_element.getAttribute("name");
        }
    }


    public void swipeToFooter()
    {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    80
            );
        }else {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    80);
        }
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementPresent(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5

        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5

        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Go it' tip overlay",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of article folder",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into article folder input",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press OK button",
                5

        );
    }

    public void addArticlesToMySaved()
    {
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list",5);
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find X link",
                5

        );
    }

    public void closeWindow()
    {
        this.waitForElementAndClick(CLOSE_WINDOW, "Cannot find window button to close", 5);
    }

    public void addArticleMyReadingList()
    {
        this.waitForElementPresent(
                ADD_ARTICLE_TO_MY_READING_LIST,
                "1.Cannot find navigation button 'Add article to my reading list'",
                5
        );

        this.waitForElementAndClick(
                ADD_ARTICLE_TO_MY_READING_LIST,
                "2.Cannot find navigation button 'Add article to my reading list'",
                5
        );

        this.waitForElementPresent(
                SAVED_FOLDER,
                "1.Cannot find 'keyboard' folder",
                5
        );

        this.waitForElementAndClick(
                SAVED_FOLDER,
                "1.Cannot find 'keyboard' folder",
                5
        );
    }

    public void openAndCheckArticle()
    {
        this.waitForElementPresent(
                SAVED_ARTICLE,
                "1.Cannot find saved article 'FrogPad'",
                5
        );

        this.waitForElementAndClick(
                SAVED_ARTICLE,
                "2.Cannot find saved article 'FrogPad'",
                5
        );

    }


    public void checkArticleTitle(String title)
    {
        String search_title_by_id = checkArticleByTitle(title);
        this.assertElementPresent(
                search_title_by_id,
                "Cannot find title"

        );
    }
}
