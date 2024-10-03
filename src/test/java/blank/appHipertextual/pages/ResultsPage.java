package blank.appHipertextual.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import framework.utilities.Waits;

public class ResultsPage extends BasePage {

    Locator resultsPageInfo;
    public ResultsPage(Page page) {
        super(page);
        resultsPageInfo = page.locator("//*[@class='page-title' and contains(text(), 'Resultados de la búsqueda')]");
    }


    public void waitForResults() {
        resultsPageInfo.waitFor(new Locator.WaitForOptions().setTimeout(Waits.LONG_WAIT));
    }
    public void scrollTo(String text) {
        Locator thingToScroll = page.locator(String.format("//*[contains(text(), '%s')]", text));
        thingToScroll.first().scrollIntoViewIfNeeded();
    }

    public void clickFirstPostThatContainsText(String text) {
        Locator link = page.locator(String.format("//a[contains(text(), '%s')]", text));
        link.first().click();
    }
}
