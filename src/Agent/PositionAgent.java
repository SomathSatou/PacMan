package Agent;

public class PositionAgent {
	
	private int x;
	private int y;
	private int dir;
	
	public PositionAgent(int x, int y, int dir) {
		this.x=x;
		this.y=y;
		this.dir=dir;
	}

	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}
	
	public Boolean equals(PositionAgent pos){
		if((this.getX()==pos.getX())&&(this.getY()==pos.getY())){return true;}
		return false;
	}
	
	public Boolean DistanceSup(AgentAction mouv, PositionAgent Point){
		//ici on verirife que le mouv éloigne bien de la position du point
		return Distance(this.getX(),this.getY(),Point.getX(),Point.getY()) < Distance(this.getX()+mouv.getVx(),this.getY()+mouv.getVy(),Point.getX(),Point.getY());
	}
	
    static public double sqr(int a) {
        return a*a;
    }
 
    static public double Distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(sqr(y2 - y1) + sqr(x2 - x1));
    } 
}