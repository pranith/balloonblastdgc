package com.dgcgames.balloonblast;

import com.badlogic.gdx.backends.jogl.JoglApplication;

public class BalloonblastDesktop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new JoglApplication(new Balloonblast(), "My Game", 1024, 768, false);

	}

}
