import java.util.ArrayList;
import java.util.List;


public abstract class Game implements Runnable,GameObservable{
	private int nbrTour;
	private int tourMax;
	private boolean isRunning;
	Thread thread;
	long timeTour = 400;
    private List<Observateur> observateurs = new ArrayList<>();

	// methode de déroulement du jeux
	public Game(int tour){
		tourMax = 5;
	}
	
	public void init(){
		setNbrTour(0);
		initializeGame();
		notifierObservateur();
	}
	
	public void step(){
		if(fin_partie())
			{takeTurn();}
		else
			{gameOver();}
		notifierObservateur();
	}
	
    public void launch(){ 
        thread = new Thread(this);    
        thread.start();
        isRunning = true;
    }

	public void run(){
		init();
		int ending = 0;
		while (ending == 0){
			step();
			setNbrTour(getNbrTour() + 1);
			if ((!isRunning)||(getNbrTour() > tourMax)||(fin_partie())){ending=1;}
			try {
				thread.sleep(timeTour);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			notifierObservateur();
			}
		}
	}
	
	
	public void stop(){
		// a coder
	}
	
	// getters et setters
	public int getNbrTour() {
		return nbrTour;
	}
	public void setNbrTour(int nbrTour) {
		this.nbrTour = nbrTour;
	}
	
	// methode abstraite
	public abstract boolean fin_partie();	
	public abstract void initializeGame();
	public abstract void takeTurn();
	public abstract void gameOver();
	
	// methode de hériter de l'observable   
	public void enregistrerObservateur(Observateur observateur){observateurs.add(observateur);}
	public void supprimerObservateur(Observateur observateur){observateurs.remove(observateur);}

	public void notifierObservateur() {
		for(int i = 0; i< observateurs.size(); i++) {
			Observateur observateur = observateurs.get(i);
			observateur.actualiser();
		}
	}


	
}
