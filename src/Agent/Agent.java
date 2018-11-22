package Agent;

import Maze.Maze;


public class Agent  {
	 
	private Strategie strategie;
	
	public Strategie getStrategie() {
		return strategie;
	}



	public void setStrategie(Strategie strategie) {
		this.strategie = strategie;
	}

	PositionAgent pos_courante;
	 
	

   public PositionAgent getPos_courante() {
		return pos_courante;
	}



	public void setPos_courante(PositionAgent pos_courante) {
		this.pos_courante = pos_courante;
	}



	public Agent(PositionAgent pos_courante){
	   this.pos_courante=pos_courante;
	   
   }
		
	public AgentAction makeAction(Maze maze){
		return strategie.makeAction(maze,this);
	}


    
    
}
