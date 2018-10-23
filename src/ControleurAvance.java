import javax.swing.JFrame;


public class ControleurAvance implements ControleurGame{
	Game partie;
	View frame;

	public ControleurAvance (Game game){
		frame = new View(game,this);
		frame.getChoixReset().setEnabled(false);
		partie = game;
	}
	
	public void launch(){
		frame.getChoixPause().setEnabled(true);
		frame.getChoixRun().setEnabled(false);
		frame.getChoixReset().setEnabled(true);
		if(partie.fin_partie()){partie.launch();}
	}
	public boolean fin_partie(){		
		frame.getChoixStep().setEnabled(false);
		return partie.fin_partie();
		}
	
	public void initializeGame(){
		frame.getChoixRun().setEnabled(true);
		frame.getChoixReset().setEnabled(false);
		partie.init();
	}
	
	public void takeTurn(){
		if(partie.getNbrTour()<partie.getTourMax()){
			 partie.stop();
			 partie.takeTurn();
		}
		frame.getChoixPause().setEnabled(false);
		frame.getChoixRun().setEnabled(true);


	}
	public void gameOver(){
		partie.gameOver();
	}
	public void pause(){
		frame.getChoixRun().setEnabled(true);
		frame.getChoixPause().setEnabled(false);
		partie.stop();
	}

	@Override
	public void setTemp() {
		// TODO Auto-generated method stub
		partie.setTimeTour((long)1000/frame.getMySlider().getValue());
		
	}
}
