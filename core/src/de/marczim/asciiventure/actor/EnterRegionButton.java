package de.marczim.asciiventure.actor;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.UUID;

/**
 * Created by ITAD4-TN09 on 14.11.2017.
 */

public class EnterRegionButton extends ImageButton {

    private UUID uuid;

    public EnterRegionButton(UUID uuID, Skin skin) {
        super(skin);
        this.uuid = uuID;
    }


    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
