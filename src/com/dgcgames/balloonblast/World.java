package com.dgcgames.balloonblast;

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
        
        public int balloonsMissed;
        public int score;
        public int state;
    
    public World(WorldListener listener) {
    	
    	this.balloonsMissed = 0;
/*        this.bob = new Bob(5, 1);
        this.platforms = new ArrayList<Platform>();
        this.springs = new ArrayList<Spring>();
        this.squirrels = new ArrayList<Squirrel>();
        this.coins = new ArrayList<Coin>();
        this.listener = listener;
        rand = new Random();
        generateLevel();

        this.heightSoFar = 0;
        this.score = 0;
        this.state = WORLD_STATE_RUNNING;*/
    }
    
    public void update(float deltaTime, float accelX) {
/*        updateBob(deltaTime, accelX);
        updatePlatforms(deltaTime);
        updateSquirrels(deltaTime);
        updateCoins(deltaTime);
        if (bob.state != Bob.BOB_STATE_HIT)
            checkCollisions();*/
        checkGameOver();
    }
    
    private void checkGameOver() {
        if (balloonsMissed >= 25) {
            state = WORLD_STATE_GAME_OVER;
        }
    }

}
