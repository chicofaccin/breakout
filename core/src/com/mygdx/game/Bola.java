package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Bola extends Actor {
    private static final int DIREITA = 0;
    private static final int ESQUERDA = 1;
    private static final int CIMA = 2;
    private static final int BAIXO = 3;
    int norteSul = BAIXO;
    int lesteOeste = ESQUERDA;

    private int velocidade = 5;

    Bola(float x, float y, Texture texture, Breakout game) {
        super(x, y, texture, game);
    }

    @Override
    void execute() {
        if(jogo.fimDeJogo == true) return;
        movimentoBola();
    }

    public void movimentoBola() {
        if (norteSul == BAIXO){
            if (sprite.getY() + sprite.getHeight() < 0){
                jogo.gameOver = true;
            }
            sprite.translateY(-velocidade);
            if (lesteOeste == DIREITA){
                sprite.translateX(velocidade);
                if(sprite.getX() + sprite.getWidth() > jogo.w){
                    lesteOeste = ESQUERDA;
                }
            }else {
                sprite.translateX(-velocidade);
                if (sprite.getX() < 0) {
                    lesteOeste = DIREITA;
                }
            }
            if (collide(jogo.barra)) {
                norteSul = CIMA;
            }
        } else if (norteSul == CIMA){
            sprite.translateY(velocidade);
            if (lesteOeste == DIREITA){
                sprite.translateX(velocidade);
                if(sprite.getX() + sprite.getWidth() > jogo.w){
                    lesteOeste = ESQUERDA;
                }
            }else {
                sprite.translateX(-velocidade);
                if (sprite.getX() < 0) {
                    lesteOeste = DIREITA;
                }
            }
            if (sprite.getY() + sprite.getHeight() > jogo.h -150){
                norteSul = BAIXO;
            }
        }

    }

}
