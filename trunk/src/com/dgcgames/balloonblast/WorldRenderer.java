package com.dgcgames.balloonblast;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class WorldRenderer {

	static final float FRUSTUM_WIDTH = 10;
	static final float FRUSTUM_HEIGHT = 15;
	World world;
	OrthographicCamera cam;
	SpriteBatch batch;
	TextureRegion background;

	public WorldRenderer (SpriteBatch batch, World world) {
		this.world = world;
		this.cam = new OrthographicCamera(FRUSTUM_WIDTH, FRUSTUM_HEIGHT);		
		this.cam.position.set(FRUSTUM_WIDTH / 2, FRUSTUM_HEIGHT / 2, 0);
		this.batch = batch;
	}
	
	public void renderBackground () {
		batch.disableBlending();
		batch.begin();
		batch.draw(Assets.backgroundRegion, cam.position.x - FRUSTUM_WIDTH / 2, cam.position.y - FRUSTUM_HEIGHT / 2, FRUSTUM_WIDTH, FRUSTUM_HEIGHT);
		batch.end();
	}
	
	public void renderObjects () {			
		batch.enableBlending();
		batch.begin();
		renderBalloon();
/*		renderBob();
		renderPlatforms();
		renderItems();
		renderSquirrels();
		renderCastle();*/
		batch.end();		
	}

	private void renderBalloon() {
		for (int i = 0; i < world.balloons.size(); i++) {
			Balloon balloon = world.balloons.get(i);
			TextureRegion keyFrame = Assets.balloonAnim.getKeyFrame(balloon.stateTime, Animation.ANIMATION_LOOPING);
			
			/*float side = balloon.velocity.x < 0 ? -1 : 1;
			if(side < 0 )*/
				batch.draw(keyFrame, balloon.position.x - 0.5f, balloon.position.y, 1, 1);
			/*else
				batch.draw(keyFrame, balloon.position.x - 0.5f, balloon.position.y, side * 1, 1);*/
		}
	}

	public void render() {
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		renderBackground();
		renderObjects();
	}
}
