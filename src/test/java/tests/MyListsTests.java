package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factory.ArticlePageObjectFactory;
import lib.ui.factory.MyListsPageObjectFactory;
import lib.ui.factory.NavigationUIFactory;
import lib.ui.factory.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class MyListsTests extends CoreTestCase
{
    private static final String name_of_folder = "Learning programming";
    private static final String nameOfMyFolder = "keyboard";
    private static final String
            login = "DD8619",
            password = "ddd999mmm";
    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();


        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder);
        }else {
            ArticlePageObject.addArticlesToMySaved();
        }
        if(Platform.getInstance().isMW()){
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();
            ArticlePageObject.waitForTitleElement();
            assertEquals("We are not on the same page after login.",
                    article_title,
                    ArticlePageObject.getArticleTitle());
        }
        ArticlePageObject.closeWindow();
        ArticlePageObject.closeArticle();

        NavigationUi NavigationUi = NavigationUIFactory.get(driver);
        NavigationUi.openNavigation();
        NavigationUi.clickMyList();

        MyListsPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);
        if(Platform.getInstance().isAndroid()){
            MyListPageObject.openFolderByName(name_of_folder);
        }

        MyListPageObject.swipeByArticleToDelete(article_title);

    }

    @Test
    public void testSavingTwoArticles() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("hhkb");
        SearchPageObject.clickByArticleWithSubstring("appy Hacking Keyboard");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(nameOfMyFolder);
        }else {
            ArticlePageObject.addArticlesToMySaved();
        }
        if(Platform.getInstance().isMW()){
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();
            ArticlePageObject.waitForTitleElement();
            assertEquals("We are not on the same page after login.",
                    article_title,
                    ArticlePageObject.getArticleTitle());
        }
        ArticlePageObject.closeWindow();
        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("FrogPad");
        SearchPageObject.clickByArticleWithSubstring("rogPad");

        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleMyReadingList();
        }else {
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeArticle();

        NavigationUi NavigationUi = NavigationUIFactory.get(driver);
        NavigationUi.openNavigation();
        NavigationUi.clickMyList();

        MyListsPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid())
            MyListPageObject.openFolderByName(nameOfMyFolder);

        MyListPageObject.waitForArticleToAppearByTitle(article_title);
        MyListPageObject.swipeByArticleToDelete(article_title);

        if (Platform.getInstance().isAndroid())
            ArticlePageObject.openAndCheckArticle();

        MyListPageObject.openAndCheckMySavedListArticles();
        if (Platform.getInstance().isAndroid()){
        String saved_title_article = ArticlePageObject.getArticleTitle();

        assertEquals(
                "We see unexpected title!",
                "FrogPad",
                saved_title_article
        );
        }if (Platform.getInstance().isIOS()) {
            String saved_article = MyListPageObject.getArticle();

            assertEquals(
                    "We see unexpected article!",
                    "FrogPad",
                    saved_article
            );
        }else {
            String my_saved_article = MyListPageObject.getMySavedWebArticle();

            assertEquals(
                    "We see unexpected article!",
                    "FrogPad",
                    my_saved_article
            );
        }
    }
}
