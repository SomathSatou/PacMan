package Agent;

import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import Maze.Maze;

public class CommandeListener extends JFrame implements KeyListener {
	private AgentAction last = new AgentAction(Maze.STOP);
	private TextField test;

	public CommandeListener(){
		super();
		this.setSize(new Dimension(50,50));
		test=new TextField();
		addKeyListener(this);
		add(test);
		setVisible(true);

	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getExtendedKeyCode()){
			case KeyEvent.VK_DOWN:
				last = new AgentAction(Maze.SOUTH);
				break;
			case KeyEvent.VK_UP:
				last = new AgentAction(Maze.NORTH);
				break;
			case KeyEvent.VK_LEFT:
				last = new AgentAction(Maze.WEST);
				break;
			case KeyEvent.VK_RIGHT:
				last = new AgentAction(Maze.EAST);
				break;
			default:
				break;			
		}	
		test.setText(Integer.toString(arg0.getExtendedKeyCode()));
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


}
