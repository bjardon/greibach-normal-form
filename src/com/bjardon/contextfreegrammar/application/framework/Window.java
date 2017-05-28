package com.bjardon.contextfreegrammar.application.framework;

import javafx.stage.Stage;

/**
 * Created by root on 6/12/15.
 */
public class Window {

    private Stage stage = new Stage();

    public Window(Container container) {
        stage.setScene(container.getScene());
        stage.setTitle(container.getTitle());
    }

    public Stage getStage() {
        return stage;
    }
}
