package blank;

import blank.appHipertextual.HiperTextualApp;
import framework.web.WebApp;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class StepDefinitions {
    String searchTerm;
    HiperTextualApp hiperTextualApp;

    @Before()
    public void setupWebApp() {
        WebApp webApp = new WebApp();
        hiperTextualApp = new HiperTextualApp(webApp.getPage());
    }


    @Given("User navigate to {string}")
    public void userNavigateTo(String url) {
        hiperTextualApp.navigateTo(url);
    }

    @When("User search for {string}")
    public void userSearchFor(String searchTerm) {
        this.searchTerm = searchTerm;
        hiperTextualApp.homePage.searchFor(searchTerm);
        hiperTextualApp.resultsPage.waitForResults();
    }

    @And("User Scrolls down to the first post about {string}")
    public void userScrollsDownToTheFirstPostAbout(String searchString) {
        hiperTextualApp.resultsPage.scrollTo(searchString);
    }

    @Then("User validates that the URL contains the search term")
    public void userValidatesThatTheURLContainsTheSearchTerm() {
        String url = hiperTextualApp.getCurrentURL();
        String validationString = searchTerm.replace(" ", "+");
        Assert.assertTrue(url.contains(validationString), "Url does not contain the search term");
    }

    @And("User click on post")
    public void userClickOnPost() {
        hiperTextualApp.resultsPage.clickFirstPostThatContainsText(searchTerm);
    }

    @Then("User can subscribe to the news letter")
    public void userCanSubscribeToTheNewsLetter() {
        hiperTextualApp.newsLetterPage.waitForAndScrollToNewsLetter();
        hiperTextualApp.newsLetterPage.enterEmail("test@test.com");
        hiperTextualApp.newsLetterPage.clickButtonSubscribe();
        Assert.assertTrue(hiperTextualApp.newsLetterPage.wasSubscribeSuccesful());
    }

}
