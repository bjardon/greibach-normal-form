package com.bjardon.contextfreegrammar.application.framework;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * Created by root on 6/12/15.
 */
public class Container {

    private Scene scene;
    private String title;

    public Container(String source, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(source));
            this.scene = new Scene(root);
            this.title = title;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Scene getScene() {
        return scene;
    }

    public String getTitle() {
        return title;
    }
}
