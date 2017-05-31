package swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
//import java.awt.event.ActionListener;
import java.sql.SQLException;

//import javafx.event.ActionEvent;



/*
 * A class to display Enseignant
 */


import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.Controller;
import ClientServeur.EnseignantController;
//modif
public class FrameEnseignantUser extends JFrame{
	private TextPanel textPanel;
	private JButton btn;
	private FormPanelEnseignant formPanel;
	private TablePanel tablePanel;
	private Toolbar toolbar;
	
	private Controller controller;
	public FrameEnseignantUser() throws SQLException{
		super("Infos Enseignant");
		
		setLayout(new BorderLayout());
		
		textPanel = new TextPanel();
		formPanel = new FormPanelEnseignant();
		tablePanel = new TablePanel();
		toolbar = new Toolbar();
		
		controller = new Controller();
		
		tablePanel.setData(controller.getProfesseurs());
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
			public void formEventOccured(FormEventEnseignat e) throws SQLException{
				controller.addEnseignant(e);
				tablePanel.setData(controller.getProfesseurs());
				tablePanel.refresh();
				
			}
		});
		
	
		//add(formPanel,BorderLayout.WEST);
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
				int action = JOptionPane.showConfirmDialog(FrameEnseignantUser.this, 
						"Désirez-vous quitter l'application?", "Confirmer", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION){
					System.exit(0);
				}
				
			}
		});
		return menuBar;
	}
}
