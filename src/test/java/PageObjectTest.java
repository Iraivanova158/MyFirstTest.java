import org.junit.jupiter.api.Test;
import pages.BaseFunc;
import pages.HomePage;

import javax.swing.plaf.basic.BasicEditorPaneUI;

public class PageObjectTest {
    @Test
    public void tvnetPageObjectTest(){
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl("http://tvnet.lv");
        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();
        homePage.openArticleById(3);
    }
}
