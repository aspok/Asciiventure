package de.marczim.asciiventure.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;

import de.marczim.asciiventure.Asciiventure;
import de.marczim.asciiventure.actor.TextFlow;
import de.marczim.asciiventure.entity.Player;
import de.marczim.asciiventure.game.Region;
import de.marczim.asciiventure.game.World;

/**
 * Created by Marc Zimmermann on 04.11.2017.
 */

public class GameScreen implements Screen {

    private final String TAG = "GameScreen";

    private final Asciiventure game;
    private Stage stage;
    private TextFlow txtFlow;
    private Table table, tblSubmenu, tblRegionSelect;
    private BitmapFont font;
    private BitmapFont.BitmapFontData bfd;
    private int gameState = 0;
    private TextButton txtbtnNext, txtbtnInfo, txtbtnOption;
    private TextureAtlas atlas;
    private Skin skin;
    private ScrollPane scrollPane, regionPane;

    private World world;
    private Player player;
    private Container container;

    public GameScreen(final Asciiventure Game) {
        this.game = Game;
    }

    @Override
    public void show() {

        stage = new Stage(game.viewport);
        //Gdx.app.log(TAG,""+game.viewport.getWorldHeight());

        atlas = new TextureAtlas("menu/skin.atlas");
        skin = new Skin(Gdx.files.internal("menu/skin.json"), atlas);

        table = new Table(skin);
        tblSubmenu = new Table(skin);
        tblRegionSelect = new Table(skin);

        container = new Container();

        font = new BitmapFont(Gdx.files.internal("font/font_32.fnt"));
        bfd = font.getData();
        bfd.scale(1f);

        txtFlow = new TextFlow("", font);

        txtbtnNext = new TextButton("Next", skin);
        txtbtnOption = new TextButton("Options", skin);
        txtbtnInfo = new TextButton("Info", skin);

        scrollPane = new ScrollPane(tblSubmenu, skin);
        scrollPane.setFlickScroll(true);
        scrollPane.setScrollingDisabled(true, false);

        regionPane = new ScrollPane(tblRegionSelect, skin);
        regionPane.setFlickScroll(true);
        regionPane.setScrollingDisabled(true, false);

        table.setFillParent(true);
        table.defaults().width(game.viewport.getWorldWidth() - 10.0f).pad(0.0f).prefHeight(game.viewport.getWorldHeight() / 3);

        table.add();
        table.row();
        table.add(container);
        table.row();
        table.add(scrollPane).expand();
        table.row();

        tblRegionSelect.defaults().width((game.viewport.getWorldWidth() / 5) - 10f).height(35f).padTop(10f).padBottom(10f);

        tblSubmenu.defaults().pad(5f).width(((game.viewport.getWorldWidth() / 2) - 10f)).height(150f);
        tblSubmenu.add(txtbtnNext);
        tblSubmenu.add(txtbtnOption);
        tblSubmenu.row();
        tblSubmenu.add(txtbtnInfo).row();


        stage.addActor(table);

        stage.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                txtFlow.setDone(true);

                return true;
            }
        });

        stage.setDebugAll(true);
        Gdx.input.setInputProcessor(stage);

        init();


    }

    @Override
    public void render(float delta) {


        game.viewport.getCamera().update();
        game.batch.setProjectionMatrix(game.viewport.getCamera().combined);

        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        switch (gameState) {
            case 0:
                tblRegionSelect.clearChildren();
                for (Region r : world.getRegions()) {
                    tblRegionSelect.add(r.getName());
                    tblRegionSelect.add(" Rooms: ");
                    tblRegionSelect.add(Integer.toString(r.getRooms().size));
                    tblRegionSelect.add(" Level: ");
                    tblRegionSelect.add(Integer.toString(r.getBaseLevel()));
                    tblRegionSelect.row();
                }

                if (container.hasChildren()) {
                    container.clearChildren();
                }
                container.setActor(regionPane);
                gameState = 1;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:

                break;
            default:
                break;
        }

        updateStage(delta);

    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height, true);
        stage.getViewport().update(width, height, true);
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
    }

    private void init() {
        player = new Player();
        world = new World(player.getStrength());
    }

    public void updateStage(float delta) {
        stage.act(delta);
        stage.draw();
    }

}
