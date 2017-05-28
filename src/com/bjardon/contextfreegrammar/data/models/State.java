package com.bjardon.contextfreegrammar.data.models;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 * Created by bruno on 29/03/17.
 */
public class State {

    private StringProperty name = new SimpleStringProperty();
    private BooleanProperty acceptance = new SimpleBooleanProperty();
    private MapProperty<Terminal, State> transitions = new SimpleMapProperty<>(FXCollections.observableHashMap());

    public State() {
        this("", false);
    }

    public State(String name, boolean acceptance) {
        this.name.setValue(name);
        this.acceptance.setValue(acceptance);
    }

    public State delta(Terminal terminal) {
        return this.transitions.get(terminal);
    }

    public boolean hasTransition(Terminal terminal) {
        return this.transitions.containsKey(terminal);
    }

    public String getName() {
        return name.getValue();
    }

    public ObservableMap<Terminal, State> getTransitions() {
        return transitions.get();
    }

    public boolean isFinal() {
        return acceptance.get();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public void setFinal(boolean isFinal) {
        this.acceptance.setValue(isFinal);
    }

    public void addTransition(Terminal terminal, State destination) {
        this.transitions.putIfAbsent(terminal, destination);
    }

    public StringProperty getNameProperty() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
