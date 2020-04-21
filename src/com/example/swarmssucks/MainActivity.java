package com.example.swarmssucks;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	GameEngine GameEngine1 = new GameEngine();
	protected static TextView mainText, scoreBoard, playNumber, average;
	private static int score = 0;
	private static int jogada = 0;
	private static double media;

	public static void setScore(int score) {
		MainActivity.score = score;
	}

	public static void setMedia(double media) {
		MainActivity.media = media;
	}

	public static int getScore() {
		return score;
	}

	public static int getJogada() {
		return jogada;
	}

	public static double getMedia() {
		return media;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mainText = (TextView) findViewById(R.id.textViewScreen);
		scoreBoard = (TextView) findViewById(R.id.textViewScore);
		playNumber = (TextView) findViewById(R.id.textViewPlayNumber);
		average = (TextView) findViewById(R.id.textViewAvg);
		GameEngine1.initialize();
		GameEngine1.buildDisplay();
	}

	public void reset(View v) {
		jogada = 0;
		score = 0;
		media = 0;
		GameEngine1.initialize();
		GameEngine1.buildDisplay();
	}

	public void moveUp(View v) {
		try {
			Coord.x--;
			jogada++;
			GameEngine1.removeAfterMove();
			GameEngine1.buildDisplay();
		} catch (Exception e) {
			Coord.x++;
			jogada--;
		}
	}

	public void moveDown(View v) {
		try {
			Coord.x++;
			jogada++;
			GameEngine1.removeAfterMove();
			GameEngine1.buildDisplay();
		} catch (Exception e) {
			Coord.x--;
			jogada--;
		}

	}

	public void moveLeft(View v) {
		try {
			Coord.y--;
			jogada++;
			GameEngine1.removeAfterMove();
			GameEngine1.buildDisplay();
		} catch (Exception e) {
			Coord.y++;
			jogada--;
		}

	}

	public void moveRight(View v) {
		try {
			Coord.y++;
			jogada++;
			GameEngine1.removeAfterMove();
			GameEngine1.buildDisplay();
		} catch (Exception e) {
			Coord.y--;
			jogada--;
		}
	}

}
