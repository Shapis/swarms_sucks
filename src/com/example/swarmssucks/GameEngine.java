package com.example.swarmssucks;

import java.text.DecimalFormat;
import java.util.Random;


public class GameEngine {
	
	private StringBuilder display;
	protected int[][] tab;
	private Random rand = new Random();
	private int tamanhoX = 13;
	private int tamanhoY = 19;
	private DecimalFormat df = new DecimalFormat();
	
	public void initialize() {
		df.setMaximumFractionDigits(2);
		int[][] temp = new int[tamanhoX][tamanhoY];
		Coord.x = 6;
		Coord.y = 9;
		int i, j;
		for (i=0 ; i < tamanhoX ; i++) {
			for (j = 0  ; j < tamanhoY ; j++){
				temp[i][j] = rand.nextInt(10);
			}
			
		}
		temp[Coord.x][Coord.y] = 0;
		tab = temp;
	}
	
	public void buildDisplay() {
		int i, j;
		StringBuilder temp = new StringBuilder();
		for(i=0 ; i<tamanhoX ; i++){ 
			for(j=0 ; j <tamanhoY ; j++){ 
				if(i==Coord.x && j ==Coord.y) {
		temp.append(" X");
				}
				else {
					temp.append(" " + tab[i][j]);
				}
			}
			temp.append("\n");
		}
		display = temp;
		MainActivity.average.setText("Média: " + df.format(MainActivity.getMedia()));
		MainActivity.playNumber.setText("Jogada: " + MainActivity.getJogada());
		MainActivity.scoreBoard.setText("Score: " + MainActivity.getScore());
		MainActivity.mainText.setText(display);
	}
	
	public void removeAfterMove() {
		MainActivity.setScore(MainActivity.getScore() + tab[Coord.x][Coord.y]);
		MainActivity.setMedia((double) MainActivity.getScore() / MainActivity.getJogada());
		tab[Coord.x][Coord.y] = 0;
	}
	
	
	

}
