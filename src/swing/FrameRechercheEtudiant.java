package swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import PersonnelAPP.Etudiant;
import controller.ControllerEtudiant;

public class FrameRechercheEtudiant extends JFrame {
	private static final long serialVersionUID = 1L;
	private TextPanel textPanel;
	private FormPanelRechercheDomaineEtudiant formRechEtud;
	FormPanelRechercheNomsEtudiant formRechNom;
	private TablePanelEtudiant tablePanelEtudiant;
	private Toolbar toolbar;
	private ControllerEtudiant controllerEtudiant;
	
	public FrameRechercheEtudiant(){
		super("Infos Etudiant");
		controllerEtudiant = new ControllerEtudiant();
		setLayout(new BorderLayout());

		textPanel = new TextPanel();
		tablePanelEtudiant = new TablePanelEtudiant();
		new FormPanelEtudiant();
		formRechEtud = new FormPanelRechercheDomaineEtudiant();
		formRechNom = new FormPanelRechercheNomsEtudiant();
		toolbar = new Toolbar();
		
		formRechNom.setFormListener(new FormListenerEtudiant() {
			
			@Override
			public void formEventOccuredUpdateEtudiant(FormEventEtudiant ev) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void formEventOccuredSearchByDomain(String domain) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void formEventOccuredCancelEtudiant() {
				tablePanelEtudiant.setData(controllerEtudiant.getEtudiants());
				tablePanelEtudiant.refresh();
				formRechNom.clearfileds();
				
			}
			
			@Override
			public void formEventOccuredCancelDomain() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void formEventOccuredAddEtudiant(FormEventEtudiant e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void formEventOccuredSearchByNomPrenom(String nom, String prenom) {
				Etudiant[] ets = new Etudiant[1];
				ets[0]= controllerEtudiant.getStudentsByNomPrenom(nom, prenom);
				if(ets[0].p.nom.equals(""))
					JOptionPane.showMessageDialog(tablePanelEtudiant, "Cet étudiant n'existe pas!");
				else{
					tablePanelEtudiant.setData(ets);
					tablePanelEtudiant.refresh();
					formRechNom.clearfileds();
				}
			}
		});

		formRechEtud.setFormListener(new FormListenerEtudiant() {
			
			@Override
			public void formEventOccuredUpdateEtudiant(FormEventEtudiant ev) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void formEventOccuredCancelEtudiant() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void formEventOccuredAddEtudiant(FormEventEtudiant e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void formEventOccuredCancelDomain() {
				tablePanelEtudiant.setData(controllerEtudiant.getEtudiants());
				tablePanelEtudiant.refresh();
				formRechEtud.clearfileds();
				
			}
			
			@Override
			public void formEventOccuredSearchByDomain(String domain) {
				Etudiant ets[]=controllerEtudiant.getStudentsByDomain(domain);
				if(ets[0].p.nom.equals(""))
					JOptionPane.showMessageDialog(tablePanelEtudiant, "Ce domaine n'existe pas!");
				else{
					tablePanelEtudiant.setData(ets);
					tablePanelEtudiant.refresh();
					formRechEtud.clearfileds();
				}
			}

			@Override
			public void formEventOccuredSearchByNomPrenom(String nom, String prenom) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		tablePanelEtudiant.setData(controllerEtudiant.getEtudiants());
		setJMenuBar(createMenuBar());
		toolbar.setStringListener(new StringListener(){
			public void textEmitted(String text){
				textPanel.appendText(text);
			}
		});

		add(formRechEtud,BorderLayout.WEST);
		add(formRechNom,BorderLayout.EAST);
		add(toolbar,BorderLayout.NORTH);

		add(tablePanelEtudiant,BorderLayout.CENTER);

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

		showFormItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) ev.getSource();

				formRechEtud.setVisible(menuItem.isSelected());
			}
		});
		//ACTION ITEM RECHERCHE PAR NOM
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
				int action = JOptionPane.showConfirmDialog(FrameRechercheEtudiant.this, 
						"Désirez-vous fermer cette fenetre?", "Confirmer", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION)
					FrameRechercheEtudiant.this.dispose();
			}
		});
		return menuBar;
	}

}
