package pages;

import com.sun.xml.internal.rngom.parse.host.Base;
import helpers.CommentsHelper;
import io.cucumber.java.sl.In;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage {
    private BaseFunc baseFunc;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final By ARTICLE_TITLE = By.xpath (".//h1[@itemprop = 'headline name']");
    private final By ARTICLE_COMMENTS = By.xpath(".//a[contains (@class, 'article-share__item article-share__item--comments')]");

    public ArticlePage(BaseFunc baseFunc){
        this.baseFunc = baseFunc;
    }
    public String getTitle (){
        LOGGER.info("Getting article title"  + baseFunc.getText(ARTICLE_TITLE));
        return baseFunc.getText(ARTICLE_TITLE);
    }
    public int getArticleCommentCount(){
        int comCount = 0;
        LOGGER.info("Getting article comments");
        String commentsCount = baseFunc.getText(ARTICLE_COMMENTS);
        return comCount = Integer.parseInt(commentsCount);

    }
    public CommentsPage openComments(){
        LOGGER.info("Open new page with comments");
        baseFunc.click(ARTICLE_COMMENTS);
        return new CommentsPage(baseFunc);

    }

}
