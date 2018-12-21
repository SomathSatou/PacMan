package View;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Agent.AgentAction;
import Controleur.ControleurGame;
import Maze.Maze;
import Modele.Game;

public class CommandeListener extends JFrame implements KeyListener {
	public static AgentAction last = new AgentAction(Maze.STOP);


	public CommandeListener(){
		super();
		

	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getExtendedKeyCode()){
			case KeyEvent.VK_DOWN:
				setLast(new AgentAction(Maze.SOUTH));
				break;
			case KeyEvent.VK_UP:
				setLast(new AgentAction(Maze.NORTH));
				break;
			case KeyEvent.VK_LEFT:
				setLast(new AgentAction(Maze.WEST));
				break;
			case KeyEvent.VK_RIGHT:
				setLast(new AgentAction(Maze.EAST));
				break;
			default:
				break;			
		}	
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getExtendedKeyCode()){
			case KeyEvent.VK_KP_DOWN:
				last = new AgentAction(Maze.SOUTH);
				break;
			case KeyEvent.VK_KP_UP:
				last = new AgentAction(Maze.NORTH);
				break;
			case KeyEvent.VK_KP_LEFT:
				last = new AgentAction(Maze.WEST);
				break;
			case KeyEvent.VK_KP_RIGHT:
				last = new AgentAction(Maze.EAST);
				break;
			default:
				break;			
		}		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getExtendedKeyCode()){
			case KeyEvent.VK_KP_DOWN:
				last = new AgentAction(Maze.SOUTH);
				break;
			case KeyEvent.VK_KP_UP:
				last = new AgentAction(Maze.NORTH);
				break;
			case KeyEvent.VK_KP_LEFT:
				last = new AgentAction(Maze.WEST);
				break;
			case KeyEvent.VK_KP_RIGHT:
				last = new AgentAction(Maze.EAST);
				break;
			default:
				break;			
		}		
	}
	
	public AgentAction getAction(){
		return last;
	}
	
	public static void setLast(AgentAction agent){
		CommandeListener.last = agent;
	}

}
