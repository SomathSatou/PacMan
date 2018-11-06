import javax.swing.JFrame;


public class main {
	public static void main(String[] args){
//		SimpleGame Partie = new SimpleGame(5);
		PacmanGame Partie = new PacmanGame(5);

		ControleurAvance controleur = new ControleurAvance(Partie);

		
		//Partie.launch();
	}
}
