package blank;

import io.cucumber.java.en.*;

public class StepDefinitions {
    String searchTerm;

    @Given("User navigate to {string}")
    public void userNavigateTo(String url) {
    }

    @When("User search for {string}")
    public void userSearchFor(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @And("User Scrolls down to the first post about {string}")
    public void userScrollsDownToTheFirstPostAbout(String searchString) {
    }

    @Then("User validates that the URL contains the search term")
    public void userValidatesThatTheURLContainsTheSearchTerm() {
    }

    @And("User click on post")
    public void userClickOnPost() {
    }

    @Then("User can subscribe to the news letter")
    public void userCanSubscribeToTheNewsLetter() {
    }

}
