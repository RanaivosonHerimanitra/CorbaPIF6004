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



//modif
public class FrameEnseignat extends JFrame{
	private TextPanel textPanel;
	private FormPanelEnseignant formPanel;
	private TablePanel tablePanel;
	private Toolbar toolbar;

	private ControllerEnseignant controller;
	public FrameEnseignat() throws SQLException{
		super("Infos Enseignant");

		setLayout(new BorderLayout());

		textPanel = new TextPanel();
		formPanel = new FormPanelEnseignant();
		tablePanel = new TablePanel();
		toolbar = new Toolbar();

		controller = new ControllerEnseignant();

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
				if (controller.addEnseignant(e)){
					JOptionPane.showMessageDialog(tablePanel, "Un enseignant vient d'être ajouté");
					tablePanel.setData(controller.getProfesseurs());
					tablePanel.refresh();
					formPanel.clearfileds();
				}
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
				System.out.println(JOptionPane.getRootFrame());
				if (action == JOptionPane.OK_OPTION)
					FrameEnseignat.this.dispose();
			}
		});
		return menuBar;
	}
}
