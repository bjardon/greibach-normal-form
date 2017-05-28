package com.bjardon.contextfreegrammar.application.framework;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by root on 20/12/15.
 */
public class Manager {

    private static AnchorPane rootLayout;

    public static void setRootLayout(AnchorPane pane) {
        rootLayout = pane;
    }

    public static void setVisible(View view) {
        view.load();
        rootLayout.getChildren().clear();
        rootLayout.getChildren().add(view.getNode());
        ((Stage) rootLayout.getScene().getWindow()).setTitle(view.getTitle());
    }

}
