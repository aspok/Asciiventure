package de.marczim.asciiventure.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.Logger;

import de.marczim.asciiventure.game.eventrooms.MonsterRoom;

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
        //Erstelle neue Region
        Region region;

        JsonReader reader = new JsonReader();
        //Lese aus Region.json
        JsonValue root = reader.parse(Gdx.files.internal("data/regions.json"));
        //Child Regions
        JsonValue jsonRegions = root.getChild("regions");
        JsonValue jsonRegion;

        for (int i = 0; i <= startRegions; i++) {
            //Zufalls Generierte ID
            id = MathUtils.random(1, 1);
            if (id != 0) {

                jsonRegion = jsonRegions.getChild(Integer.toString(id));


                region = new Region(jsonRegion.getString("name"), jsonRegion.getInt("id"), 1);


                resultArray.add(region);
            }

        }

        reader = null;
        return resultArray;
    }

    public Array<Region> getRegions() {
        return regions;
    }

    public void setRegions(Array<Region> regions) {
        this.regions = regions;
    }
}
