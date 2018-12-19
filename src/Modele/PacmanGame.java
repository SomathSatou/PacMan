package Modele;
import java.util.ArrayList;

import Agent.Agent;
import Agent.AgentAction;
import Agent.Fantome;
import Agent.Pacman;
import Agent.PositionAgent;
import Maze.Maze;
import View.PanelPacmanGame;


public class PacmanGame extends Game{
	//PanelPacmanGame ppg;
	Maze maze;
	ArrayList<Pacman> pacmans;
	ArrayList<Fantome> fantomes;

	

	@Override
	public Maze getMaze() {  
		return maze;
	}
	
	public void setMaze(String path){
		try {
			setPath(path);
			Maze nouv = new Maze(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
		
	}
	
	public Maze retMaze(){
		return maze;
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
			agent.setPos_courante(new PositionAgent(agent.getPos_courante().getX()+action.getVx(),
											   agent.getPos_courante().getY()+action.getVy(),
											   action.getDirection()));

			System.out.println("position final "+agent.getPos_courante().getX()+","+agent.getPos_courante().getY());
        }
		if(maze.isCapsule(agent.getPos_courante().getX(), agent.getPos_courante().getY())){
	          maze.setCapsule(agent.getPos_courante().getX()+ action.getVx(), agent.getPos_courante().getY()+ action.getVy(),true);
	        
			}
		//
		
		if(maze.isFood(agent.getPos_courante().getX()+ action.getVx(), agent.getPos_courante().getY()+ action.getVy())){
			maze.setFood(agent.getPos_courante().getX(), agent.getPos_courante().getY(), false);
			
			

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
