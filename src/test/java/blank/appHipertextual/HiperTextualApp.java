package blank.appHipertextual;

import blank.appHipertextual.pages.HomePage;
import com.microsoft.playwright.Page;

public class HiperTextualApp {
    private Page page;
    public HomePage homePage;

    public HiperTextualApp(Page page) {
        this.page = page;
        this.homePage = new HomePage(page);
    }

    public void navigateTo(String url) {
        page.navigate(url);
    }
}
