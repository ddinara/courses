package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUi;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Learning programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUi NavigationUi = new NavigationUi(driver);
        NavigationUi.clickMyList();

        MyListsPageObject MyListPageObject = new MyListsPageObject(driver);
        MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeByArticleToDelete(article_title);

    }

    @Test
    public void testSavingTwoArticles() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("hhkb");
        SearchPageObject.clickByArticleWithSubstring("Happy Hacking Keyboard");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "keyboard";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("FrogPad");
        SearchPageObject.clickByArticleWithSubstring("FrogPad");

        ArticlePageObject.addArticleMyReadingList();
        ArticlePageObject.closeArticle();

        NavigationUi NavigationUi = new NavigationUi(driver);
        NavigationUi.clickMyList();

        MyListsPageObject MyListPageObject = new MyListsPageObject(driver);
        MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.waitForArticleToAppearByTitle(article_title);
        MyListPageObject.swipeByArticleToDelete(article_title);

        ArticlePageObject.openAndCheckArticle();
        String saved_title_article = ArticlePageObject.getArticleTitle();

        assertEquals(
                "We see unexpected title!",
                "FrogPad",
                saved_title_article
        );
    }
}
