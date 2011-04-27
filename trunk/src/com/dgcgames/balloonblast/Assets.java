package com.dgcgames.balloonblast;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
    public static Texture background;
    public static Texture balloonR;
    public static Texture balloonR_glow;
    public static Texture balloonY;
    public static Texture balloonY_glow;
    public static Texture balloonG;
    public static Texture balloonG_glow;
    public static Texture arrowTex;
    public static Texture logoTex;
    public static Texture itemsOld;  
    public static Texture balloonBurstingTex;  
    public static TextureRegion arrow;
    public static TextureRegion backgroundRegion;
    public static TextureRegion soundOn;
    public static TextureRegion soundOff;
    public static TextureRegion mainMenu;
    public static TextureRegion pauseMenu;
    public static TextureRegion logo;
    public static TextureRegion gameOver;
    public static TextureRegion highScoresRegion;
    public static TextureRegion pause;
    public static TextureRegion ready;
    public static Animation balloonAnimR;
    public static Animation balloonAnimR_glow;
    public static Animation balloonAnimY;
    public static Animation balloonAnimY_glow;
    public static Animation balloonAnimG;
    public static Animation balloonAnimG_glow;
    public static Animation balloonBurst;
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
         
         arrowTex = loadTexture("data/arrow.png");
         logoTex  = loadTexture("data/logo.png");
         //balloonBurstingTex = loadTexture("data/balloonBlastR.png");
         balloonG = loadTexture("data/balloonsG_512x512.png");
         balloonY = loadTexture("data/balloonsY_512x512.png");
         balloonR = loadTexture("data/balloonsR_512x512.png");
         balloonG_glow = loadTexture("data/balloonsG_512x512_glow.png");
         balloonY_glow = loadTexture("data/balloonsY_512x512_glow.png");
         balloonR_glow = loadTexture("data/balloonsR_512x512_glow.png");
         
         arrow	  = new TextureRegion(arrowTex, 0, 0, 64, 281);
         mainMenu = new TextureRegion(itemsOld, 0, 224, 300, 110);
         pauseMenu = new TextureRegion(itemsOld, 224, 128, 192, 96);
         gameOver = new TextureRegion(itemsOld, 352, 256, 160, 96);
         highScoresRegion = new TextureRegion(itemsOld, 0, 259, 300, 110 / 3);
         logo = new TextureRegion(logoTex, 0, 0, 952, 280);
         //logo = new TextureRegion(itemsOld, 0, 352, 274, 142);
         soundOff = new TextureRegion(itemsOld, 0, 0, 64, 64);
         soundOn = new TextureRegion(itemsOld, 64, 0, 64, 64);
         pause = new TextureRegion(itemsOld, 64, 64, 64, 64);
         ready = new TextureRegion(itemsOld, 320, 224, 192, 32);
         //font = new BitmapFont(Gdx.files.internal("data/font.fnt"), Gdx.files.internal("data/font.png"), false);
         font = new BitmapFont();
         font.setColor(Color.BLACK);
         balloonAnimG = new Animation(0.4f,                                 
                 new TextureRegion(balloonG, 0, 0, 75, 220),
                 new TextureRegion(balloonG, 77, 0, 84, 220),
                 new TextureRegion(balloonG, 162, 0, 82, 220),
                 new TextureRegion(balloonG, 246, 0, 79, 220));
         balloonAnimG_glow = new Animation(0.4f,                                 
                 new TextureRegion(balloonG_glow, 0, 0, 75, 220),
                 new TextureRegion(balloonG_glow, 77, 0, 84, 220),
                 new TextureRegion(balloonG_glow, 162, 0, 82, 220),
                 new TextureRegion(balloonG_glow, 246, 0, 79, 220));
         balloonAnimY = new Animation(0.4f,                                 
                 new TextureRegion(balloonY, 0, 0, 75, 220),
                 new TextureRegion(balloonY, 77, 0, 84, 220),
                 new TextureRegion(balloonY, 162, 0, 82, 220),
                 new TextureRegion(balloonY, 246, 0, 79, 220));
         balloonAnimY_glow = new Animation(0.4f,                                 
                 new TextureRegion(balloonY_glow, 0, 0, 75, 220),
                 new TextureRegion(balloonY_glow, 77, 0, 84, 220),
                 new TextureRegion(balloonY_glow, 162, 0, 82, 220),
                 new TextureRegion(balloonY_glow, 246, 0, 79, 220));
         balloonAnimR = new Animation(0.4f,                                 
                 new TextureRegion(balloonR, 0, 0, 75, 220),
                 new TextureRegion(balloonR, 77, 0, 84, 220),
                 new TextureRegion(balloonR, 162, 0, 82, 220),
                 new TextureRegion(balloonR, 246, 0, 79, 220));
         balloonAnimR_glow = new Animation(0.4f,                                 
                 new TextureRegion(balloonR_glow, 0, 0, 78, 220),
                 new TextureRegion(balloonR_glow, 77, 0, 89, 220),
                 new TextureRegion(balloonR_glow, 164, 0, 80, 220),
                 new TextureRegion(balloonR_glow, 243, 0, 86, 220));
        /* balloonBurst = new Animation ( 0.2f,
        		 new TextureRegion(balloonBurstingTex, 0, 0, 97, 109),
                 new TextureRegion(balloonBurstingTex, 97, 0, 97, 102),
                 new TextureRegion(balloonBurstingTex, 197, 0, 97, 102));*/
         
         music = Gdx.audio.newMusic(Gdx.files.internal("data/music.mp3"));
         music.setLooping(true);
         music.setVolume(0.15f);         
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
