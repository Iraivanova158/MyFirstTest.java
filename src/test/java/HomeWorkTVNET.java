import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWorkTVNET {
    private final By ARTICLE_CLICK = By.xpath(".//span[contains (@class, 'list-article__headline')]");
    private final By ARTICLE_COMMENTS = By.xpath(".//img[@src = '/v5/img/icons/comment-v2.svg']");
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@itemprop='headline name']");
    private final By COMMENT_COUNT = By.xpath(".//span[contains(@class, 'article__comment')]");
    private final Logger LOGGER = LogManager.getLogger(HomeWorkTVNET.class);

    @Test
    public void secondTest() {
        String articleToOpen = "Valdība lems par Covid-19 ierobežojumu pagarināšanu";

        System.setProperty("webdriver.chrome.driver", "/Users/ada/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tvnet.lv");

//        LOGGER.info("Open any article and its comments");
//        WebElement clickArticle = driver.findElement(ARTICLE_CLICK);
//        clickArticle.click();
//        WebElement clickComments = driver.findElement(ARTICLE_COMMENTS);
//        clickComments.click();

//        LOGGER.info("Find and store articles");
//        List<WebElement> articles = driver.findElements(TITLE);

//        LOGGER.info("Open article by name");
//        for (int i = 0; i < articles.size(); i++) {
//            if (articles.get(i).getText().startsWith(articleToOpen)) {
//                articles.get(i).click();
//                break;

        LOGGER.info("Take 5th article");
        WebElement currentArticle = driver.findElements(ARTICLE).get(4);

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

        LOGGER.info("Open 5 article");
        currentArticle.findElement(TITLE).click();

        LOGGER.info("find and check title");
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();
        Assertions.assertTrue(titleToCompare.startsWith(articlePageTitle), "wrong title on article page");
        System.out.println(titleToCompare);
        System.out.println(articlePageTitle);
    }

    }





