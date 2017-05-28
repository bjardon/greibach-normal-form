package com.bjardon.contextfreegrammar;

import com.bjardon.contextfreegrammar.data.models.State;
import com.bjardon.contextfreegrammar.data.models.Terminal;
import com.bjardon.contextfreegrammar.resources.ResourceLibrary;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class Main extends Application {

    private static ResourceLibrary resourceLibrary;
    private static ObservableList<Terminal> alphabet = FXCollections.observableArrayList();
    private static ObservableList<State> states = FXCollections.observableArrayList();
    private static State initialState = new State();

    @Override
    public void start(Stage stage) throws Exception{
        resourceLibrary = new ResourceLibrary();
        stage = resourceLibrary.APP_WINDOW.getStage();
        stage.show();
    }

    public static ObservableList<Terminal> getAlphabet() {
        return alphabet;
    }

    public static ObservableList<State> getStates() {
        return states;
    }

    public static ResourceLibrary getResourceLibrary() {
        return resourceLibrary;
    }

    public static State getInitialState() {
        return initialState;
    }

    public static void setInitialState(State initialState) {
        Main.initialState = initialState;
    }

    public static void flushData() {
        alphabet.clear();
        states.clear();
        initialState = new State();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
