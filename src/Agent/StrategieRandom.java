package Agent;
import java.util.ArrayList;

import Maze.Maze;
import Modele.PacmanGame;

public class StrategieRandom implements Strategie {

	@Override
	public AgentAction makeAction(PacmanGame game,Agent agent) {
		// TODO Auto-generated method stub
		ArrayList<AgentAction> tmp = new ArrayList<AgentAction>();
		
		AgentAction nord = new AgentAction(Maze.NORTH);
		if (game.getMaze().isLegalMove(agent,nord)){tmp.add(nord);}
		
		AgentAction sud = new AgentAction(Maze.SOUTH);
		if (game.getMaze().isLegalMove(agent,sud)){tmp.add(sud);}
		
		AgentAction est = new AgentAction(Maze.EAST);
		if (game.getMaze().isLegalMove(agent,est)){tmp.add(est);}
		
		AgentAction ouest = new AgentAction(Maze.WEST);
		if (game.getMaze().isLegalMove(agent,ouest)){tmp.add(ouest);}
		
		AgentAction ret;
		if (tmp.size()>0){
			int random = (int) (Math.random() * (tmp.size() - 1));
			ret = tmp.get(random);
		}
		else{
			ret = new AgentAction(Maze.STOP);
		}
		return ret;
	}



}
