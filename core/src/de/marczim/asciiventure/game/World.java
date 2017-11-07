package de.marczim.asciiventure.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.Logger;

/**
 * Created by Marc Zimmermann on 04.11.2017.
 */

public class World {

    final private String TAG = "World";

    private Array<Region> regions;
    private int plystr;

    public World(int plyStr) {
        regions = generateRegion();
        this.plystr = plyStr;
    }

    private Array<Region> generateRegion() {
        Array<Region> resultArray = new Array<Region>();
        int startRegions = 4;
        int id;
        int toleranz = 15;
        int subRegions = 5;
        Region region;
        JsonReader reader = new JsonReader();
        JsonValue root = reader.parse(Gdx.files.internal("data/regions.json"));
        JsonValue jsonRegions = root.getChild("regions");
        JsonValue jsonRegion;

        for (int i = 0; i <= startRegions; i++) {
            id = MathUtils.random(1, 1);
            if (id != 0) {
                region = new Region();
                jsonRegion = jsonRegions.getChild(Integer.toString(id));
                region.setName(jsonRegion.getString("name"));

                region.setRooms(generateRoom(jsonRegion));

                resultArray.add(region);
            }

        }

        return resultArray;
    }

    private Array<Room> generateRoom(JsonValue Region) {

        Array<Room> resultRoom = new Array<Room>();

        int startRooms = 10;
        int maxRooms = 75;
        int roomIndex = 0;
        int randomIndex;
        int roomNumber;

        Room room;
        JsonValue rooms = Region.getChild("rooms");

        roomIndex = rooms.size;

        roomNumber = MathUtils.random(startRooms, maxRooms);

        for (int i = 1; i <= roomNumber; i++) {
            randomIndex = MathUtils.random(0, 100);



        }

        return resultRoom;
    }
}
