package de.marczim.asciiventure.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

/**
 * Created by Marc Zimmermann on 05.11.2017.
 */

public class Item {

    private final String TAG = "ITEM";

    private String name;
    private int value, monsterlvl;

    public Item(int MonsterLVL) {
        this.monsterlvl = MonsterLVL;
        init();
    }

    public Item(String Name, int Value, int MonsterLVL) {
        this.monsterlvl = MonsterLVL;
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

    private void init() {

        /*
        JsonReader reader = new JsonReader();
        JsonValue itemBase = reader.parse(Gdx.files.internal("data/items.json"));
        reader = null;
        */

        debugItem();

    }

    private void debugItem() {

        this.name = "Debug Item";
        this.value = 1;

    }
}
