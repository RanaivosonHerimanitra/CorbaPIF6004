package swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import PersonnelAPP.Enseignant;
import controller.ControllerEnseignant;

public class FrameRechercheEnseignant extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextPanel textPanel;
	FormPanelRechercheDomaineEnseignant formRechDom;
	FormPanelRechercheNomEnseignant formRechNom;
	private TablePanelEnseignant tablePanel;
	private Toolbar toolbar;

	private ControllerEnseignant controller;

	public FrameRechercheEnseignant() throws SQLException{
		super("Infos Enseignant");
		controller = new ControllerEnseignant();
		setLayout(new BorderLayout());

		textPanel = new TextPanel();
		formRechDom = new FormPanelRechercheDomaineEnseignant();
		formRechNom = new FormPanelRechercheNomEnseignant();
		tablePanel = new TablePanelEnseignant();
		toolbar = new Toolbar();



		tablePanel.setData(controller.getProfesseurs());
		setJMenuBar(createMenuBar());
		toolbar.setStringListener(new StringListener(){
			public void textEmitted(String text){
				textPanel.appendText(text);
			}
		});
		/*
		 * handle all events related to search by name surname
		 */
		formRechNom.setFormListener(new FormListenerEnseignant() {

			@Override
			public void formEventOccured(FormEventEnseignat e) throws SQLException {
				// TODO Auto-generated method stub

			}

			@Override
			public void formEventOccuredUpdateEnseignant(FormEventEnseignat e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void formEventOccuredCancelEnseignant() {
				// TODO Auto-generated method stub

			}

			@Override
			public void formEventOccuredCancelDomain() {
				tablePanel.setData(controller.getProfesseurs());
				tablePanel.refresh();
				formRechNom.clearfileds();

			}

			@Override
			public void formEventOccuredSearchByDomain(String string) {
				// TODO Auto-generated method stub

			}


			/*
			 * (non-Javadoc)
			 * @see swing.FormListener#formEventOccuredSearchByNomPrenom(java.lang.String, java.lang.String)
			 * action de recherche par nom prenom
			 */
			@Override
			public void formEventOccuredSearchByNomPrenom(String nom, String prenom) {
				Enseignant[] ens = new Enseignant[1];

				ens[0]= controller.getProfesseursByNomPrenom(nom, prenom);
				if(ens[0].p.nom.equals("")) {
					JOptionPane.showMessageDialog(tablePanel, "ce professeur n'existe pas");
				} else{
					tablePanel.setData(ens);
					tablePanel.refresh();
					formRechNom.clearfileds();
				}
				
				

			

		}});

		formRechDom.setFormListener(new FormListenerEnseignant() {

			@Override
			public void formEventOccuredUpdateEnseignant(FormEventEnseignat e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void formEventOccuredCancelEnseignant() {
				// TODO Auto-generated method stub

			}

			@Override
			public void formEventOccuredCancelDomain() {
				tablePanel.setData(controller.getProfesseurs());
				tablePanel.refresh();
				formRechDom.clearfileds();

			}

			@Override
			public void formEventOccured(FormEventEnseignat e) throws SQLException {
				// TODO Auto-generated method stub

			}

			@Override
			public void formEventOccuredSearchByDomain(String domain) {
				Enseignant ens[]=controller.getProfesseursByDomain(domain);
				if(ens[0].p.nom.equals(""))
					JOptionPane.showMessageDialog(tablePanel, "Ce domaine n'existe pas!");
				else{
					tablePanel.setData(ens);
					tablePanel.refresh();
					formRechDom.clearfileds();
				}

			}

			/*
			 * (non-Javadoc)
			 * @see swing.FormListener#formEventOccuredSearchByNomPrenom(java.lang.String, java.lang.String)
			 * action de recherche par nom prenom
			 */
			@Override
			public void formEventOccuredSearchByNomPrenom(String nom, String prenom) {


			}
		});

		add(formRechDom,BorderLayout.WEST);
		add(formRechNom,BorderLayout.EAST);
		add(toolbar,BorderLayout.NORTH);
		add(tablePanel,BorderLayout.CENTER);

		setMinimumSize(new Dimension(1000,400));
		setSize(600,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	//Menu Bar
	private JMenuBar createMenuBar(){
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		fileMenu.add(exitItem);

		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show");

		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Recherche par Domaine d'activité");
		showFormItem.setSelected(true);
		showMenu.add(showFormItem);
		JCheckBoxMenuItem showFormItem1 = new JCheckBoxMenuItem("Recherche par Nom & Prénom");
		showFormItem1.setSelected(true);
		showMenu.add(showFormItem1);
		windowMenu.add(showMenu);

		menuBar.add(fileMenu);
		menuBar.add(windowMenu);


		//ACTION ITEM RECHERCHE PAR DOMAINE
		showFormItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) ev.getSource();

				formRechDom.setVisible(menuItem.isSelected());

			}
		});
		//ACTION ITEM RECHERCHE PAR DOMAIN
		showFormItem1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem menuItem1 = (JCheckBoxMenuItem) e.getSource();
				formRechNom.setVisible(menuItem1.isSelected());
			}
		});
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);

		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));

		exitItem.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {

				int action = JOptionPane.showConfirmDialog(FrameRechercheEnseignant.this, 
						"Désirez-vous fermer cette fenetre?", "Confirmer", JOptionPane.OK_CANCEL_OPTION);
				System.out.println(JOptionPane.getRootFrame());
				if (action == JOptionPane.OK_OPTION)
					FrameRechercheEnseignant.this.dispose();

			}
		});
		return menuBar;
	}
}
