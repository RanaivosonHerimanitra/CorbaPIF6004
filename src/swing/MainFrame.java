package swing;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.Controller;
import ClientServeur.EnseignantController;

public class MainFrame extends JFrame{
	private TextPanel textPanel;
	private JButton btn;
	private FormPanel formPanel;
	private TablePanel tablePanel;
	private Toolbar toolbar;
	//private EnseignantController controller;
	private Controller controller;
	public MainFrame() throws SQLException{
		super("Infos Enseignant");
		
		setLayout(new BorderLayout());
		
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		tablePanel = new TablePanel();
		toolbar = new Toolbar();
		
		controller = new Controller();
		
		//tablePanel.setData(controller.getEnseignant());
		
		toolbar.setStringListener(new StringListener(){
			public void textEmitted(String text){
				textPanel.appendText(text);
			}
		});
		
		formPanel.setFormListener(new FormListener(){
			public void formEventOccured(FormEvent e){
				controller.addEnseignant(e);
				tablePanel.refresh();
				//textPanel.appendText(nom + ": " + prenom +": " + courriel +": " + domaine +": " +phone +": " +poste +"\n");
			}
				
			
		});
		
		tablePanel.setData(controller.getProfesseur());
		add(formPanel,BorderLayout.WEST);
		add(toolbar,BorderLayout.NORTH);
		//add(textPanel,BorderLayout.CENTER);
		add(tablePanel,BorderLayout.CENTER);
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
