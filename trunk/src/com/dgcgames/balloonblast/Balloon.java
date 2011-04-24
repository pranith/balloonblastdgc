package com.dgcgames.balloonblast;

public class Balloon extends DynamicGameObject{
	    public static final float BALLOON_WIDTH = 1f;
	    public static final float BALLOON_HEIGHT = 2f;
	    public static final int BALLOON_SCORE = 10;
	    public static final float BALLOON_VELOCITY_X = 3f;
	    public static final float BALLOON_VELOCITY_Y = -0.0f;
	    public static final float BALLOON_ACCELARATION_X = 0f;
	    public static final float BALLOON_ACCELARATION_Y = -0f;
	    
	    public float POS_X, POS_Y;
	    public boolean BALLOON_STATE_HIT = false;
	    public boolean BALLOON_MISS = false;

	    float stateTime;
	    
	    public Balloon(float x, float y) {
	        super(x, y, BALLOON_WIDTH, BALLOON_HEIGHT);
	        velocity.set(BALLOON_VELOCITY_X, BALLOON_VELOCITY_Y);
	        accel.set(BALLOON_ACCELARATION_X, BALLOON_ACCELARATION_Y);
	        POS_X = x; POS_Y = y;
	    }
	    
	    public void update(float deltaTime) {
	    	if (BALLOON_MISS == true)
	    	{
	    		reset();
	    		BALLOON_MISS = false;
	    	}
	        bounds.x = position.x - BALLOON_WIDTH / 2;
	        bounds.y = position.y - BALLOON_HEIGHT / 2;
	        velocity.x += deltaTime * accel.x;
	        velocity.y += deltaTime * accel.y;
	        position.add(velocity.x * deltaTime, velocity.y * deltaTime);
	        if(position.x < BALLOON_WIDTH / 2 ) {
	            position.x = BALLOON_WIDTH / 2;
	            velocity.x = BALLOON_VELOCITY_X;
	            accel.x = -accel.x;
	        }
	        if(position.x > World.WORLD_WIDTH + BALLOON_WIDTH / 2) {
	            BALLOON_MISS = true;
	        }
	        stateTime += deltaTime;
	    }
	    
	    public void reset()
	    {
	    	position.set(POS_X, POS_Y);
	    }
}
	 