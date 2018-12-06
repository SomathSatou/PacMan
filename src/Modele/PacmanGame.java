package Modele;
import java.util.ArrayList;

import Agent.Agent;
import Agent.AgentAction;
import Agent.Fantome;
import Agent.Pacman;
import Agent.PositionAgent;
import Maze.Maze;


public class PacmanGame extends Game{
	Maze maze;
	ArrayList<Pacman> pacmans;
	ArrayList<Fantome> fantomes;

	

	@Override
	public Maze getMaze(String path) {  // remplacer le chemin par un str pour pouvoir la rappeler avec les differents labyrinthe
		// TODO Auto-generated method stub
		Maze nouv = null;
		try {
			setPath(path);
			nouv = new Maze(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nouv;
	}
	
	public void setMaze(String path){
		maze = getMaze(path);
		
	}
    
	public PacmanGame(int tour) {
		super(tour);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean fin_partie() {
		// TODO Auto-generated method stub
		if(this.getNbrTour() < this.getTourMax()){return false;}
		return true;
	}

	@Override
	public void initializeGame() {
		// TODO Auto-generated method stub
		if (path == null){path = "src/layouts-20180927/mediumClassic.lay";}
	   this.maze = getMaze(path);
	   pacmans= new ArrayList<Pacman>();
	   fantomes= new ArrayList<Fantome>();
	   for(int i=0 ; i<maze.getPacman_start().size();i++){
		   Pacman p= new Pacman(maze.getPacman_start().get(i));
	  	   pacmans.add(p);
	   }

	   for(int i=0; i<maze.getGhosts_start().size();i++){
		   Fantome f= new Fantome(maze.getGhosts_start().get(i));
		   fantomes.add(f);
		   }
	}

	@Override
	public void takeTurn() {
		for(Agent ghost : fantomes){
			moveAgent(ghost,ghost.makeAction(maze));
		}
	    for(Agent pacman : pacmans){
	    	System.out.println("lol");
			moveAgent(pacman,pacman.makeAction(maze));
		} 
	    
		this.setNbrTour(getNbrTour()+1);
		notifierObservateur();
		// TODO Auto-generated method stub
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}

	
	public void moveAgent(Agent agent,AgentAction action){
		if (maze.isLegalMove(agent,action)){
			System.out.println("position initial "+agent.getPos_courante().getX()+","+agent.getPos_courante().getY());
			agent.setPos_courante(new PositionAgent(agent.getPos_courante().getX()+action.getVx(),
											   agent.getPos_courante().getY()+action.getVy(),
											   action.getDirection()));
			System.out.println("position final "+agent.getPos_courante().getX()+","+agent.getPos_courante().getY());

		}
		notifierObservateur();
		
	}
	
	public ArrayList<PositionAgent> getGhosts_pos(){
		ArrayList<PositionAgent> ret = new ArrayList<PositionAgent>();
		for(Agent ghost: fantomes){
			ret.add(ghost.getPos_courante());
		}
		return ret;
	}
	
	public ArrayList<PositionAgent> getPacman_pos(){
		ArrayList<PositionAgent> ret = new ArrayList<PositionAgent>();
		for(Agent pokeman: pacmans){
			ret.add(pokeman.getPos_courante());
		}
		return ret;
	}
}
