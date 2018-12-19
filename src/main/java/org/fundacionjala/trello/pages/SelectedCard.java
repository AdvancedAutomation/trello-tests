package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * this class represent a selected card page.
 */
public class SelectedCard extends AbstractPage {

    @FindBy(css = ".js-card-name")
    private WebElement cardName;

    /**
     * Method for verify that card new to were created.
     * @return the name of create card String.
     */
    public String getTitle() {
        return cardName.getText();
    }
}
