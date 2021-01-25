package pages;

import com.sun.xml.internal.rngom.parse.host.Base;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage {
    private final By TITLE = By.xpath (".//span[@itemprop = 'headline name']");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");

    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc){
        this.baseFunc = baseFunc;
    }
    public void articleToCompare(){

    }

}
