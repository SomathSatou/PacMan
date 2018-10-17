
public class SimpleGame extends Game {
	public SimpleGame(int tour) {
		super(tour);
		// TODO Auto-generated constructor stub
	}
	public boolean fin_partie(){
		System.out.println("methode fin de partie" );
		return false;}	
	public void initializeGame(){
		System.out.println("initialisation du jeux" );
	}
	public void takeTurn(){
		System.out.println("prise de tour "+getNbrTour() );
		setNbrTour(getNbrTour() + 1);
		notifierObservateur();

		
	}
	public void gameOver(){
		System.out.println("Game Over" );
	
	}

}
