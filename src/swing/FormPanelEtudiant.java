/*
 * a  class for data entry of Etudiant
 */
package swing;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.InputValidationErrorDialog;

public class FormPanelEtudiant extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//JLabel
	private JLabel nomLabel;
	private JLabel prenomLabel;
	private JLabel courrielLabel;
	private JLabel domaineLabel;
	private JLabel matriculeLabel;

	//JTextField
	private JTextField nomField;
	private JTextField prenomField;
	private JTextField courrielField;
	private JTextField domaineField;
	private JTextField matriculeField;

	//JButton
	private JButton insertBtn;
	private JButton updateBtn;
	private JButton cancelBtn;

	private FormListenerEtudiant formListener;

	public FormPanelEtudiant(){
		Dimension dim = getPreferredSize();
		dim.width=250;
		setPreferredSize(dim);

		nomLabel = new JLabel("Nom: ");
		prenomLabel = new JLabel("Prenom: ");
		courrielLabel = new JLabel("Courriel: ");
		domaineLabel = new JLabel("Domaine d'activit�: ");
		matriculeLabel = new JLabel("Matricule: ");

		nomField = new JTextField(10);
		prenomField = new JTextField(10);
		courrielField = new JTextField(10);
		domaineField = new JTextField(10);
		matriculeField = new JTextField(10);

		insertBtn = new JButton("Ins�rer");
		cancelBtn = new JButton("Annuler");
		updateBtn = new JButton("Modifier");
		updateBtn.setEnabled(false);
		updateBtn.setVisible(false);
		insertBtn.setMnemonic(KeyEvent.VK_0);
		nomLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		nomLabel.setLabelFor(nomField);

		insertBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				String nom= nomField.getText();
				String prenom = prenomField.getText();
				String courriel = courrielField.getText();
				String domaine = domaineField.getText();
				String matricule = matriculeField.getText();

				FormEventEtudiant ev = new FormEventEtudiant(this,nom,prenom,courriel,domaine,matricule);
				if(formListener !=null)
					//input checking validation :
					if ( !InputValidationErrorDialog.areFieldEmpty(nom, prenom,matricule,domaine) & InputValidationErrorDialog.isEmailValid(courriel)  )
						formListener.formEventOccuredAddEtudiant(ev);
			}	
		});

		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(formListener !=null)
					formListener.formEventOccuredCancelEtudiant();
			}
		});

		updateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nom= nomField.getText();
				String prenom = prenomField.getText();
				String courriel = courrielField.getText();
				String domaine = domaineField.getText();
				String matricule = matriculeField.getText();

				FormEventEtudiant ev = new FormEventEtudiant(this,nom,prenom,courriel,domaine,matricule);
				if(formListener !=null)
					//input checking validation :
					if ( !InputValidationErrorDialog.areFieldEmpty(nom, prenom,matricule,domaine)  &
							InputValidationErrorDialog.isEmailValid(courriel)  )
						formListener.formEventOccuredUpdateEtudiant(ev);
			}
		});

		Border innerBorder = BorderFactory.createTitledBorder("Etudiant");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		layoutComponents();
	}

	private void layoutComponents() {
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
		add(matriculeLabel,gc);

		gc.gridx =1;
		gc.gridy =4;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(matriculeField,gc);

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

	}

	public void setFormListener(FormListenerEtudiant listener){
		this.formListener =listener;
	}

	public void clearfileds(){
		nomField.setText("");
		prenomField.setText("");
		courrielField.setText("");
		domaineField.setText("");
		matriculeField.setText("");
	}

	public void setNom(String nom) {
		nomField.setText(nom);
	}

	public void setPrenom(String prenom) {
		prenomField.setText(prenom);

	}

	public void setCourriel(String mail) {
		courrielField.setText(mail);
	}

	public void setDomaine(String domain) {
		domaineField.setText(domain);
	}

	public void setMatricul(String matricul) {
		matriculeField.setText(matricul);
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
