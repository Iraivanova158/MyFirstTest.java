import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.BaseFunc;
import pages.CommentsPage;
import pages.HomePage;

public class TvNetPageTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private int articleId = 1;

    @Test
    public void tvnetPageObjectTest(){
        LOGGER.info("This test is checking article titles and comment counts");

        BaseFunc baseFunc = new BaseFunc();

        LOGGER.info("Opening tvnet.lv");
        baseFunc.openUrl("http://tvnet.lv");

        HomePage homePage = new HomePage(baseFunc);

        LOGGER.info("Accepting cookies");
        homePage.acceptCookies();

        LOGGER.info("Getting article title on Home Page");
        String homePageTitle = homePage.getArticleTitleById(articleId);

        LOGGER.info("Getting comments from article on Home Page");
        int commentsHomePage = homePage.getCommentCountById();

        LOGGER.info("Opening article");
        ArticlePage articlePage = homePage.openArticle();

        LOGGER.info("Getting article title on Article Page");
        String articlePageTitle = articlePage.getTitle();

        LOGGER.info("Getting comments on Article Page");
        int commentsArticlePage = articlePage.getArticleCommentCount();

        LOGGER.info("Comparing article titles");
        Assertions.assertTrue(homePageTitle.startsWith(articlePageTitle), "Titles are not the same");

        LOGGER.info("Comparing article comments q-ty between Home Page and Article Page ");
        Assertions.assertEquals(commentsHomePage, commentsArticlePage, "The comment count is not the same");

        LOGGER.info("Opening comments from Article Page");
        CommentsPage commentsPage = articlePage.openComments();

        LOGGER.info("Getting comments from Comments Page");
        String commentsPageTitle = commentsPage.getText();

        LOGGER.info("Comparing comments between Article Page Title and Comments Page Title");
        Assertions.assertEquals(articlePageTitle, commentsPageTitle, "Comments q-ty inside the Article differs");

        LOGGER.info("Getting real comments q-ty");
        int commentsCount = commentsPage.countComments();

        LOGGER.info("Comparing comments from Home Page and real comments q-ty");
        Assertions.assertEquals(commentsHomePage, commentsCount, "Non-conformity in comments quantity");

        LOGGER.info("Closing TVNET window");
        baseFunc.closeTvNetPage();
    }
}
