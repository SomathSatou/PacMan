import java.awt.Button;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;


public class View extends JFrame implements Observateur{
	
	
	private JFrame commande;
	private JFrame Plateaux;
	private Game controleurGame;
	private JLabel nbrTour;
	
	
	public View(Game con) {
		// initialisation pour les test
		controleurGame = con;
		controleurGame.enregistrerObservateur(this);
		
		// ************** fenetre commande **********************************
        commande = new JFrame();
        commande.setTitle("Commande Pac-man");
        commande.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        commande.setSize(new Dimension(700, 300));
        commande.setLayout(new GridLayout(2,1));
        
        // bouton de controle
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(1,4));
        
        Icon icon_restart = new ImageIcon("icon_restart.png");
        JButton choixReset = new JButton(icon_restart);
        choixReset.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent evenement){
        		controleurGame.initializeGame();
        	}
        });
        top.add(choixReset);

        Icon icon_run = new ImageIcon("icon_run.png");
        JButton choixRun = new JButton(icon_run);
        choixRun.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent evenement){
        		controleurGame.launch();
        	}
        });
        top.add(choixRun);
        
        Icon icon_step = new ImageIcon("icon_step.png");
        JButton choixStep = new JButton(icon_step);
        choixStep.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent evenement){
        		controleurGame.takeTurn();
        	}
        });
        top.add(choixStep);
        
        Icon icon_pause = new ImageIcon("icon_pause.png");
        JButton choixPause = new JButton(icon_pause);
        choixPause.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent evenement){
        		controleurGame.initializeGame();
        	}
        });
        top.add(choixPause);
        commande.add(top);
        
        // slider et nombre de tour
        JPanel bot = new JPanel();
        bot.setLayout(new GridLayout(2,2));
        
        // création slider
        int graduation[] = new int[10];
        for (int i=0;i<graduation.length;i++){
        	graduation[i] = i+1;
        }
        JSlider MySlider = new JSlider(JSlider.HORIZONTAL,graduation[0],graduation[9],graduation[4]);
        MySlider.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
        MySlider.setMajorTickSpacing(1);
		MySlider.setMinorTickSpacing(1);
		MySlider.setPaintTicks(true);
		MySlider.setPaintLabels(true);
		
		// label "nombre de tour par seconde"
		nbrTour = new JLabel("Nombre de tour : "+controleurGame.getNbrTour());
		
		// label "turn : x "
		
		
		bot.add(new JLabel("nombre de tour par seconde"));
        bot.add(nbrTour);
        bot.add(MySlider);

        commande.add(bot);
        
		WindowListener l = new WindowAdapter() {
		public void windowClosing(WindowEvent e){
			System.exit(0);
			}
		};
		 
		commande.addWindowListener(l);
        Dimension windowSize = commande.getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2 ;
        int dy = centerPoint.y - windowSize.height / 2 - 750;
        commande.setLocation(dx, dy);

        commande.setVisible(true);
        
        // ******************** fenetre affichage ******************************
        Plateaux = new JFrame();
        Plateaux.setTitle("Plateaux Pac-man");
        Plateaux.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Plateaux.setSize(new Dimension(700, 700));
        
        Plateaux.addWindowListener(l);
        Dimension windowSizep = Plateaux.getSize();
        GraphicsEnvironment gep = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPointp = gep.getCenterPoint();
        int dxp = centerPointp.x - windowSizep.width / 2 ;
        int dyp = centerPointp.y - windowSizep.height / 2 + 150;
        Plateaux.setLocation(dxp, dyp);

        Plateaux.setVisible(true);
	}


	@Override
	public void actualiser() {
		// TODO Auto-generated method stub
		nbrTour.setText("Nombre de tour : "+controleurGame.getNbrTour());
	}
}
