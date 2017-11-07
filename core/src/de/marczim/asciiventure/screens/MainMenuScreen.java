package de.marczim.asciiventure.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import de.marczim.asciiventure.Asciiventure;


/**
 * Created by Marc Zimmermann on 04.11.2017.
 */

public class MainMenuScreen implements Screen {

    private final Asciiventure game;
    private Stage stage;
    private Table table;

    public MainMenuScreen(final Asciiventure game) {
        this.game = game;
    }

    @Override
    public void show() {
        stage = new Stage(game.viewport);
        table = new Table();
        stage.addActor(table);

        table.setDebug(true);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height,true);
        game.viewport.update(width,height,true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
