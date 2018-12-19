package Controleur;
import javax.swing.JFrame;

import Maze.Maze;


public interface ControleurGame {
	public void launch();
	public boolean fin_partie();
	public void initializeGame();
	public void takeTurn();
	public void gameOver();
	public void pause();
	public void setTemp();
	public Maze getMaze();
	public Maze setMaze(String path);
}
