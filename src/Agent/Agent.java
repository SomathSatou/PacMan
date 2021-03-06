package Agent;

import Maze.Maze;
import Modele.PacmanGame;


public class Agent  {
	 
	private Strategie strategie;
	private PositionAgent startPos;
	private PositionAgent pos_courante;
	
	public Strategie getStrategie() {
		return strategie;
	}



	public void setStrategie(Strategie strategie) {
		this.strategie = strategie;
	}
	

   public PositionAgent getPos_courante() {
		return pos_courante;
	}



	public void setPos_courante(PositionAgent pos_courante) {
		this.pos_courante = pos_courante;
	}



	public Agent(PositionAgent pos_courante){
	   this.pos_courante=pos_courante;
	   this.startPos=pos_courante;
	   
   }
		
	public AgentAction makeAction(PacmanGame game){
		return strategie.makeAction(game,this);
	}



	public PositionAgent getStartPos() {
		return startPos;
	}



    
    
}
