package Agent;

public class Pacman extends Agent{

	public Pacman(PositionAgent pos_courante) {
		super(pos_courante);
		Strategie strat = new StrategieCommande();
		this.setStrategie(strat);
		// TODO Auto-generated constructor stub
	}

}
