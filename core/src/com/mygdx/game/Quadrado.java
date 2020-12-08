package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Quadrado extends Actor{
    private int largura = Gdx.graphics.getWidth();
    private final int posicaoYQuadrado = 100;
    private boolean eliminado = false;



    Quadrado(float x, float y, Texture texture, Breakout game) {
        super(x, y, texture, game);
    }

    @Override
    void execute() {
        if (collide(jogo.bola)) {
            setEliminado(true);
        }
    }

    public boolean getEliminado() {
        return eliminado;
    }


    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
}
