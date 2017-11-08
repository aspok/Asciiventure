package de.marczim.asciiventure.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

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

    public Region(String Name, int RegionID, int BaseLevel) {
        this.name = Name;
        this.regionID = RegionID;
        this.baseLevel = BaseLevel;
        this.rooms = generateRoom(RegionID);
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
        int roomid;

        Room room;

        JsonReader reader = new JsonReader();
        JsonValue base = reader.parse(Gdx.files.internal("data/regions.json"));
        JsonValue region = base.child.child.get(Integer.toString(regionID));
        JsonValue rooms = region.child().get("rooms");

        roomNumber = MathUtils.random(minRooms, maxRooms);

        for (int i = 0; i <= roomNumber; i++) {
            room = null;
            randomIndex = MathUtils.random(0, 100);
            for (JsonValue jsonRoom : rooms) {
                if ((jsonRoom.child.child.getInt("from") <= randomIndex) && (jsonRoom.child.child.getInt("to") >= randomIndex)) {
                    roomid = jsonRoom.child.child.getInt("id");
                    switch (regionID) {
                        case 1:
                            switch (roomid) {
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

        Gdx.app.log(TAG,resultRoom.toString());
        reader = null;
        return resultRoom;
    }
}
