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

import controller.ControllerEtudiant;

public class FrameEtudiant extends JFrame {
	private TextPanel textPanel;
	private FormPanelEtudiant formEtudiant;
	private TablePanelEtudiant tablePanelEtudiant;
	private Toolbar toolbar;

	private ControllerEtudiant controllerEtudiant;
	public FrameEtudiant(){
		super("Infos Etudiant");

		setLayout(new BorderLayout());

		textPanel = new TextPanel();
		tablePanelEtudiant = new TablePanelEtudiant();
		formEtudiant = new FormPanelEtudiant();
		toolbar = new Toolbar();

		controllerEtudiant = new ControllerEtudiant();
		
		//today debut
			tablePanelEtudiant.setEtudiantTableListener(new EtudiantTableListener(){
				public void rowDeleted(int row){
					controllerEtudiant.removeEtudiant(tablePanelEtudiant.getSelectedEtudiant(row));
					tablePanelEtudiant.setData(controllerEtudiant.getEtudiants());
					JOptionPane.showMessageDialog(tablePanelEtudiant, "Un étudiant vient d'être supprimé");
					tablePanelEtudiant.refresh();
				}
			});
		//today fin

		tablePanelEtudiant.setData(controllerEtudiant.getEtudiants());
		setJMenuBar(createMenuBar());
		toolbar.setStringListener(new StringListener(){
			public void textEmitted(String text){
				textPanel.appendText(text);
			}
		});
		/*
		 * update each time a Prof is added on db
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
					FrameEtudiant.this.dispose();
				}

			}
		});
		return menuBar;
	}

}
