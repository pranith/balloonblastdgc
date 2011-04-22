package com.dgcgames.balloonblast;

public class Balloonblast extends Game {
	boolean firstTimeCreate = true;
	@Override
    public Screen getStartScreen() {
        return new MainMenuScreen(this);
    }
    
    @Override
    public void create() {                         
         Settings.load();
         Assets.load();
         super.create();
    } 
}
