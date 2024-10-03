package blank.appHipertextual.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import framework.utilities.Waits;

public class HomePage extends BasePage{

    Locator searchIcon;
    Locator searchInput;
    Locator submitButton;

    public HomePage(Page page) {
        super(page);
        this.searchIcon = page.locator("[id='page'] [id='search-toggle'] [class='search-icon']");
        this.searchInput = page.locator("[id='page'] [id='search-form-2']");
        this.submitButton = page.locator("//*[@id='page']//input[@id='search-form-2']/following-sibling::button[@type='submit']");
    }

    public void clickSearchIcon() {
        searchIcon.waitFor(new Locator.WaitForOptions().setTimeout(Waits.LONG_WAIT));
        searchIcon.click();
    }

    public void searchFor(String searchTerm) {
        this.clickSearchIcon();
        searchInput.fill(searchTerm);
        submitButton.click();
    }
}
