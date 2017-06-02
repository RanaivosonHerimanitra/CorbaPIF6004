package swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
  /*
	 public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
  //*/

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
				"Menu Principal", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 43);
		contentPane.add(menuBar);

		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);

		JMenu mnNouveau = new JMenu("Nouveau");
		mnFichier.add(mnNouveau);

		
		JMenu mnRecherche = new JMenu("Rechercher");
		mnFichier.add(mnRecherche);
		
		JMenuItem parDomaine = new JMenuItem("Par Domaine d'activité");
		mnRecherche.add(parDomaine);
		
		JMenuItem parNomPrenom = new JMenuItem("Par nom & Prénom");
		mnRecherche.add(parNomPrenom);
		

		JMenuItem mnExit = new JMenuItem("Quitter");
		mnFichier.add(mnExit);

		JMenuItem mntmEnseignant = new JMenuItem("Enseignant");
		mnNouveau.add(mntmEnseignant);

		JMenuItem mntmEtudiant = new JMenuItem("Etudiant");
		mnNouveau.add(mntmEtudiant);

		
		//Action Recherche
		parDomaine.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FrameRechercheParDomaine fr;
				try {
					fr = new FrameRechercheParDomaine();
					fr.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});

		mntmEtudiant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameEtudiant fe = new FrameEtudiant();
				fe.setVisible(true);
			}
		});
		mntmEnseignant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FrameEnseignat fes = new FrameEnseignat();
					fes.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action = JOptionPane.showConfirmDialog(Menu.this, 
						"Désirez-vous quitter l'application?", "Confirmer", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION){
					System.exit(0);
				}

			}
		});
	}

}
