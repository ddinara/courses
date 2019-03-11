package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUi;
import lib.ui.SearchPageObject;
import lib.ui.factory.ArticlePageObjectFactory;
import lib.ui.factory.MyListsPageObjectFactory;
import lib.ui.factory.NavigationUIFactory;
import lib.ui.factory.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    private static final String name_of_folder = "Learning programming";
    private static final String nameOfMyFolder = "keyboard";
    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();


        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder);
        }else {
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeWindow();
        ArticlePageObject.closeArticle();

        NavigationUi NavigationUi = NavigationUIFactory.get(driver);
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
        SearchPageObject.clickByArticleWithSubstring("Happy Hacking Keyboard");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(nameOfMyFolder);
        }else {
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeWindow();
        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("FrogPad");
        SearchPageObject.clickByArticleWithSubstring("FrogPad");

        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleMyReadingList();
        }else {
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeArticle();

        NavigationUi NavigationUi = NavigationUIFactory.get(driver);
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
        }else {
            String saved_article = MyListPageObject.getArticle();

            assertEquals(
                    "We see unexpected article!",
                    "FrogPad",
                    saved_article
            );
        }
    }
}
