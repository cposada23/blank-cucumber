package blank.appHipertextual.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage{

    Locator searchIcon;

    public HomePage(Page page) {
        super(page);
        this.searchIcon = page.locator("[id='page'] [id='search-toggle'] [class='search-icon']");
    }

    public void clickSearchIcon() {

    }
}
