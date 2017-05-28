package com.bjardon.contextfreegrammar.data.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by bruno on 15/04/17.
 */
public class NonTerminal extends Symbol {

    private StringProperty label = new SimpleStringProperty();
    private javafx.beans.property.ListProperty<Rule> rules;

}
