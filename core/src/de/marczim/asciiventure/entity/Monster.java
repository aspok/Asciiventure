package de.marczim.asciiventure.entity;

import com.badlogic.gdx.utils.Array;

/**
 * Created by Marc Zimmermann on 05.11.2017.
 */

public class Monster {

    private Array<Item> drop;
    private String Name;
    private int hp, exp;
    private float strength, defense, speed;


    public Monster(String name) {
        Name = name;
        drop = generateItem();
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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public float getStrength() {
        return strength;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }

    public float getDefense() {
        return defense;
    }

    public void setDefense(float defense) {
        this.defense = defense;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    private Array<Item> generateItem() {

        return null;
    }
}
