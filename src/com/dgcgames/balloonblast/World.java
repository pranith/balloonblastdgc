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
        public static final float WORLD_HEIGHT = 12;
        public static final int WORLD_STATE_RUNNING = 0;
        public static final int WORLD_STATE_NEXT_LEVEL = 1;
        public static final int WORLD_STATE_GAME_OVER = 2;
        
        public final Random rand;

        public int balloonsHit;
        public int balloonsMissed;
        public int score;
        public int state;
        
        public final List<Balloon> balloons;
        public final List<Arrow> arrows;
    
    public World(WorldListener listener) {
    	
    	rand = new Random();
    	balloonsHit = 0;
    	this.balloonsMissed = 0;
    	this.balloons = new ArrayList<Balloon>();
    	this.arrows = new ArrayList<Arrow>();
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
    	updateArrow(deltaTime);
    	checkCollisions();
/*        updateBob(deltaTime, accelX);
        updatePlatforms(deltaTime);
        updateSquirrels(deltaTime);
        updateCoins(deltaTime);
        if (bob.state != Bob.BOB_STATE_HIT)
            checkCollisions();*/
        checkGameOver();
    }
    
    private void checkCollisions()
    {
    	for (int i = 0; i < arrows.size(); i++)
    	{
    		Arrow arrow = arrows.get(i);
    		for (int j = 0; j < balloons.size(); j++)
    		{
    			Balloon balloon = balloons.get(j);
    			if (OverlapTester.overlapRectangles(arrow.bounds, balloon.bounds))
    			{
    				// if hit, display hit animation
    				Assets.playSound(Assets.hitSound);
    				if (balloon.points == 30)
    					balloonsMissed--;
    				balloon.BALLOON_STATE_HIT = true;
    				balloonsHit++;
    				score += balloon.points;
    			}
    		}
    		
    	}
    }
    
    public void createArrow(float x, float y)
    {
    	if (arrows.size() == 0 && y < 3f)
    	{
    		Arrow arrow = new Arrow(x, y);
    		arrows.add(arrow);
    		return;
    	}
    	for (int i = 0; i < arrows.size(); i++)
    	{
    		Arrow arrow = arrows.get(i);
    		if (arrow.ARROW_STATE_HIT == true)
    		{
    			arrow.position.set(x, y);
    			arrow.ARROW_STATE_HIT = false;
    		}
    	}
    }
    
    private void updateArrow(float deltaTime)
    {
    	for (int i = 0; i < arrows.size(); i++)
    	{
    		Arrow arrow = arrows.get(i);
    		arrow.update(deltaTime);
    	}
    }
    
    private void updateBalloon(float deltaTime) {
		for (int i = 0; i < balloons.size(); i++) {
			Balloon balloon = balloons.get(i);
			balloon.update(deltaTime);
			if (balloon.BALLOON_MISS == true)
				balloonsMissed++;
		}	
	}

	public void generateLevel() {
			Balloon balloon = new Balloon(0,10);
			balloons.add(balloon);
    }
	
    private void checkGameOver() {
        if (balloonsMissed  >= 3) {
        	assert(false);
            state = WORLD_STATE_GAME_OVER;
        }
    }
}
