package Agent;

public class FabriqueAgent {
	public Pacman createPacman(PositionAgent pos_courante){
		Pacman n_pacman = new Pacman(pos_courante);
		Strategie strat = new StrategieCommande();
		n_pacman.setStrategie(strat);
		return n_pacman;
	}
	
	public Fantome createGhost(PositionAgent pos_courante){
		Fantome n_ghost = new Fantome(pos_courante);
		Strategie strat = new StrategieGhost();
		n_ghost.setStrategie(strat);
		return n_ghost;
	}
	
	public Pacman createPacmanA(PositionAgent pos_courante){
		Pacman n_pacman = new Pacman(pos_courante);
		Strategie strat = new StrategiePacmanA();
		n_pacman.setStrategie(strat);
		return n_pacman;
	}
	
}
