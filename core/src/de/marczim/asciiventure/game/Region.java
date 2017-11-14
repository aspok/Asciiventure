package de.marczim.asciiventure.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import java.util.UUID;

import javax.tools.JavaCompiler;

import de.marczim.asciiventure.game.eventrooms.MonsterRoom;

/**
 * Created by Marc Zimmermann on 04.11.2017.
 */

public class Region {

    private final String TAG = "Region";

    private Array<Region> neighbors;
    private Array<Room> rooms;
    private int baseLevel, regionID;
    private String name;
    private UUID uuid;

    public Region(String Name, int RegionID, int BaseLevel) {
        this.name = Name;
        this.regionID = RegionID;
        this.baseLevel = BaseLevel;
        this.rooms = generateRoom(RegionID);
        this.uuid = java.util.UUID.randomUUID();
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

    private Array<Room> generateRoom(int regionID) {

        Array<Room> resultRoom = new Array<Room>();

        int minRooms = 10;
        int maxRooms = 23;
        int randomIndex;
        int roomNumber;
        int roomID;

        Room room;

        JsonReader reader = new JsonReader();
        //Root-Tree von Region.json
        JsonValue base = reader.parse(Gdx.files.internal("data/regions.json"));
        //Region mit der RegionID
        JsonValue region = base.child.child.get(Integer.toString(regionID));
        //Aus der RegionID die Rooms
        JsonValue rooms = region.child().get("rooms");

        //Zufallsnummer der Räume
        roomNumber = MathUtils.random(minRooms, maxRooms);

        for (int i = 0; i <= roomNumber; i++) {
            room = null;
            //Prozentsatz der Räume
            randomIndex = MathUtils.random(0, 100);
            for (JsonValue jsonRoom : rooms) {
                if ((jsonRoom.child.child.getInt("from") <= randomIndex) && (jsonRoom.child.child.getInt("to") >= randomIndex)) {
                    //RoomID
                    roomID = jsonRoom.child.child.getInt("id");
                    switch (regionID) {
                        //Wald Region
                        case 1:
                            switch (roomID) {
                                //Monster Room
                                case 1:
                                    room = new MonsterRoom(1);
                                    break;
                            }
                            break;
                    }
                }
                resultRoom.add(room);
            }


        }

        Gdx.app.log(TAG, resultRoom.toString());
        reader = null;
        return resultRoom;
    }
}
