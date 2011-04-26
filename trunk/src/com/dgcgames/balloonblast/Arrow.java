package com.dgcgames.balloonblast;



public class Arrow extends DynamicGameObject{
	    public static final float ARROW_WIDTH = 0.2f;
	    public static final float ARROW_HEIGHT = 0.5f;
	    public static final float ARROW_VELOCITY_X = 0f;
	    public static final float ARROW_VELOCITY_Y = 5f;
	    public static final float ARROW_ACCELARATION_X = 0f;
	    public static final float ARROW_ACCELARATION_Y = 0f;
	    
	    public boolean ARROW_STATE_HIT = false;


	    float stateTime;
	    
	    public Arrow(float x, float y) {
    	    super(x, y, ARROW_WIDTH, ARROW_HEIGHT);
	        velocity.set(ARROW_VELOCITY_X, ARROW_VELOCITY_Y);
	        accel.set(ARROW_ACCELARATION_X, ARROW_ACCELARATION_Y);
	    }
	    
	    public void update(float deltaTime) {
	        position.add( 0f, velocity.y * deltaTime);
	        bounds.x = position.x + bounds.width;
	        bounds.y = position.y - bounds.height;
	        
	        if (position.y > World.WORLD_HEIGHT)
	        	ARROW_STATE_HIT = true;
	        stateTime += deltaTime;
	    }
}