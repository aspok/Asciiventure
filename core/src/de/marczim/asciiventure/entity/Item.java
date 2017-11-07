package de.marczim.asciiventure.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

/**
 * Created by Marc Zimmermann on 05.11.2017.
 */

public class Item {

    private String name;
    private int value;

    public Item() {
        init();
    }

    public Item(String Name, int Value ) {
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

    private void init(){

        JsonReader reader = new JsonReader();
        JsonValue itemBase = reader.parse(Gdx.files.internal("data/items.json"));



        reader = null;

    }
}
