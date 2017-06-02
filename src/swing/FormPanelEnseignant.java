/*
 * a  class for data entry of Enseignant
 */
package swing;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanelEnseignant extends JPanel{
	//JLabel
	private JLabel nomLabel;
	private JLabel prenomLabel;
	private JLabel courrielLabel;
	private JLabel domaineLabel;
	private JLabel phoneLabel;
	private JLabel posteLabel;
	//JTextField
	private JTextField nomField;
	private JTextField prenomField;
	private JTextField courrielField;
	private JTextField domaineField;
	private JTextField phoneField;
	private JTextField posteField;
	//JButton
	private JButton insertBtn;
	private JButton updateBtn;
	private JButton cancelBtn;
	private FormListener formListener;

	public FormPanelEnseignant(){
		Dimension dim = getPreferredSize();
		dim.width=250;
		setPreferredSize(dim);

		nomLabel = new JLabel("Nom: ");
		prenomLabel = new JLabel("Prenom: ");
		courrielLabel = new JLabel("Courriel: ");
		domaineLabel = new JLabel("Domaine d'activité: ");
		phoneLabel = new JLabel("Téléphone: ");
		posteLabel = new JLabel("Numéro de poste: ");

		nomField = new JTextField(10);
		prenomField = new JTextField(10);
		courrielField = new JTextField(10);
		domaineField = new JTextField(10);
		phoneField = new JTextField(10);
		posteField = new JTextField(10);

		insertBtn = new JButton("Insérer");
		updateBtn = new JButton("Modifier");
		cancelBtn = new JButton("Annuler");
		updateBtn.setEnabled(false);
		updateBtn.setVisible(false);
		//searchBtn = new JButton("Rechercheer");
		//displayBtn = new JButton("Afficher");

		insertBtn.setMnemonic(KeyEvent.VK_0);
		nomLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		nomLabel.setLabelFor(nomField);

		insertBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String nom= nomField.getText();
				String prenom = prenomField.getText();
				String courriel = courrielField.getText();
				String domaine = domaineField.getText();
				System.out.println(phoneField.getText());
				/*
				 * handle phone and post conversion seamlessly
				 */
				long phone=0;
				long poste=0;
				try {
					phone = Long.parseLong(phoneField.getText());
					poste = Long.parseLong(posteField.getText());
				} catch (Exception e1 ) {
					e1.printStackTrace();
				}
				
				FormEventEnseignat ev = new FormEventEnseignat(this,nom,prenom,courriel,domaine,phone,poste);
				if(formListener !=null)
				{
					try 
					{
						//input checking validation :
						if (InputValidationErrorDialog.isEmailValid(courriel) & 
								InputValidationErrorDialog.isPhoneNumberValid(String.valueOf(phone)) & 
									InputValidationErrorDialog.isPostValid(String.valueOf(poste)))
										formListener.formEventOccured(ev);

					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				}
			}

		});

		Border innerBorder = BorderFactory.createTitledBorder("Enseignant");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		layoutComponents();

	}

	public void layoutComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		//positionnement premiere ligne
		gc.weightx =1;
		gc.weighty = 0.1;

		gc.gridx =0;
		gc.gridy =0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(nomLabel,gc);

		gc.gridx =1;
		gc.gridy =0;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(nomField,gc);

		//positionnement deuxieme ligne
		gc.weightx =1;
		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(prenomLabel,gc);

		gc.gridx =1;
		gc.gridy =1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(prenomField,gc);
		//troisieme ligne

		gc.weightx =1;
		gc.weighty =0.1;
		gc.gridx = 0;
		gc.gridy = 2;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(courrielLabel,gc);

		gc.gridx =1;
		gc.gridy =2;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(courrielField,gc);

		//quatrieme ligne
		gc.weightx =1;
		gc.weighty =0.1;
		gc.gridx = 0;
		gc.gridy = 3;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(domaineLabel,gc);

		gc.gridx =1;
		gc.gridy =3;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(domaineField,gc);
		//cinquieme ligne
		gc.weightx =1;
		gc.weighty =0.1;
		gc.gridx = 0;
		gc.gridy = 4;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(phoneLabel,gc);

		gc.gridx =1;
		gc.gridy =4;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(phoneField,gc);

		//sixieme ligne
		gc.weightx =1;
		gc.weighty =0.1;
		gc.gridx = 0;
		gc.gridy = 5;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(posteLabel,gc);

		gc.gridx =1;
		gc.gridy =5;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(posteField,gc);
		//derniere ligne
		gc.weightx = 1;
		gc.weighty = 2.0;
		gc.gridy =6;
		gc.gridx =0;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(insertBtn,gc);
		add(updateBtn,gc);
		gc.gridy =6;
		gc.gridx =1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.CENTER;
		add(cancelBtn,gc);

		/*gc.gridy =6;
		gc.gridx =2;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_END;
		add(resetBtn,gc);*/
	}

	public void setFormListener(FormListener listener){
		this.formListener =listener;
	}

	public void clearfileds(){
		nomField.setText("");
		prenomField.setText("");
		courrielField.setText("");
		domaineField.setText("");
		phoneField.setText("");
		posteField.setText("");
	}

	public void setNom(String nom){
		nomField.setText(nom);
	}
	
	public void setPrenom(String prenom){
		prenomField.setText(prenom);
	}
	
	public void setCourriel(String courriel){
		courrielField.setText(courriel);
	}
	
	public void setDomaine(String domaine){
		domaineField.setText(domaine);
	}
	
	public void setTel(String tel){
		phoneField.setText(tel);
	}
	
	public void setPost(String post){
		posteField.setText(post);
	}
	
	public void changeButtons(){
		insertBtn.setEnabled(!insertBtn.isEnabled());
		insertBtn.setVisible(!insertBtn.isVisible());
		updateBtn.setEnabled(!updateBtn.isEnabled());
		updateBtn.setVisible(!updateBtn.isVisible());
	}
	
	public boolean isUpdateON(){
		return updateBtn.isEnabled();
	}


}
