package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Breakout extends ApplicationAdapter {
	SpriteBatch batch;
	Texture backgroud;
	Actor barra;
	Bola bola;
	List<Quadrado> quadrados = new ArrayList<>();
	List<Quadrado> novosQuadrados = new ArrayList<>();
	Texture textureBarra;
	Texture textureBola;
	Texture textureQuadrado;
	Texture textureWin;
	int w,h;
	private int numeroDeQuadrados = 5;
	boolean fimDeJogo = false;


	@Override
	public void create() {
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getWidth();
		batch = new SpriteBatch();
		textureBarra = new Texture("barra.png");
		textureBola = new Texture("bola.png");
		textureQuadrado = new Texture("quadrado.png");
		textureWin = new Texture("win.png");
		barra = new Barra(w / 2f - textureBarra.getWidth() / 2f, 20,textureBarra,this);
		bola = new Bola(w / 2f - textureBola.getWidth() / 2f, 50,textureBola,this);
		criaQuadrados();
	}

	private void criaQuadrados() {
		int i = 0;
		int posX = 40;
		while (i < numeroDeQuadrados){
			quadrados.add(new Quadrado(posX,textureQuadrado.getHeight() + 350,textureQuadrado,this));
			i++;
			posX = posX + 30;
		}
	}

	public void execute() {
		barra.run();
		bola.run();
		for (Quadrado quadro:quadrados) {
			quadro.run();
		}
		clean();

	}

	void clean() {
		List<Quadrado> aux = quadrados;
		quadrados = new ArrayList<>();
		for (Quadrado a : aux) if (!a.getEliminado()) quadrados.add(a);
		quadrados.addAll(novosQuadrados);
		novosQuadrados.clear();
	}

	@Override
	public void render() {
		execute();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		barra.draw();
		bola.draw();
		if (quadrados.size() == 0) {
			batch.draw(textureWin, w / 2f - textureWin.getWidth() / 2f, h / 4f);
			fimDeJogo = true;
		}
		for (Quadrado quadrado:quadrados) {
			quadrado.draw();
		}
		batch.end();
	}


	@Override
	public void dispose() {
		batch.dispose();
	}
}
