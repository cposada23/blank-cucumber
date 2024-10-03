package blank.appHipertextual.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import framework.utilities.Waits;

public class NewsLetterPage extends BasePage {

    Locator inputEmail;
    Locator newsLetter;
    Locator buttonSubscribe;
    Locator subscribeSuccess;
    public NewsLetterPage(Page page) {
        super(page);
        inputEmail = page.locator("[id='custom-substack-embed'] form input");
        newsLetter = page.locator("//a[text() = 'newsletter']");
        buttonSubscribe = page.locator("//button[text() = 'Suscríbete']");
        subscribeSuccess = page.locator("//p[@class='success']");
    }

    public void waitForAndScrollToNewsLetter() {
        newsLetter.waitFor(new Locator.WaitForOptions().setTimeout(Waits.LONG_WAIT));
        newsLetter.scrollIntoViewIfNeeded();
        PlaywrightAssertions.assertThat(newsLetter).isVisible();
    }
    public void enterEmail(String email) {
        inputEmail.fill(email);
    }

    public void clickButtonSubscribe() {
        buttonSubscribe.click();
    }

    public boolean wasSubscribeSuccesful() {
        return isVisible(subscribeSuccess, Waits.LONG_WAIT, 500);
    }
    
}
