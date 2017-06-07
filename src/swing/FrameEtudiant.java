/*
 * UI de l'administrateur pour les operations CRUD
 */
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

public class FrameEtudiant extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextPanel textPanel;
	private FormPanelEtudiant formEtudiant;
	private TablePanelEtudiant tablePanelEtudiant;
	private Toolbar toolbar;
	private Etudiant old;

	private ControllerEtudiant controllerEtudiant;
	public FrameEtudiant(){
		super("Infos Etudiant");
		controllerEtudiant = new ControllerEtudiant();
		setLayout(new BorderLayout());

		textPanel = new TextPanel();
		tablePanelEtudiant = new TablePanelEtudiant();
		formEtudiant = new FormPanelEtudiant();
		toolbar = new Toolbar();

		tablePanelEtudiant.setEtudiantTableListener(new EtudiantTableListener(){
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
		});

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
		formEtudiant.setFormListener(new FormListenerEtudiant() {

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

			@Override
			public void formEventOccuredCancelDomain() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void formEventOccuredSearchByDomain(String domain) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void formEventOccuredSearchByNomPrenom(String nom, String prenom) {
				// TODO Auto-generated method stub
				
			}
		});


		add(formEtudiant,BorderLayout.WEST);
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

		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Formulaire Professeur");
		showFormItem.setSelected(true);

		showMenu.add(showFormItem);
		windowMenu.add(showMenu);

		menuBar.add(fileMenu);
		menuBar.add(windowMenu);

		showFormItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) ev.getSource();

				formEtudiant.setVisible(menuItem.isSelected());
			}
		});
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);

		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));

		exitItem.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				int action = JOptionPane.showConfirmDialog(FrameEtudiant.this, 
						"Désirez-vous fermer cette fenetre?", "Confirmer", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION){
					FrameEtudiant.this.controllerEtudiant.shutDown();
					FrameEtudiant.this.dispose();
				}
			}
		});
		return menuBar;
	}

}
