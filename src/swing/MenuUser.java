package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class MenuUser extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public MenuUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		JMenuItem mntmEnseignant = new JMenuItem("Afficher Enseignant");
		mntmEnseignant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FrameEnseignantUser feu = new FrameEnseignantUser();
					feu.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
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
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUser frame = new MenuUser();
				frame.setVisible(false);
			}
		});
		mnSelecionner.add(mntmQuitter);
	}

}
