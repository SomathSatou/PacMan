package Modele;
import java.util.ArrayList;
import java.util.List;

import Agent.PositionAgent;
import Maze.Maze;
import View.Observateur;


public abstract class Game implements Runnable,GameObservable{
	private int nbrTour;
	private int tourMax;
	private boolean isRunning;
	Thread thread;
	long timeTour = 400;
    private List<Observateur> observateurs = new ArrayList<>();
    
	String path ;
	int ScaredTour = 0;
	int point = 0;
	
	public int getTourScared(){
		return ScaredTour;
	}
	

	public void setPath(String path) {
		this.path = path;
	}
     
    //plateaux
    
    
	// methode de déroulement du jeux
	public Game(int tour){
		tourMax = tour;
		init();
	}
	
	public void init(){
		setNbrTour(0);
		initializeGame();
		notifierObservateur();
	}
	
	public void step(){
		if(!fin_partie())
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
		//init();
		int ending = 0;
		while (ending == 0){
			
			//step();
			if ((!isRunning)||(getNbrTour() > tourMax)||(fin_partie())){ending=1;}
			if (ending==0){step();}
			try {
				thread.sleep(timeTour);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notifierObservateur();
			
		}
	}
	
	
	public void stop(){
		isRunning=false;
		
	}
	
	// getters et setters
	public int getNbrTour() {
		return nbrTour;
	}
	public void setNbrTour(int nbrTour) {
		this.nbrTour = nbrTour;
	}
	
	public int getTourMax() {
		// TODO Auto-generated method stub
		return tourMax;
	}
	// methode abstraite
	public abstract boolean fin_partie();	
	public abstract void initializeGame();
	public abstract void takeTurn();
	public abstract void gameOver();
	public abstract void setMaze(String path);
	public abstract Maze retMaze();
	
	// methode de hériter de l'observable   
	public void enregistrerObservateur(Observateur observateur){observateurs.add(observateur);}
	public void supprimerObservateur(Observateur observateur){observateurs.remove(observateur);}

	public void notifierObservateur() {
		for(int i = 0; i< observateurs.size(); i++) {
			Observateur observateur = observateurs.get(i);
			observateur.actualiser();
		}
	}

	public void setTimeTour(long l) {
		// TODO Auto-generated method stub
		timeTour = l;
	}

	public Maze getMaze(String path) {
		// TODO Auto-generated method stub
		Maze nouv = null;
		try {
			nouv = new Maze(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nouv;
	}
	
	public Maze getMaze() {
		// TODO Auto-generated method stub
		Maze nouv = null;
		try {
			nouv = new Maze("src/la youts-20180927/mediumClassic.lay");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nouv;
	}

	public ArrayList<PositionAgent> getGhosts_pos() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PositionAgent>  getPacman_pos() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
