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

import PersonnelAPP.Etudiant;
import controller.ControllerEtudiant;

public class FrameRechercheEtudiant extends JFrame {
	private static final long serialVersionUID = 1L;
	private TextPanel textPanel;
	private FormPanelEtudiant formEtudiant;
	private FormPanelRechercheDomaineEtudiant formRechEtud;
	FormPanelRechercheNomsEtudiant formRechNom;
	private TablePanelEtudiant tablePanelEtudiant;
	private Toolbar toolbar;
	private Etudiant old;

	private ControllerEtudiant controllerEtudiant;
	public FrameRechercheEtudiant(){
		super("Infos Etudiant");
		controllerEtudiant = new ControllerEtudiant();
		setLayout(new BorderLayout());

		textPanel = new TextPanel();
		tablePanelEtudiant = new TablePanelEtudiant();
		formEtudiant = new FormPanelEtudiant();
		formRechEtud = new FormPanelRechercheDomaineEtudiant();
		formRechNom = new FormPanelRechercheNomsEtudiant();
		toolbar = new Toolbar();

		/*tablePanelEtudiant.setEtudiantTableListener(new EtudiantTableListener(){
			public void rowDeleted(int row){
				controllerEtudiant.removeEtudiant(tablePanelEtudiant.getSelectedEtudiant(row));
				tablePanelEtudiant.setData(controllerEtudiant.getEtudiants());
				JOptionPane.showMessageDialog(tablePanelEtudiant, "Un étudiant vient d'être supprimé");
				tablePanelEtudiant.refresh();
			}

			@Override
			public void rowUpdate(int row) {
				Etudiant e=tablePanelEtudiant.getSelectedEtudiant(row);
				old = e;
				if (!formEtudiant.isUpdateON())
					formEtudiant.changeButtons();
				formEtudiant.setNom(e.p.nom);
				formEtudiant.setPrenom(e.p.prenom);
				formEtudiant.setCourriel(e.p.mail);
				formEtudiant.setDomaine(e.p.domain);
				formEtudiant.setMatricul(e.matricul);

			}
		});*/
		
		tablePanelEtudiant.setData(controllerEtudiant.getEtudiants());
		setJMenuBar(createMenuBar());
		toolbar.setStringListener(new StringListener(){
			public void textEmitted(String text){
				textPanel.appendText(text);
			}
		});
		/*
		 * update each time a student is added on db
		 */
		/*formEtudiant.setFormListener(new FormListenerEtudiant() {

			@Override
			public void formEventOccuredAddEtudiant(FormEventEtudiant e) {
				try {
					if(controllerEtudiant.addEtudiant(e)){
						JOptionPane.showMessageDialog(tablePanelEtudiant, "Un etudiant vient d'être ajouté");
						tablePanelEtudiant.setData(controllerEtudiant.getEtudiants());
						tablePanelEtudiant.refresh();
						formEtudiant.clearfileds();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void formEventOccuredUpdateEtudiant(FormEventEtudiant e) {
				if(controllerEtudiant.updateEtudiant(e, old)){
					JOptionPane.showMessageDialog(tablePanelEtudiant, "Un etudiant vient d'être modifié");
					formEtudiant.changeButtons();
					tablePanelEtudiant.setData(controllerEtudiant.getEtudiants());
					tablePanelEtudiant.refresh();
					formEtudiant.clearfileds();
				}
			}

			@Override
			public void formEventOccuredCancelEtudiant() {
				formEtudiant.clearfileds();
				if(formEtudiant.isUpdateON())
					formEtudiant.changeButtons();
			}
		});*/


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
		JCheckBoxMenuItem showFormItem1 = new JCheckBoxMenuItem("Recherche par Nom & Prénom");
		showMenu.add(showFormItem);
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
				if (action == JOptionPane.OK_OPTION){
					FrameRechercheEtudiant.this.controllerEtudiant.shutDown();
					FrameRechercheEtudiant.this.dispose();
				}
			}
		});
		return menuBar;
	}

}
