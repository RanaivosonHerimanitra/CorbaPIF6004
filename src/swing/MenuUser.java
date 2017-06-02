package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUser frame = new MenuUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public MenuUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenu mnSelecionner = new JMenu("Selecionner");
		mnFichier.add(mnSelecionner);
		
		JMenu mnRechercher = new JMenu("Rechercher");
		mnFichier.add(mnRechercher);
		
		JMenuItem iexit = new JMenuItem("Quitter");
		mnFichier.add(iexit);
		JMenuItem mntmEnseignant = new JMenuItem("Afficher Enseignant");
		mntmEnseignant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FrameEnseignantUser feu = new FrameEnseignantUser();
					feu.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnSelecionner.add(mntmEnseignant);
		
		JMenuItem mntmEtudiant = new JMenuItem("Afficher Etudiant");
		mntmEtudiant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameEtudiantUser fet = new FrameEtudiantUser();
				fet.setVisible(true);
			}
		});
		mnSelecionner.add(mntmEtudiant);
		
		iexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action = JOptionPane.showConfirmDialog(MenuUser.this, 
						"Désirez-vous quitter l'application?", "Confirmer", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
	}

}
