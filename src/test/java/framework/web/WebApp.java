package framework.web;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ViewportSize;
import framework.utilities.PropertyFileReader;
import framework.web.factory.BrowserFactory;
import framework.web.factory.browsers.BrowserEnum;
import lombok.Getter;


@Getter
public class WebApp {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    public Page getNewPage() {
        return context.newPage();
    }

    public BrowserContext getNewContext() {
        return browser.newContext();
    }

    private boolean isHeadless() {
        String headless = System.getProperty("headless");
        if(headless != null && !headless.isEmpty()) {
            return headless.contains("true");
        }
        return false;
    }
    public WebApp() {
        String browserType = PropertyFileReader.readFromPropertyFile("general.properties", "browser");
        boolean headless = isHeadless();

        this.playwright = Playwright.create();
        BrowserFactory factory = new BrowserFactory(this.playwright);
        this.browser = factory.createBrowser(BrowserEnum.browser(browserType), headless);
        this.context = browser.newContext(
            new Browser.NewContextOptions().setViewportSize(
                headless ?  new ViewportSize(1921, 1080) : null
            )
        );

        this.page = context.newPage();
    }


    public void close() {
        // this.context.tracing().stop();
        this.context.close();
        this.playwright.close();
    }

}
