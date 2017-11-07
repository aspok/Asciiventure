package de.marczim.asciiventure.game;

/**
 * Created by Marc Zimmermann on 05.11.2017.
 */

public class Room {

    int baselevel;

    public Room(int BaseLevel) {
        this.baselevel = BaseLevel;
    }

    public int getBaselevel() {
        return baselevel;
    }

    public void setBaselevel(int baseLevel) {
        this.baselevel = baseLevel;
    }
}
