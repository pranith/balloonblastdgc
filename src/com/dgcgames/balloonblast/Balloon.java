package com.dgcgames.balloonblast;


public class Balloon extends GameObject{
	    public static final float BALLOON_WIDTH = 0.5f;
	    public static final float BALLOON_HEIGHT = 0.8f;
	    public static final int BALLOON_SCORE = 10;

	    float stateTime;
	    public Balloon(float x, float y) {
	        super(x, y, BALLOON_WIDTH, BALLOON_HEIGHT);
	        stateTime = 0;
	    }
	    
	    public void update(float deltaTime) {
	        stateTime += deltaTime;
	    }
}