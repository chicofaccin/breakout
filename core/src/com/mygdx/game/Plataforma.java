package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class Plataforma extends Actor{
    Plataforma(float x, float y, Texture texture, Breakout game) {
        super(x, y, texture, game);
    }

    @Override
    void execute() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            sprite.translateX(-10);
        } else if (Gdx.input.isKeyPressed((Input.Keys.RIGHT))) {
            sprite.translateX(10);
        }
    }
}
