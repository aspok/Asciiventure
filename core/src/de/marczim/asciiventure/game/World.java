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

                region.setRooms(generateRoom(jsonRegion, jsonRegion.getInt("id")));

                resultArray.add(region);
            }

        }

        return resultArray;
    }

    private Array<Room> generateRoom(JsonValue Region, int ID) {

        Array<Room> resultRoom = new Array<Room>();

        int startRooms = 10;
        int maxRooms = 75;
        int randomIndex;
        int roomNumber;

        Room room;
        JsonValue rooms = Region.getChild("rooms");
        Gdx.app.log(TAG, rooms.toString());
        //Gdx.app.log(TAG+" ID", Integer.toString(ID));

        roomNumber = MathUtils.random(startRooms, maxRooms);

        for (int i = 0; i <= roomNumber; i++) {
            randomIndex = MathUtils.random(0, 100);
            Gdx.app.log(TAG, Integer.toString(randomIndex));
            for (JsonValue jsonRoom : rooms) {
                //Gdx.app.log(TAG+" FROM",Integer.toString(jsonRoom.child.getInt("from")));
                //Gdx.app.log(TAG+" TO",Integer.toString(jsonRoom.child.getInt("to")));
                if ((jsonRoom.child.getInt("from") <= randomIndex) && (jsonRoom.child.getInt("to") >= randomIndex)) {
                    //Gdx.app.log(TAG, jsonRoom.child.getString("name"));
                    switch (ID) {

                    }
                }
            }


        }
        return resultRoom;
    }
}
