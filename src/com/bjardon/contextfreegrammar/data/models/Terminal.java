package com.bjardon.contextfreegrammar.data.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Created by bruno on 29/03/17.
 */
public class Terminal extends Symbol {

    private ObjectProperty<Character> character = new SimpleObjectProperty<>();

    public Terminal() {
        this((char)0);
    }

    public Terminal(char character) {
        this.character.setValue(character);
    }

    public Character getCharacter() {
        return character.get();
    }

    public ObjectProperty<Character> getSymbolProperty() {
        return this.character;
    }

    public void setCharacter(Character character) {
        this.character.set(character);
    }

    @Override
    public String toString() {
        return this.getCharacter().toString();
    }

    @Override
    public boolean equals(Object obj) {
        return ((Terminal)obj).getCharacter() == this.getCharacter();
    }
}
