package com.dgcgames.balloonblast;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
    public static Texture background;
    public static TextureRegion backgroundRegion;
    public static Animation balloons;
    public static TextureRegion soundOn;
    public static TextureRegion soundOff;
    public static TextureRegion mainMenu;
    public static TextureRegion logo;
    public static TextureRegion gameOver;
    public static TextureRegion pause;
    public static BitmapFont font;
    
    public static Music music;
    public static Sound hitSound;
    public static Sound missSound;
    public static Sound releaseSound;
    public static Sound forceReleaseSound;
    public static Sound clickSound;
    public static Sound coinSound;
    
    public static Texture items;  
    
    public static void load() {
    
    }
    public static void playSound(Sound sound) {
        if(Settings.soundEnabled)
            sound.play(1);
    }
}
