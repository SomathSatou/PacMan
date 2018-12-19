import javax.swing.JFrame;

import Controleur.ControleurAvance;
import Modele.PacmanGame;


public class main {
	public static void main(String[] args){
//		SimpleGame Partie = new SimpleGame(5);
		PacmanGame Partie = new PacmanGame(250);

		ControleurAvance controleur = new ControleurAvance(Partie);

		
		//Partie.launch();
	}
}