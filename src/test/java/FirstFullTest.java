import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstFullTest {
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath (".//span[@itemprop = 'headline name']");
    private final By COMMENT_COUNT = By.xpath(".//span[contains(@class, 'article__comment')]");

    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");

    private final Logger LOGGER = LogManager.getLogger(FirstFullTest.class);

    @Test
    public void titleAndCommentsCheck () {
        LOGGER.info("This test is checking titles and comments on TVnet page");
        System.setProperty("webdriver.chrome.driver", "/Users/ada/Downloads/chromedriver");

        LOGGER.info("Opening browser window");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        LOGGER.info("Going to TVNET homepage");
        driver.get("http://tvnet.lv");


        LOGGER.info("Take 3d article");
        WebElement currentArticle = driver.findElements(ARTICLE).get(2);

        LOGGER.info("Find and store article title");
        String titleToCompare = currentArticle.findElement(TITLE).getText();

        LOGGER.info("Find and store comments count");
        int commentsCount = 0;

        if (!currentArticle.findElements(COMMENT_COUNT).isEmpty()) {
            WebElement element = currentArticle.findElement(COMMENT_COUNT);
            String stringToParse = element.getText();
            stringToParse = stringToParse.substring(1, stringToParse.length() - 1);
            commentsCount = Integer.parseInt(stringToParse);
        }

        LOGGER.info("Open Article");
        currentArticle.findElement(TITLE).click();

        LOGGER.info("find and check title");
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();
//        Assertions.assertEquals(titleToCompare, articlePageTitle, "wrong title on article page");
        Assertions.assertTrue(titleToCompare.startsWith(articlePageTitle),"wrong title on article page");

//        find and check comments count

//        open comments page

//        find and check title

//        find and check comments count
    }
}
