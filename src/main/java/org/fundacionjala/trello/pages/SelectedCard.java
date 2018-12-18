package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * this class represent a selected card page.
 */
public class SelectedCard extends AbstractPage {

    /**
     * Method for verify that card new to were created.
     * @param expected is name of create card.
     */
    public void verify(final String expected) {
        String result = driver.findElement(By.cssSelector(".js-card-name")).getText();
        Assert.assertEquals(expected, result);
        closeDriver();
    }
}
