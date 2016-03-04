package selenium.com;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import selenium.com.WebDriverFactory.Browser;

public abstract class AbstractSeleniumTest {

    /** ロガー */
    private static final Logger logger = LoggerFactory.getLogger(AbstractSeleniumTest.class);

    /** プロパティ */
    protected static SeleniumPropertyManager prop = SeleniumPropertyManager.INSTANCE;

    /** WebDriver */
    protected static WebDriver driver = null;

    /** 実行ブラウザリスト */
    protected static List<Browser> browserList = new ArrayList<Browser>() {
        {
            /** 実行ブラウザリストの取得 */
            if (Boolean.valueOf(prop.getString("execute.browser.ie"))) add(Browser.IE);
            if (Boolean.valueOf(prop.getString("execute.browser.chrome"))) add(Browser.CHROME);
            if (Boolean.valueOf(prop.getString("execute.browser.firefox"))) add(Browser.FIREFOX);
        }
    };

    /**
     * システムプロパティ設定
     */
    protected void setSystemProperty() {
        logger.debug("システムプロパティ設定");
    }

    /**
     * エレメント取得
     * @param by
     * @return WebElement
     */
    protected WebElement $(By by) {
        return driver.findElement(by);
    }

    /**
     * エレメント取得(button)<br>
     * input type="button" value="文字列"
     * @param value 文字列
     * @return WebElement
     */
    protected WebElement $buttonVal(String value) {
        return driver.findElement(By.cssSelector("input[type='button'][value='" + value + "']"));
    }

}
