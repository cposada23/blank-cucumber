package blank.appHipertextual.pages;

import com.microsoft.playwright.Page;

public abstract class BasePage {

    Page page;
    public BasePage(Page page) {
        this.page = page;
    }
}
