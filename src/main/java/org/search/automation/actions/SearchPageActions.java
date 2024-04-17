package org.search.automation.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.search.automation.PageObjects.SearchPageLocators;
import org.search.automation.utils.HelperClass;
import org.openqa.selenium.support.PageFactory;


public class SearchPageActions {

    SearchPageLocators searchPageLocators = null;
    public SearchPageActions() {
        this.searchPageLocators = new SearchPageLocators();
        PageFactory.initElements(HelperClass.getDriver(),searchPageLocators);
    }

    public void enterSearchKeyword(String word, String engine){
        WebElement searchField;
        if(engine.equalsIgnoreCase("google"))
            searchField = searchPageLocators.googleSearchField;
        else
            searchField = searchPageLocators.bingSearchField;
        searchField.click();
        searchField.sendKeys(word);
        searchField.sendKeys(Keys.ENTER);
    }

}
