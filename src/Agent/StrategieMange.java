package Agent;

import Maze.Maze;
import Modele.PacmanGame;

public class StrategieMange implements Strategie{
	@Override
	public AgentAction makeAction(PacmanGame game,Agent agent) {
		return new AgentAction(Maze.STOP);
	}
}
