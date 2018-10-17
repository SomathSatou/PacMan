import javax.swing.JFrame;


public class ControleurBasique implements ControleurGame{
	Game partie;

	public ControleurBasique (Game game){
		JFrame frame = new View(game,this);
		partie = game;
	}
	
	public void launch(){
		partie.launch();
	}
	public boolean fin_partie(){
		return partie.fin_partie();
		}
	
	public void initializeGame(){
		partie.initializeGame();
	}
	public void takeTurn(){
		if(partie.getNbrTour()<6){partie.takeTurn();}
	}
	public void gameOver(){
		partie.gameOver();
	
	}
	public void pause(){
		partie.stop();
	}

	@Override
	public void setTemp() {
		// TODO Auto-generated method stub
		
	}
}
