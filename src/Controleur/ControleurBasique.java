package Controleur;

import javax.swing.JFrame;

import Maze.Maze;
import Modele.Game;
import View.View;


public class ControleurBasique implements ControleurGame{
	Game partie;

	public ControleurBasique (Game game){
		JFrame frame = new View(game,this);
		partie = game;
	}
	
	public void launch(){
		partie.launch();
	}
	public boolean fin_partie(){
		return partie.fin_partie();
		}
	
	public void initializeGame(){
		partie.initializeGame();
	}
	public void takeTurn(){
		if(partie.getNbrTour()<6){partie.takeTurn();}
	}
	public void gameOver(){
		partie.gameOver();
	
	}
	public void pause(){
		partie.stop();
	}

	@Override
	public void setTemp() {
		// TODO Auto-generated method stub
		
	}
	
	public Maze getMaze(String path){
		return partie.getMaze(path);
	}

	@Override
	public Maze setMaze(String path) {
		// TODO Auto-generated method stub
		return null;
	}
}