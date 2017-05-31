package swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
//import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
/*
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import PersonnelAPP.PersonnelHelper;
import PersonnelAPP.Personnel;
//*/
public class Menu extends JFrame {

	private JPanel contentPane;
	//private static Personnel personnelImpl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/* REference in Naming
		try{
			// create and initialize the ORB
			Properties props = new Properties();
			props.put("org.omg.CORBA.ORBInitialPort", "1000");
			props.put("org.omg.CORBA.ORBInitialHost", "192.168.0.187");
			ORB orb = ORB.init(args, props);
			// get the root naming context
			org.omg.CORBA.Object objRef = 
					orb.resolve_initial_references("NameService");
			// Use NamingContextExt instead of NamingContext. This is 
			// part of the Interoperable naming Service.  
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			// resolve the Object Reference in Naming
			String name = "Personnel";
			personnelImpl = PersonnelHelper.narrow(ncRef.resolve_str(name));

			System.out.println("Obtained a handle on server object: " + personnelImpl);
			personnelImpl.AfficherEtudiants();

			//personnelImpl.shutdown();

		} catch (Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}
		//*/


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
