package Modele;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import Agent.Agent;
import Agent.AgentAction;
import Agent.FabriqueAgent;
import Agent.Fantome;
import Agent.Pacman;
import Agent.PositionAgent;
import Agent.StrategieApeure;
import Agent.StrategieGhost;
import Agent.StrategieMange;
import Maze.Maze;
import View.PanelPacmanGame;


public class PacmanGame extends Game{
	private Maze maze;
	private ArrayList<Pacman> pacmans;
	private ArrayList<Fantome> fantomes;

	public ArrayList<Pacman> getPacmans(){
		return pacmans;
	}
	
	public ArrayList<Fantome> getFantomes(){
		return fantomes;
	}
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
		if(fin_jeu()){
			return true;
		}
		
		else if(this.getNbrTour() < this.getTourMax()){
			return false;
			}
		
		return true;
		
	}
       
	public boolean parcourir(){
		
		for(int i = 0; i<maze.getSizeX();++i){
			for( int j = 0; j<maze.getSizeY(); ++j){
				if(maze.isFood(i,j)){
					return false ;
				}
				
			}
			
			
		}
		return true;
	}
	
	public boolean fin_jeu()
	{ 
		
		if(pacmans.isEmpty()|| parcourir()){
			return true;
			}
		
	   return false;
	}


	@Override
	public void initializeGame() {
		this.ScaredTour = 0;
		// TODO Auto-generated method stub
		if (path == null){path = "src/layouts-20180927/mediumClassic.lay";}
	   this.maze = getMaze(path);
	   
	   pacmans= new ArrayList<Pacman>();
	   fantomes= new ArrayList<Fantome>();
	   FabriqueAgent maker = new FabriqueAgent();
	/*   for(int i=0 ; i<maze.getPacman_start().size();i++){
		   Pacman p= maker.createPacmanA(maze.getPacman_start().get(i));
	  	   pacmans.add(p);
	   }*/
	   for(int i=0 ; i<maze.getPacman_start().size();i++){
		   Pacman p= maker.createPacman(maze.getPacman_start().get(i));
	  	   pacmans.add(p);
	   }

	   for(int i=0; i<maze.getGhosts_start().size();i++){
		   Fantome f= maker.createGhost(maze.getGhosts_start().get(i));
		   fantomes.add(f);
		   }
	}

	@Override
	public void takeTurn() {
		if(ScaredTour>0){
			ScaredTour--;
			if(ScaredTour==0){
				for(Agent ghost : fantomes){
					ghost.setStrategie(new StrategieGhost());
				}
			}
		}
		for(Agent ghost : fantomes){
			moveAgent(ghost,ghost.makeAction(this));
		}
		if(pacmans.size()>0){
			try{
			    for(Agent pacman : pacmans){
					moveAgent(pacman,pacman.makeAction(this));
				} 
			}
			catch (ConcurrentModificationException e){
				
			}
		}
	    
		this.setNbrTour(getNbrTour()+1);
		notifierObservateur();
		// TODO Auto-generated method stub
	}
	
	@Override
	public void gameOver() {
		
		if(fin_partie()){
			
		}
		
		
		// TODO Auto-generated method stub
		
	}

	public boolean isPacman(Agent agent){
		for(PositionAgent elt : getPacman_pos()){
			if (elt == agent.getPos_courante()){
				return true;
			}
		}
		return false;
	}
	
	public boolean isFantome(Agent agent){
		for(PositionAgent elt : getGhosts_pos()){
			if (elt == agent.getPos_courante()){
				return true;
			}
		}
		return false;
	}
	
	public void moveAgent(Agent agent,AgentAction action){
		if (maze.isLegalMove(agent,action)){
			agent.setPos_courante(new PositionAgent(agent.getPos_courante().getX()+action.getVx(),
											   agent.getPos_courante().getY()+action.getVy(),
											   action.getDirection()));
        }
		if(agent instanceof Pacman){
			if(maze.isCapsule(agent.getPos_courante().getX(), agent.getPos_courante().getY())){
		          maze.setCapsule(agent.getPos_courante().getX(), agent.getPos_courante().getY(),false);
		          this.ScaredTour = 20;
		          for(Fantome elt : getFantomes()){
		        	  elt.setStrategie(new StrategieApeure());
		          }
			}
			
			if(maze.isFood(agent.getPos_courante().getX(), agent.getPos_courante().getY())){
				maze.setFood(agent.getPos_courante().getX(), agent.getPos_courante().getY(), false);
				this.point++;
			}
		}
		//ne fonction pas sans doute le if a modifier
		if(agent instanceof Pacman){
			if (ScaredTour>0){
				//supprimer le fantôme
				for(Fantome ghost : fantomes){
					if(ghost.getPos_courante().equals(agent.getPos_courante())){
						ghost.setPos_courante(ghost.getStartPos());
						ghost.setStrategie(new StrategieMange());
					}
				}
			}
			else{
				for(Fantome ghost : fantomes){
					if(ghost.getPos_courante().equals(agent.getPos_courante())){
						pacmans.remove(agent);
					}
				}
			}
		}
		else{
			//supprimer le pacman
			Pacman tmp = null;
			if (ScaredTour==0){
				for(Pacman pac : pacmans){
					if(pac.getPos_courante().equals(agent.getPos_courante())){
						tmp = pac;
					}
				}
				pacmans.remove(tmp);
			}
			else{
				for(Pacman pac : pacmans){
					if(pac.getPos_courante().equals(agent.getPos_courante())){
						agent.setPos_courante(agent.getStartPos());
						agent.setStrategie(new StrategieMange());
					}
				}
			}
		}
		//coder la rencontre entre les différent agents
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
