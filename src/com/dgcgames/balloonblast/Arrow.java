package com.dgcgames.balloonblast;



public class Arrow extends DynamicGameObject{
	    public static final float ARROW_WIDTH = 0.5f;
	    public static final float ARROW_HEIGHT = 0.8f;
	    public static final float ARROW_VELOCITY_X = 2f;
	    public static final float ARROW_VELOCITY_Y = 0f;
	    public static final float ARROW_ACCELARATION_X = 10f;
	    public static final float ARROW_ACCELARATION_Y = -10f;
	    
	    public boolean ARROW_STATE_HIT = false;

	    float stateTime;
	    
	    public Arrow(float x, float y) {
	        super(x, y, ARROW_WIDTH, ARROW_HEIGHT);
	        velocity.set(ARROW_VELOCITY_X, ARROW_VELOCITY_Y);
	        accel.set(ARROW_ACCELARATION_X, ARROW_ACCELARATION_Y);
	    }
	    
	    public void update(float deltaTime) {
	        position.add( (float) (velocity.x * deltaTime + 0.5*accel.x*java.lang.Math.pow ( deltaTime, 2) ), (float) (velocity.y * deltaTime + 0.5*accel.y*deltaTime*deltaTime) );
	        
	        stateTime += deltaTime;
	    }
}