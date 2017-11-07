package de.marczim.asciiventure.game.eventrooms;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import de.marczim.asciiventure.entity.Monster;
import de.marczim.asciiventure.game.Room;

/**
 * Created by ITAD4-TN09 on 07.11.2017.
 */

public class MonsterRoom extends Room {

    int regionid = 0;
    private Monster monster;


    public MonsterRoom(int BaseLevel) {
        super(BaseLevel);
        monster = generateMonster();
    }


    private Monster generateMonster() {

        JsonReader reader = new JsonReader();
        JsonValue MonsterBase = reader.parse(Gdx.files.internal("data/monster.json"));

        return null;
    }


}
