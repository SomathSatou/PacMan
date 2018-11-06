import java.util.ArrayList;


public class PacmanGame extends Game{
	Maze maze;
    ArrayList<Pacman> pacmans;
    ArrayList<Fantome> fantomes;
	public PacmanGame(int tour) {
		super(tour);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean fin_partie() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void initializeGame() {
		// TODO Auto-generated method stub
		pacmans= new ArrayList<Pacman>();
	   fantomes= new ArrayList<Fantome>();
	   for(int i=0 ; i<maze.getPacman_start().size();i++){
	   Pacman p= new Pacman(maze.getPacman_start().get(i));
	  	   pacmans.add(p);
	   }
	   for(int i=0; i<maze.getGhosts_start().size();i++){
		   Fantome f= new Fantome(maze.getGhosts_start().get(i));
		   fantomes.add(f);
	   }
	}

	@Override
	public void takeTurn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}

	
	

}
