package de.marczim.asciiventure;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import de.marczim.asciiventure.screens.*;

public class Asciiventure extends Game {

    private final static float WIDTH = 1080.f;
    private final static  float HEIGHT = 1920.f;

	public SpriteBatch batch;
	public Viewport viewport;


	@Override
	public void create () {

		batch = new SpriteBatch();
		viewport = new FillViewport(WIDTH,HEIGHT);

		this.setScreen(new GameScreen(this));
	}

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
	public void render () {
	    super.render();
	}
	
	@Override
	public void dispose () {
	    super.dispose();
		batch.dispose();
	}

}
