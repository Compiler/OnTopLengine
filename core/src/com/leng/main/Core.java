package com.leng.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class Core extends ApplicationAdapter {
	
	
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private ShapeRenderer render;
	
	private World world;
	
	
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		batch = new SpriteBatch();
		
		render = new ShapeRenderer();
		render.setAutoShapeType(true);
		
		world = new World(new Vector2(0, -9.81f), true);
		
	}

	@Override
	public void render () {
		camera.update();
		
		world.step(1/60f, 6, 2);

		batch.setProjectionMatrix(camera.combined);
		render.setProjectionMatrix(camera.combined);
		
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		batch.begin();
		
		batch.end();
		
		render.begin();
		
		render.end();
		
	}
	
	@Override
	public void dispose () {
		
	}
}
