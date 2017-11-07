package de.marczim.asciiventure.game.eventrooms;

import de.marczim.asciiventure.entity.Monster;
import de.marczim.asciiventure.game.Room;

/**
 * Created by ITAD4-TN09 on 07.11.2017.
 */

public class MonsterRoom extends Room {

    int regionid = 0;
    private Monster monster;

    public MonsterRoom() {
        monster = generateMonster();
    }


    private Monster generateMonster() {

        return null;
    }
}
