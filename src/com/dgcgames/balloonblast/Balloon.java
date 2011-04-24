package com.dgcgames.balloonblast;



public class Balloon extends DynamicGameObject{
	    public static final float BALLOON_WIDTH = 1f;
	    public static final float BALLOON_HEIGHT = 2f;
	    public static final int BALLOON_SCORE = 10;
	    public static final float BALLOON_VELOCITY_X = 2f;
	    public static final float BALLOON_VELOCITY_Y = -0.2f;
	    public static final float BALLOON_ACCELARATION_X = 1f;
	    public static final float BALLOON_ACCELARATION_Y = -1f;
	    
	    public boolean BALLOON_STATE_HIT = false;

	    float stateTime;
	    
	    public Balloon(float x, float y) {
	        super(x, y, BALLOON_WIDTH, BALLOON_HEIGHT);
	        velocity.set(BALLOON_VELOCITY_X, BALLOON_VELOCITY_Y);
	        accel.set(BALLOON_ACCELARATION_X, BALLOON_ACCELARATION_Y);
	    }
	    
	    public void update(float deltaTime) {
	        position.add( (float) (velocity.x * deltaTime + 0.5*accel.x*deltaTime*deltaTime), (float) (velocity.y * deltaTime + 0.5*accel.y*deltaTime*deltaTime) );
	        bounds.x = position.x - BALLOON_WIDTH / 2;
	        bounds.y = position.y - BALLOON_HEIGHT / 2;
	        
	        if(position.x < BALLOON_WIDTH / 2 ) {
	            position.x = BALLOON_WIDTH / 2;
	            velocity.x = BALLOON_VELOCITY_X;
	        }
	        if(position.x > World.WORLD_WIDTH - BALLOON_WIDTH / 2) {
	            position.x = World.WORLD_WIDTH - BALLOON_WIDTH / 2;
	            velocity.x = -BALLOON_VELOCITY_X;
	        }
	        stateTime += deltaTime;
	    }
}
	 