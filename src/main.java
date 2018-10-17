import javax.swing.JFrame;


public class main {
	public static void main(String[] args){
		SimpleGame Partie = new SimpleGame(5);
		ControleurBasique controleur = new ControleurBasique(Partie);

		
		//Partie.launch();
	}
}
