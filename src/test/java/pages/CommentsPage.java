package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class CommentsPage {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private final By COMMENTS_LIST = By.xpath(".//div[@class = 'article-comment__container']");
    private final By ARTICLE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");

    private BaseFunc baseFunc;

    public CommentsPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getText() {
        LOGGER.info("Getting title from comments page: " + baseFunc.getText(ARTICLE_TITLE));
        return baseFunc.getText(ARTICLE_TITLE);
    }

    public int countComments() {
        LOGGER.info("Comments count: " + baseFunc.findElements(COMMENTS_LIST).size());
        return baseFunc.findElements(COMMENTS_LIST).size();
    }
}