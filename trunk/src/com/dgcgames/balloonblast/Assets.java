package com.dgcgames.balloonblast;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
    public static Texture background;
    public static Texture balloon;
    public static Texture itemsOld;  
    public static TextureRegion backgroundRegion;
    public static TextureRegion soundOn;
    public static TextureRegion soundOff;
    public static TextureRegion mainMenu;
    public static TextureRegion logo;
    public static TextureRegion gameOver;
    public static TextureRegion pause;
    public static TextureRegion ready;
    public static Animation balloonAnim;
    public static BitmapFont font;
    
    
    public static Music music;
    public static Sound hitSound;
    public static Sound missSound;			//dont have it yet
    public static Sound releaseSound;		//dont have
    public static Sound forceReleaseSound;	//dont have
    public static Sound clickSound;
    public static Sound coinSound;
    
    
    
    public static Texture loadTexture(String file) {
    	return new Texture(Gdx.files.internal(file));
    }
    
    public static void load() {
    	 background = loadTexture("data/background.png");
         backgroundRegion = new TextureRegion(background, 0, 0, 1024, 512);
         
         itemsOld = loadTexture("data/items.png");
         balloon = loadTexture("data/balloons.png");
         mainMenu = new TextureRegion(itemsOld, 0, 224, 300, 110);
         gameOver = new TextureRegion(itemsOld, 352, 256, 160, 96);
         logo = new TextureRegion(itemsOld, 0, 352, 274, 142);
         soundOff = new TextureRegion(itemsOld, 0, 0, 64, 64);
         soundOn = new TextureRegion(itemsOld, 64, 0, 64, 64);
         pause = new TextureRegion(itemsOld, 64, 64, 64, 64);
         ready = new TextureRegion(itemsOld, 320, 224, 192, 32);
         font = new BitmapFont(Gdx.files.internal("data/font.fnt"), Gdx.files.internal("data/font.png"), false);
         
         balloonAnim = new Animation(0.2f,                                 
                 new TextureRegion(balloon, 0, 0, 75, 210),
                 new TextureRegion(balloon, 77, 0, 84, 210),
                 new TextureRegion(balloon, 162, 0, 82, 210),
                 new TextureRegion(balloon, 246, 0, 79, 210));
         
         music = Gdx.audio.newMusic(Gdx.files.internal("data/music.mp3"));
         music.setLooping(true);
         music.setVolume(0.5f);         
         if(Settings.soundEnabled)
             music.play();
         releaseSound = Gdx.audio.newSound(Gdx.files.internal("data/hit.ogg"));
         hitSound = Gdx.audio.newSound(Gdx.files.internal("data/hit.ogg"));
         coinSound = Gdx.audio.newSound(Gdx.files.internal("data/coin.ogg"));
         clickSound = Gdx.audio.newSound(Gdx.files.internal("data/click.ogg"));
    }
    public static void playSound(Sound sound) {
        if(Settings.soundEnabled)
            sound.play(1);
    }
}
