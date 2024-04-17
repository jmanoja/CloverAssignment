package org.search.automation.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageLocators {

  @FindBy(xpath = "//textarea[@title='Search']")
  public WebElement googleSearchField;

  @FindBy(xpath = "//textarea[@type='search']")
  public WebElement bingSearchField;

}
