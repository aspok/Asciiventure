package de.marczim.asciiventure.game;

import com.badlogic.gdx.utils.Array;

/**
 * Created by Marc Zimmermann on 04.11.2017.
 */

public class Region {

    private Array<Region> neighbors;
    private Array<Room> rooms;
    private int baseLevel;
    private String name;

    public Region(){

    }

    public int getBaseLevel() {
        return baseLevel;
    }

    public void setBaseLevel(int baseLevel) {
        this.baseLevel = baseLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Array<Region> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Array<Region> neighbors) {
        this.neighbors = neighbors;
    }

    public Array<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Array<Room> rooms) {
        this.rooms = rooms;
    }
}
