package com.dgcgames.balloonblast;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

public abstract class Game implements ApplicationListener {
	Screen screen;
	
	public void setScreen (Screen helpScreen2) {
		screen.pause();
		screen.dispose();
		screen = helpScreen2;
	}
	
	public abstract Screen getStartScreen();
	
    @Override
    public void create() {
            // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
            // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
            // TODO Auto-generated method stub

    }

    @Override
    public void render() {
		screen.update(Gdx.graphics.getDeltaTime());
		screen.present(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void resize(int width, int height) {
            // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
            // TODO Auto-generated method stub

    }
    
}
