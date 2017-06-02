/*
 * A class to display Enseignant
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

import PersonnelAPP.Enseignant;
import controller.ControllerEnseignant;

//modif
public class FrameEnseignat extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextPanel textPanel;
	private FormPanelEnseignant formPanel;
	private TablePanel tablePanel;
	private Toolbar toolbar;
	private Enseignant old;

	private ControllerEnseignant controller;
	public FrameEnseignat() throws SQLException{
		super("Infos Enseignant");
		controller = new ControllerEnseignant();
		setLayout(new BorderLayout());
		
		textPanel = new TextPanel();
		formPanel = new FormPanelEnseignant();
		tablePanel = new TablePanel();
		toolbar = new Toolbar();

		tablePanel.setData(controller.getProfesseurs());
		tablePanel.setEnseignantTableListener(new EnseignantTableListener(){
			public void rowDeleted(int row){
				controller.removeEnseignant(tablePanel.getSelectedEnseignat(row));
				tablePanel.setData(controller.getProfesseurs());
				JOptionPane.showMessageDialog(tablePanel, "Un enseignant vient d'être supprimé");
				tablePanel.refresh();
			}

			@Override
			public void rowUpdate(int row) {
				Enseignant e=tablePanel.getSelectedEnseignat(row);
				old = e;
				if (!formPanel.isUpdateON())
					formPanel.changeButtons();
				formPanel.setNom(e.p.nom);
				formPanel.setPrenom(e.p.prenom);
				formPanel.setCourriel(e.p.mail);
				formPanel.setDomaine(e.p.domain);
				formPanel.setTel(Long.toString(e.tel));
				formPanel.setPost(Long.toString(e.post));
			}
		});

		setJMenuBar(createMenuBar());
		toolbar.setStringListener(new StringListener(){
			public void textEmitted(String text){
				textPanel.appendText(text);
			}
		});
		
		/*
		 * update each time a Prof is added on db
		 */
		formPanel.setFormListener(new FormListener(){
			@Override
			public void formEventOccured(FormEventEnseignat e) throws SQLException{
				if (controller.addEnseignant(e)){
					JOptionPane.showMessageDialog(tablePanel, "Un enseignant vient d'être ajouté");
					tablePanel.setData(controller.getProfesseurs());
					tablePanel.refresh();
					formPanel.clearfileds();
				}
			}
			
			@Override
			public void formEventOccuredUpdateEnseignant(FormEventEnseignat e) {
				if(controller.updateEnseignant(e, old)){
					JOptionPane.showMessageDialog(tablePanel, "Un enseignant vient d'être modifié");
					formPanel.changeButtons();
					tablePanel.setData(controller.getProfesseurs());
					tablePanel.refresh();
					formPanel.clearfileds();
				}
			}
			
			@Override
			public void formEventOccuredCancelEnseignant() {
				formPanel.clearfileds();
				if(formPanel.isUpdateON())
					formPanel.changeButtons();
			}

			@Override
			public void formEventOccuredCancelDomain() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void formEventOccuredSearchByDomain(String string) {
				// TODO Auto-generated method stub
				
			}
			
		});

		add(formPanel,BorderLayout.WEST);
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

		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Formulaire Professeur");
		showFormItem.setSelected(true);

		showMenu.add(showFormItem);
		windowMenu.add(showMenu);

		menuBar.add(fileMenu);
		menuBar.add(windowMenu);

		showFormItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) ev.getSource();

				formPanel.setVisible(menuItem.isSelected());
			}
		});
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);

		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));

		exitItem.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {

				int action = JOptionPane.showConfirmDialog(FrameEnseignat.this, 
						"Désirez-vous fermer cette fenetre?", "Confirmer", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION){
					FrameEnseignat.this.controller.shutDown();
					FrameEnseignat.this.dispose();
				}
					
			}
		});
		return menuBar;
	}
}
