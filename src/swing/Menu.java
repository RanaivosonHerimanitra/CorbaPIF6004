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
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Menu Principal", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 43);
		contentPane.add(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenu mnNouveau = new JMenu("Nouveau");
		mnFichier.add(mnNouveau);
		
		JMenuItem mntmEnseignant = new JMenuItem("Enseignant");
		mnNouveau.add(mntmEnseignant);
		
		JMenuItem mntmEtudiant = new JMenuItem("Etudiant");
		mnNouveau.add(mntmEtudiant);
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

}
