package Agent;

import Maze.Maze;

public class StrategieMange implements Strategie{
	@Override
	public AgentAction makeAction(Maze maze,Agent agent) {
		return new AgentAction(Maze.STOP);
	}
}
