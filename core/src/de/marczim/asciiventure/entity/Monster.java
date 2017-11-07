package de.marczim.asciiventure.entity;

import com.badlogic.gdx.utils.Array;

/**
 * Created by Marc Zimmermann on 05.11.2017.
 */

public class Monster {

    private Array<Item> drop;
    private String Name;
    private int hp, strength,defense;

    public Monster(String name) {
        Name = name;
    }

    public Array<Item> getDrop() {
        return drop;
    }

    public void setDrop(Array<Item> drop) {
        this.drop = drop;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
