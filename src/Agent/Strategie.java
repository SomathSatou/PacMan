package Agent;
import Maze.Maze;
import Modele.PacmanGame;

public interface Strategie {
	public AgentAction makeAction(PacmanGame game,Agent agent);
}
