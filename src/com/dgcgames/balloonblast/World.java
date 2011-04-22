package com.dgcgames.balloonblast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {
    public interface WorldListener {
        public void release();

        public void forceRelease();

        public void hit();

        public void coin();
    }
        public static final float WORLD_WIDTH = 10;
        public static final float WORLD_HEIGHT = 15 * 20;
        public static final int WORLD_STATE_RUNNING = 0;
        public static final int WORLD_STATE_NEXT_LEVEL = 1;
        public static final int WORLD_STATE_GAME_OVER = 2;
        
        public final Random rand;
        
        public int balloonsMissed;
        public int score;
        public int state;
        
        public final List<Balloon> balloons;
    
    public World(WorldListener listener) {
    	
    	rand = new Random();
    	this.balloonsMissed = 0;
    	this.balloons = new ArrayList<Balloon>();
        generateLevel();
/*        this.bob = new Bob(5, 1);
        this.platforms = new ArrayList<Platform>();
        this.springs = new ArrayList<Spring>();
        this.squirrels = new ArrayList<Squirrel>();
        this.coins = new ArrayList<Coin>();
        this.listener = listener;
        rand = new Random();


        this.heightSoFar = 0;
        this.score = 0;
        this.state = WORLD_STATE_RUNNING;*/
    }
    
    public void update(float deltaTime, float accelX) {
    	updateBalloon(deltaTime);
/*        updateBob(deltaTime, accelX);
        updatePlatforms(deltaTime);
        updateSquirrels(deltaTime);
        updateCoins(deltaTime);
        if (bob.state != Bob.BOB_STATE_HIT)
            checkCollisions();*/
        checkGameOver();
    }
    
    private void updateBalloon(float deltaTime) {
		for (int i = 0; i < balloons.size(); i++) {
			Balloon balloon = balloons.get(i);
			balloon.update(deltaTime);
		}
		
	}

	public void generateLevel() {
		for (int i = 0; i < 2; i++)
		{
			Balloon balloon = new Balloon(50,12 - 2 * i);
			balloons.add(balloon);
		}
    }
    private void checkGameOver() {
        if (balloonsMissed >= 25) {
            state = WORLD_STATE_GAME_OVER;
        }
    }
}
