package org.search.automation.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.search.automation.PageObjects.SearchResultsPageLocators;
import org.search.automation.utils.HelperClass;


public class SearchResultsPageActions {

    SearchResultsPageLocators searchResultsPageLocators = null;

    public SearchResultsPageActions() {
        this.searchResultsPageLocators = new SearchResultsPageLocators();
        PageFactory.initElements(HelperClass.getDriver(),searchResultsPageLocators);
    }
    public String getSearchResultText(String engine) {
        WebElement searchResult;
        if(engine.equalsIgnoreCase("google"))
            searchResult = searchResultsPageLocators.googleSearchResults;
        else
            searchResult = searchResultsPageLocators.bingSearchResults;
      return searchResult.getText();
    }

}
