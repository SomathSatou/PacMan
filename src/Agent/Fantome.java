package Agent;

public class Fantome extends Agent{

	public Fantome(PositionAgent pos_courante) {
		super(pos_courante);
		Strategie strat = new StrategieRandom();
		this.setStrategie(strat);
		// TODO Auto-generated constructor stub
	}

}
