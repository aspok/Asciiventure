package de.marczim.asciiventure.entity;

/**
 * Created by Marc Zimmermann on 05.11.2017.
 */

public class Item {

    private String name;
    private int value;

    public Item(String Name,int Value ) {
        this.name = Name;
        this.value = Value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
