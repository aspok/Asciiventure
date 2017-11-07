package de.marczim.asciiventure.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Marc Zimmermann on 04.11.2017.
 */

public class TextFlow extends Actor {

    final private String TAG="TextFlow";

    private String text, flowtext;
    private BitmapFont font;
    private char aChar;
    private boolean isDone = false;
    private int maxLetters = 0, currentLetters = 0;


    public TextFlow(String Text) {
        this.text = Text;
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        flowtext = "";
        maxLetters = this.text.length();
        Gdx.app.log(TAG, "MaxLetters: " + maxLetters);

    }

    public TextFlow(String text, BitmapFont Font) {
        this.text = text;
        this.font = Font;
        font.setColor(Color.BLACK);
        flowtext = "";
        maxLetters = this.text.length();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (!isDone) {

            aChar = getFlowText(this.text, currentLetters);
            flowtext+=(Character.toString(aChar));
            currentLetters++;
            if (currentLetters > maxLetters) {
                isDone = true;
            }

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            flowtext = this.text;
        }

        font.draw(batch, flowtext, this.getX(), this.getY()+(font.getCapHeight()-4)/2+getHeight()/2);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    private char getFlowText(String Text, int pos) {
        if (Text.isEmpty()) {
            Text = "";
        }
        char charA[] = Text.toCharArray();
        if (pos >= Text.length()) {
            return '\r';
        } else {
            return charA[pos];
        }

    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
