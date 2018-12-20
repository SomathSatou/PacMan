package Agent;

import java.util.ArrayList;
import java.util.Random;

import Maze.Maze;

public class StrategieGhost implements Strategie{
	AgentAction lastAction;

	public StrategieGhost(){
		lastAction = new AgentAction(Maze.STOP);
	}

	public void setlastAction(AgentAction nouv){
		lastAction = nouv ;
	}
	
	public AgentAction getlastAction(){
		return lastAction;
	}
	@Override
	public AgentAction makeAction(Maze maze,Agent agent) {
		// TODO Auto-generated method stub
		ArrayList<AgentAction> tmp = new ArrayList<AgentAction>();
		
		AgentAction nord = new AgentAction(Maze.NORTH);
		if (maze.isLegalMove(agent,nord)){
			if(getlastAction().getDirection()!=Maze.SOUTH){
				tmp.add(nord);}
			}
		AgentAction sud = new AgentAction(Maze.SOUTH);
		if (maze.isLegalMove(agent,sud)){
			if(getlastAction().getDirection()!=Maze.NORTH){
				tmp.add(sud);}
			}
		
		AgentAction est = new AgentAction(Maze.EAST);
		if (maze.isLegalMove(agent,est)){
			if(getlastAction().getDirection()!=Maze.WEST){
				tmp.add(est);}
			}
		
		AgentAction ouest = new AgentAction(Maze.WEST);
		if (maze.isLegalMove(agent,ouest)){
			if(getlastAction().getDirection()!=Maze.EAST){
				tmp.add(ouest);}
			}
		
		if ((tmp.size()>0)||(getlastAction().getDirection()==Maze.STOP)){
			Random r = new Random();
			int randomNumber = r.ints(1, 0, tmp.size()).findFirst().getAsInt();
			setlastAction(tmp.get(randomNumber));

		}
		else{
			setlastAction(new AgentAction(Maze.STOP));
		}
		return getlastAction();
	}


}
