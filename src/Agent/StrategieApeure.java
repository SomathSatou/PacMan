package Agent;

import java.util.ArrayList;

import Maze.Maze;
import Modele.PacmanGame;

public class StrategieApeure implements Strategie {

	@Override
	public AgentAction makeAction(PacmanGame game, Agent agent) {
		// TODO Auto-generated method stub
		ArrayList<AgentAction> tmp = new ArrayList<AgentAction>();
		
		AgentAction nord = new AgentAction(Maze.NORTH);
		if (game.getMaze().isLegalMove(agent,nord)){
			for (Pacman elt : game.getPacmans()){
				if (agent.getPos_courante().DistanceSup(nord, elt.getPos_courante()))
					tmp.add(nord);
			}
		}

		AgentAction sud = new AgentAction(Maze.SOUTH);
		if (game.getMaze().isLegalMove(agent,sud)){
			for (Pacman elt : game.getPacmans()){
				if (agent.getPos_courante().DistanceSup(sud, elt.getPos_courante()))
					tmp.add(sud);
			}
		}
		
		AgentAction est = new AgentAction(Maze.EAST);
		if (game.getMaze().isLegalMove(agent,est)){
			for (Pacman elt : game.getPacmans()){
				if (agent.getPos_courante().DistanceSup(est, elt.getPos_courante()))
					tmp.add(est);
			}
		}
		
		AgentAction ouest = new AgentAction(Maze.WEST);
		if (game.getMaze().isLegalMove(agent,ouest)){
			for (Pacman elt : game.getPacmans()){
				if (agent.getPos_courante().DistanceSup(ouest, elt.getPos_courante()))
					tmp.add(ouest);
			}
		}

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
