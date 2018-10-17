import javax.swing.JFrame;


public interface ControleurGame {
	public void launch();
	public boolean fin_partie();
	public void initializeGame();
	public void takeTurn();
	public void gameOver();
}
