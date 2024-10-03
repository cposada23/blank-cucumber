package blank.appHipertextual;

import blank.appHipertextual.pages.HomePage;
import blank.appHipertextual.pages.NewsLetterPage;
import blank.appHipertextual.pages.ResultsPage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class HiperTextualApp {
    private Page page;
    public HomePage homePage;
    public ResultsPage resultsPage;
    public NewsLetterPage newsLetterPage;

    public HiperTextualApp(Page page) {
        this.page = page;
        this.homePage = new HomePage(page);
        this.resultsPage = new ResultsPage(page);
        this.newsLetterPage = new NewsLetterPage(page);
    }

    public void navigateTo(String url) {
        page.navigate(url);
        homePage.hardWait(5000);
    }

    public String getCurrentURL() {
        return page.url();
    }

}
