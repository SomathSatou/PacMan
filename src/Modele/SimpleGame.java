package Modele;

import Maze.Maze;

public class SimpleGame extends Game {
	public SimpleGame(int tour) {
		super(tour);
		// TODO Auto-generated constructor stub
	}
	public boolean fin_partie(){
		//System.out.println("methode fin de partie" );
	
		
		return getNbrTour()<getTourMax();
	}
	

	public void initializeGame(){
		System.out.println("initialisation du jeux" );
	}
	public void takeTurn(){
		System.out.println("prise de tour "+(getNbrTour()+1) );
		setNbrTour(getNbrTour() +1);
		notifierObservateur();
		

		
	}
	public void gameOver(){
		System.out.println("Game Over" );
	
	}
	@Override
	public void setMaze(String path) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Maze retMaze() {
		// TODO Auto-generated method stub
		return null;
	}

}
