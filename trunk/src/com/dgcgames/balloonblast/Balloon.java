package com.dgcgames.balloonblast;

import java.util.Random;

public class Balloon extends DynamicGameObject{
	    public static final float BALLOON_WIDTH = 0.5f;
	    public static final float BALLOON_HEIGHT = 1f;
	    public static final int BALLOON_SCORE = 10;
	    public static final float BALLOON_VELOCITY_X = 3f;
	    public static final float BALLOON_VELOCITY_Y = 0.0f;
	    public static final float BALLOON_ACCELARATION_X = 0f;
	    public static final float BALLOON_ACCELARATION_Y = 0f;
	    
	    public float POS_X, POS_Y;
	    public boolean BALLOON_STATE_HIT = false;
	    public boolean BALLOON_MISS = true;
	    public Animation currBalloonAnim;
	    float stateTime;
	    public int points, count;
	    
	    public Random rand = new Random();
	    
	    public Balloon(float x, float y) {
	        super(x, y, BALLOON_WIDTH, BALLOON_HEIGHT);
	        velocity.set(BALLOON_VELOCITY_X, BALLOON_VELOCITY_Y);
	        accel.set(BALLOON_ACCELARATION_X, BALLOON_ACCELARATION_Y);
	        POS_X = x; POS_Y = y;
	        points = 10;
	        currBalloonAnim = Assets.balloonAnimG;
	        count = 0;
	    }
	    
	    public void update(float deltaTime) {
	    	if (BALLOON_MISS == true)
	    	{
	    		reset();
	    		BALLOON_MISS = false;
	    	}
	    	if (BALLOON_STATE_HIT == true)
	    	{
	    		if (count < 0)
	    		{
	    			//currBalloonAnim = Assets.balloonBurst;
	    			velocity.x = 0;
	    			count++;
	    		}
	    		else
	    		{
	    			BALLOON_STATE_HIT = false;
	    			count = 0;
	    			reset();
	    		}
	    	}
	    	position.add(velocity.x * deltaTime, velocity.y * deltaTime);
	        bounds.x = position.x - BALLOON_WIDTH / 2;
	        bounds.y = position.y - BALLOON_HEIGHT / 2;
	        velocity.x += deltaTime * accel.x;
	        	        
	        if(position.x < BALLOON_WIDTH / 2 ) {
	            position.x = BALLOON_WIDTH / 2;
	            velocity.x = BALLOON_VELOCITY_X;
	            //accel.x = -accel.x;
	        }
	        
	        if(position.x > World.WORLD_WIDTH + BALLOON_WIDTH / 2) {
	            BALLOON_MISS = true;
	        }
	        stateTime += deltaTime;
	    }
	    
	    public void reset()
	    {				
	    	accel.x = 0;
	    	velocity.x = BALLOON_VELOCITY_X;
			switch ((int)rand.nextInt() % 6){
			//switch ((int)( 6 * rand.nextDouble() ) ){
			case 0:
				currBalloonAnim = Assets.balloonAnimR;
				points = 10;
				break;
			case 1:
				currBalloonAnim = Assets.balloonAnimR_glow;
				points = 20;
				velocity.x += 1f;
				accel.x = 1f;
				break;
			case 2:
				currBalloonAnim = Assets.balloonAnimY;
				points = 10;
				break;
			case 3:
				currBalloonAnim = Assets.balloonAnimY_glow;
				points = 20;
				velocity.x += 1.5f;
				break;
			case 4:
				currBalloonAnim = Assets.balloonAnimG;
				points = 10;
				break;
			case 5:
				currBalloonAnim = Assets.balloonAnimG_glow;
				points = 20;
				velocity.x *= 2;
				break;
			default:
				currBalloonAnim = Assets.balloonAnimG;
				points = 10;
			};
				
	    	position.set(POS_X, POS_Y);
	    
	    }
};