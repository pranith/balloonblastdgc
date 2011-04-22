package com.dgcgames.balloonblast;



public class Balloon extends DynamicGameObject{
	    public static final float BALLOON_WIDTH = 0.5f;
	    public static final float BALLOON_HEIGHT = 0.8f;
	    public static final int BALLOON_SCORE = 10;
	    public static final float BALLOON_VELOCITY = 3f;
	    
	    public boolean BALLOON_STATE_HIT = false;

	    float stateTime;
	    
	    public Balloon(float x, float y) {
	        super(x, y, BALLOON_WIDTH, BALLOON_HEIGHT);
	        velocity.set(BALLOON_VELOCITY, 0);
	    }
	    
	    public void update(float deltaTime) {
	        position.add(velocity.x * deltaTime, velocity.y * deltaTime);
	        bounds.x = position.x - BALLOON_WIDTH / 2;
	        bounds.y = position.y - BALLOON_HEIGHT / 2;
	        
	        if(position.x < BALLOON_WIDTH / 2 ) {
	            position.x = BALLOON_WIDTH / 2;
	            velocity.x = BALLOON_VELOCITY;
	        }
	        if(position.x > World.WORLD_WIDTH - BALLOON_WIDTH / 2) {
	            position.x = World.WORLD_WIDTH - BALLOON_WIDTH / 2;
	            velocity.x = -BALLOON_VELOCITY;
	        }
	        stateTime += deltaTime;
	    }
}
	 