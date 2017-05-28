package com.bjardon.contextfreegrammar.application.framework;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

/**
 * Created by root on 6/12/15.
 */
public class View {

    private Node node;

    private String source;
    private String title;

    public View(String source, String title) {
        this.source = source;
        this.title = title;
    }

    public void load() {
        try {
            node = FXMLLoader.load(getClass().getResource(source));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSource() {
        return source;
    }

    public Node getNode() {
        return node;
    }

    public String getTitle() {
        return title;
    }
}
