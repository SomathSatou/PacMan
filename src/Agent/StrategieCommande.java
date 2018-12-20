package Agent;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import Maze.Maze;
import Modele.PacmanGame;

public class StrategieCommande implements Strategie   {
	private CommandeListener listener = new CommandeListener();
	
	@Override
	public AgentAction makeAction(PacmanGame game, Agent agent) {
		listener.requestFocus();
		AgentAction ret = listener.getAction();
		return ret;
	}
}
