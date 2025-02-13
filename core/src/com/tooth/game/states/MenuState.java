package com.tooth.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tooth.game.ToothGame;
import com.tooth.game.sprites.Tooth;

public class MenuState extends State {
    private Texture background;
    private Texture playButton;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        //cam.setToOrtho(false, ToothGame.WIDTH / 2, ToothGame.HEIGHT / 2);
        background = new Texture("bg_color.png");
        playButton = new Texture("button_play.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched())
        {
            gsm.set(new PlayState(gsm));
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        //sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0, ToothGame.WIDTH, ToothGame.HEIGHT);
        sb.draw(playButton, (ToothGame.WIDTH / 2) - (playButton.getWidth() / 2), (ToothGame.HEIGHT / 2));
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }
}
