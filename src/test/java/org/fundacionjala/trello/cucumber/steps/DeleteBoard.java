package org.fundacionjala.trello.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.trello.pages.Boards;
import org.fundacionjala.trello.pages.SelectedBoard;

public class DeleteBoard {

    private Boards boardsPage;
    private SelectedBoard board;

    public DeleteBoard(Boards boardsPage, SelectedBoard board) {
        this.boardsPage = boardsPage;
        this.board = board;
    }

    @Given("I select board {string}")
    public void iSelectBoard(String arg0) {
    }


    @And("I close Board")
    public void iCloseBoard() {

    }

    @And("I delete Board")
    public void iDeleteBoard() {

    }

    @Then("I don't should see the board")
    public void iDonTShouldSeeTheBoard() {

    }
}
