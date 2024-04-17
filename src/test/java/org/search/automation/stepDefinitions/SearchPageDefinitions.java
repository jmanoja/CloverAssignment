package org.search.automation.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.search.automation.actions.SearchPageActions;
import org.search.automation.actions.SearchResultsPageActions;
import org.search.automation.utils.HelperClass;
import org.testng.Assert;

public class SearchPageDefinitions {
  SearchPageActions objSearchPage = new SearchPageActions();
  SearchResultsPageActions objSearchResultsPage = new SearchResultsPageActions();

  @When("^I search for \"([^\"]*)\" on \"([^\"]*)\"$")
  public void searchKeyword(String searchKeyword, String engine) {
      objSearchPage.enterSearchKeyword(searchKeyword, engine);
  }

  @Given("^I Open \"([^\"]*)\"$")
  public void iOpen(String engine) {
    HelperClass.openPage(engine);
  }
  @Then("^I should see \"([^\"]*)\" is present in \"([^\"]*)\" results$")
  public void iShouldSeeIsPresentInTheStResults(String searchKeyword, String engine) {
    Assert.assertTrue(objSearchResultsPage.getSearchResultText(engine).contains(searchKeyword), "Searched Keyword is not present in the results");
  }
}
