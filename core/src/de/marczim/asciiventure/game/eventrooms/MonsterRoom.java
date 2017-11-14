package de.marczim.asciiventure.game.eventrooms;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import de.marczim.asciiventure.entity.Monster;
import de.marczim.asciiventure.game.Room;

/**
 * Created by Marc Zimmermann on 07.11.2017.
 */

public class MonsterRoom extends Room {

    private Monster monster;


    public MonsterRoom(int BaseLevel) {
        super(BaseLevel);
        //Erstelle ein neues Monster
        monster = new Monster(this.getBaselevel());
    }


}
