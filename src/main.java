import javax.swing.JFrame;


public class main {
	public static void main(String[] args){
		SimpleGame Partie = new SimpleGame(5);
		JFrame frame = new View(Partie);
		
		//Partie.launch();
	}
}
