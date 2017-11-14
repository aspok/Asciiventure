package de.marczim.asciiventure.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

/**
 * Created by Marc Zimmermann on 05.11.2017.
 */

public class Monster {

    private final String TAG = "Monster";

    private Array<Item> item;
    private String Name;
    private int hp, exp, gold, level;
    private float strength, defense, speed;


    public Monster(int RoomLevel) {
        init(RoomLevel);
        item = generateItem();
    }

    public Monster(String name, int RoomLevel) {
        this.level = RoomLevel;
        init(this.level);
        Name = name;
        item = generateItem();
    }

    public Array<Item> getDrop() {
        return item;
    }

    public void setDrop(Array<Item> drop) {
        this.item = drop;
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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    private void init(int Roomlevel) {

        JsonReader reader = new JsonReader();
        //Root aus Monster.json
        JsonValue monsterBase = reader.parse(Gdx.files.internal("data/monster.json"));

        int monsterIndex = monsterBase.child.size - 1;

        int id = MathUtils.random(0, monsterIndex);

        JsonValue monster = monsterBase.child.child.get(id);

        this.setName(monster.child.getString("name"));
        this.hp = monster.child.getInt("hp");
        this.strength = monster.child.getFloat("str");
        this.defense = monster.child.getFloat("def");
        this.speed = monster.child.getFloat("speed");
        this.exp = monster.child.getInt("ep");
        this.gold = monster.child.getInt("gold");

        reader = null;
    }

    private Array<Item> generateItem() {

        Item item = new Item(this.level);

        Array<Item> rI = new Array<Item>();
        rI.add(item);

        return rI;
    }


}
