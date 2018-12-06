package View;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Agent.StrategieCommande;
import Controleur.ControleurGame;
import Modele.Game;


public class View extends JFrame implements Observateur{
	
	
	private JFrame commande;
	private JFrame Plateaux;
	private JFrame frame;
	private ControleurGame controleurGame;
	private Game game;
	private JLabel nbrTour;
	PanelPacmanGame visuel;
	JButton choixRun;
	JButton choixReset;
	JButton choixStep;
	JButton choixPause;
	JSlider MySlider;
	
	
	
	public View(Game game,ControleurGame control) {
		// initialisation pour les test
		this.game = game;
		game.enregistrerObservateur(this);
		controleurGame = control;
		
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
        choixReset = new JButton(icon_restart);
        choixReset.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent evenement){
        		controleurGame.initializeGame();
        	}
        });
        top.add(choixReset);

        Icon icon_run = new ImageIcon("icon_run.png");
        choixRun = new JButton(icon_run);
        choixRun.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent evenement){
        		controleurGame.launch();
        	}
        });
        top.add(choixRun);
        
        Icon icon_step = new ImageIcon("icon_step.png");
        choixStep = new JButton(icon_step);
        choixStep.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent evenement){
        		controleurGame.takeTurn();
        	}
        });
        top.add(choixStep);
        
        Icon icon_pause = new ImageIcon("icon_pause.png");
        choixPause = new JButton(icon_pause);
        choixPause.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent evenement){
        		controleurGame.pause();
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
        MySlider = new JSlider(JSlider.HORIZONTAL,graduation[0],graduation[9],graduation[4]);
        MySlider.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
        MySlider.setMajorTickSpacing(1);
		MySlider.setMinorTickSpacing(1);
		MySlider.setPaintTicks(true);
		MySlider.setPaintLabels(true);
		MySlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent event) {
				controleurGame.setTemp();
			}
		});
		
		// label "nombre de tour par seconde"
		nbrTour = new JLabel("Nombre de tour : "+game.getNbrTour());
		
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
        visuel = new PanelPacmanGame(controleurGame.getMaze("src/layouts-20180927/mediumClassic.lay"));
        Dimension windowSizep = Plateaux.getSize();
        GraphicsEnvironment gep = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPointp = gep.getCenterPoint();
        int dxp = centerPointp.x - windowSizep.width / 2 ;
        int dyp = centerPointp.y - windowSizep.height / 2 + 150;
        Plateaux.setLocation(dxp, dyp);
        Plateaux.add(visuel);

        
        Plateaux.setVisible(true);

        // ******************** fenetre ouvrir le fichier maze ******************************
        initialize();
	}

	public JSlider getMySlider() {
		return MySlider;
	}

	// getter et setter
	public JButton getChoixRun() {
		return choixRun;
	}


	public JButton getChoixReset() {
		return choixReset;
	}



	public JButton getChoixStep() {
		return choixStep;
	}


	public JButton getChoixPause() {
		return choixPause;
	}


	@Override
	public void actualiser() {
		// TODO Auto-generated method stub
		nbrTour.setText("Nombre de tour : "+game.getNbrTour());
		visuel.setPacmans_pos(game.getPacman_pos());
		visuel.setGhosts_pos(game.getGhosts_pos());
		Plateaux.repaint();
				 
	}
	

	public class MyFileOpenerClass {
		JFileChooser file_chooser = new JFileChooser();

		
		
		
		
		public String pick_me() throws FileNotFoundException {
			String path = "";
			if (file_chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				// get the file
				File file = file_chooser.getSelectedFile();
				// read the path of file
				// System.out.println("selected file:"+file.getAbsolutePath() );
				path = file.getAbsolutePath();
				System.out.println(path);
				//ajouter la méthode reset

			}
			return path;

		}
	}

	/*
	 *
	 * public void choosePacmanLayout(Game game) {
   JButton open = new JButton();
   mazeFileChooser = new JFileChooser(new java.io.File("./src/ressources/layouts"));
   mazeFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
   Action details = mazeFileChooser.getActionMap().get("viewTypeDetails");
   details.actionPerformed(null);
   if (mazeFileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
       try {
           Maze m = new Maze(mazeFileChooser.getSelectedFile().getAbsolutePath());
           ((PacmanGame) game).setMaze(m);
           ppg = new PanelPacmanGame(((PacmanGame) game).getMaze());
           cadreVue.repaint();
       } catch (Exception ex) {
           Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
	 */
	
	
	public void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 JButton btnNewButton =new JButton("Get File");
		 btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				// TODO Auto-generated method stub
				MyFileOpenerClass of = new MyFileOpenerClass();
				try {
					visuel.m = controleurGame.getMaze(of.pick_me());;
	        		controleurGame.initializeGame();
					visuel.repaint();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		 btnNewButton.setBounds(160, 182, 121, 43);
		 frame.getContentPane().add(btnNewButton);
		 frame.setVisible(true);
		 
	
	
	}
}
