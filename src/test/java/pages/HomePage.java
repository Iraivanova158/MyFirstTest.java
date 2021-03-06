package pages;

import helpers.CommentsHelper;
import io.cucumber.java.sl.In;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private final By ARTICLE = By.tagName("article");
    private final By ACCEPT_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENT_COUNT = By.xpath(".//span[contains(@class, 'list-article__comment')]");

    private BaseFunc baseFunc;
    private WebElement articleToClick;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void acceptCookies() {
        baseFunc.click(ACCEPT_BTN);

    }
    public String getArticleTitleById(int id) {
        articleToClick = baseFunc.findElements(ARTICLE).get(id);
        LOGGER.info("Getting article title from home page: " + articleToClick.findElement(TITLE).getText());
        return articleToClick.findElement(TITLE).getText();

    }
    public int getCommentCountById() {
        int commentCount = 0;

        if (!articleToClick.findElements(COMMENT_COUNT).isEmpty()) {
            String stringToParse = articleToClick.findElement(COMMENT_COUNT).getText();    //Title text (36)
            stringToParse = stringToParse.substring(1, stringToParse.length() - 1); //(36) -> 36
            commentCount = Integer.parseInt(stringToParse);
            LOGGER.info("Comments count: " + commentCount);
        }
        return commentCount;

    }
    public ArticlePage openArticle() {
        LOGGER.info("Opening new page");
        baseFunc.click(articleToClick);
        return new ArticlePage(baseFunc);
    }

}
