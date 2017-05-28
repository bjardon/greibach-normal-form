package com.bjardon.contextfreegrammar.application.controllers;

import com.bjardon.contextfreegrammar.Main;
import com.bjardon.contextfreegrammar.application.framework.Manager;
import com.bjardon.contextfreegrammar.application.framework.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class AppController {

    @FXML
    private AnchorPane root;

    public void change(View view) {
        Manager.setVisible(view);
    }

    @FXML
    public void newFile(ActionEvent event) {
        Main.flushData();
        this.change(Main.getResourceLibrary().IC_ALPHABET);
    }

    @FXML
    public void saveFile(ActionEvent event) {

    }

    @FXML
    public void openFile(ActionEvent event) {

    }

    @FXML
    public void close(ActionEvent event) {

    }

    @FXML
    public void alphabetNewSymbol(ActionEvent event) {

    }

    @FXML
    public void alphabetSummary(ActionEvent event) {

    }

    @FXML
    public void statesNewState(ActionEvent event) {

    }

    @FXML
    public void statesTransitionTable(ActionEvent event) {

    }

    @FXML
    public void automataDraw(ActionEvent event) {

    }

    @FXML
    public void automataSummary(ActionEvent event) {

    }

    @FXML
    public void stringsRun(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        Manager.setRootLayout(this.root);
    }

}
