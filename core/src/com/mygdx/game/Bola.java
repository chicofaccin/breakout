package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Bola extends Actor {
    private static final int RIGHT = 0;
    private static final int LEFT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;
    int norteSul = DOWN;
    int lesteOeste = LEFT;

    private int velocidade = 5;

    Bola(float x, float y, Texture texture, Breakout game) {
        super(x, y, texture, game);
    }

    @Override
    void execute() {
        if(game.fimDeJogo == true) return;
        movimentoBola();
    }

    public void movimentoBola() {
        if (norteSul == DOWN){
            sprite.translateY(-velocidade);
            if (lesteOeste == RIGHT){
                sprite.translateX(velocidade);
                if(sprite.getX() + sprite.getWidth() > game.w){
                    lesteOeste = LEFT;
                }
            }else {
                sprite.translateX(-velocidade);
                if (sprite.getX() < 0) {
                    lesteOeste = RIGHT;
                }
            }
            if (collide(game.barra)) {
                norteSul = UP;
            }
        } else if (norteSul == UP){
            sprite.translateY(velocidade);
            if (lesteOeste == RIGHT){
                sprite.translateX(velocidade);
                if(sprite.getX() + sprite.getWidth() > game.w){
                    lesteOeste = LEFT;
                }
            }else {
                sprite.translateX(-velocidade);
                if (sprite.getX() < 0) {
                    lesteOeste = RIGHT;
                }
            }
            if (sprite.getY() + sprite.getHeight() > game.h -150){
                norteSul = DOWN;
            }
        }

    }

}
