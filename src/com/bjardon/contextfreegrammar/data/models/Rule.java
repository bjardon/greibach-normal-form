package com.bjardon.contextfreegrammar.data.models;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;

/**
 * Created by bruno on 15/04/17.
 */
public class Rule {

    private ListProperty<Symbol> sequence = new SimpleListProperty<>();

    public Rule(String rule) {

        for (char c : rule.toCharArray()) {
            sequence.add(new Symbol());
        }

    }

}
