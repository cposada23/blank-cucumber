package blank.appHipertextual.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public abstract class BasePage {

    Page page;
    public BasePage(Page page) {
        this.page = page;
    }
    public void hardWait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isVisible(Locator locator, int millis, int polling) {
        if(polling <= 0) throw new RuntimeException("polling can not be zero or less than zero");
        boolean visible = false;
        while (millis > 0  && !visible) {
            visible = locator.isVisible();
            millis -= polling;
            if(!visible) hardWait(polling);
        }

        return visible;
    }

}
