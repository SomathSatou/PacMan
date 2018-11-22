package Agent;
import Maze.Maze;

public interface Strategie {
	public AgentAction makeAction(Maze maze,Agent agent);
}
