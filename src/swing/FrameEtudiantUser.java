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

public class FrameEtudiantUser extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextPanel textPanel;
	private FormPanelEtudiant formEtudiant;
	private TablePanelEtudiant tablePanelEtudiant;
	private Toolbar toolbar;

	private ControllerEtudiant controllerEtudiant;
	public FrameEtudiantUser(){
		super("Infos Etudiant");

		setLayout(new BorderLayout());

		textPanel = new TextPanel();
		tablePanelEtudiant = new TablePanelEtudiant();
		formEtudiant = new FormPanelEtudiant();
		toolbar = new Toolbar();

		controllerEtudiant = new ControllerEtudiant();

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
					controllerEtudiant.addEtudiant(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				tablePanelEtudiant.setData(controllerEtudiant.getEtudiants());
				tablePanelEtudiant.refresh();

			}

			@Override
			public void formEventOccuredUpdateEtudiant(FormEventEtudiant e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void formEventOccuredCancelEtudiant() {
				// TODO Auto-generated method stub

			}
		});


		add(toolbar,BorderLayout.NORTH);
		add(tablePanelEtudiant,BorderLayout.CENTER);

		setMinimumSize(new Dimension(1000,400));
		setSize(600,500);
		setLocationRelativeTo(null);

		setVisible(true);
	}
	
	//Menu Bar
	@SuppressWarnings("deprecation")
	private JMenuBar createMenuBar(){
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		fileMenu.add(exitItem);

		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show");
		windowMenu.enable(false);
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
				int action = JOptionPane.showConfirmDialog(FrameEtudiantUser.this, 
						"Désirez-vous fermer cette fenetre?", "Confirmer", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION){
					FrameEtudiantUser.this.controllerEtudiant.shutDown();
					FrameEtudiantUser.this.dispose();
				}

			}
		});
		return menuBar;
	}

}
