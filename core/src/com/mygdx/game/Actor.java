package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Intersector;

public class Actor {
    Breakout jogo;
    Sprite sprite;

    Actor(float x, float y, Texture texture, Breakout jogo) {
        this.jogo = jogo;
        this.sprite = new Sprite(texture);
        this.sprite.setPosition(x, y);
    }

    void execute() {

    }

    void run() {
        execute();
        sprite.setX(clamp(sprite.getX(), 0, jogo.w - sprite.getWidth()));
    }

    public void draw() {
        sprite.draw(jogo.batch);
    }

    static float clamp(float value, float min, float max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }



    boolean collide(Actor other) {
        if (this == other) return false;
        return Intersector.overlaps(
                sprite.getBoundingRectangle(),
                other.sprite.getBoundingRectangle());
    }
}
