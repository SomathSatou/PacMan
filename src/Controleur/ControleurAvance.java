package Controleur;

import javax.swing.JFrame;

import Maze.Maze;
import Modele.Game;
import View.View;


public class ControleurAvance implements ControleurGame{
	Game partie;
	View frame;

	public ControleurAvance (Game game){
		partie = game;
		frame = new View(game,this);
		frame.getChoixReset().setEnabled(false);
		frame.getChoixPause().setEnabled(false);

	}
	
	public void launch(){
		frame.getChoixPause().setEnabled(true);
		frame.getChoixRun().setEnabled(false);
		frame.getChoixReset().setEnabled(true);
		if(!partie.fin_partie()){
			partie.launch();
		}
	}
	public boolean fin_partie(){		
		frame.getChoixStep().setEnabled(false);
		frame.getChoixReset().setEnabled(true);
		return partie.fin_partie();
		}
	
	public void initializeGame(){
		partie.stop();

		frame.getChoixRun().setEnabled(true);
		frame.getChoixReset().setEnabled(false);
		frame.getChoixPause().setEnabled(false);
		partie.stop();
		partie.init();
	}
	
	public void takeTurn(){
		if(partie.getNbrTour()<partie.getTourMax()){
			 partie.stop();
			 partie.takeTurn();
		}
		frame.getChoixPause().setEnabled(false);
		frame.getChoixRun().setEnabled(true);


	}
	public void gameOver(){
		
		
		partie.gameOver();
	}
	public void pause(){
		frame.getChoixRun().setEnabled(true);
		frame.getChoixPause().setEnabled(false);
		partie.stop();
	}

	@Override
	public void setTemp() {
		// TODO Auto-generated method stub
		partie.setTimeTour((long)1000/frame.getMySlider().getValue());
		
	}
	
	@Override
	public Maze getMaze(){
		return partie.getMaze();
	}

	@Override
	public Maze setMaze(String path) {
		partie.setPath(path);
		partie.setMaze(path);
		return partie.getMaze();
	}


}
