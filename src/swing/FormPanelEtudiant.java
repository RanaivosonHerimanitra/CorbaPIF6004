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

public class FormPanelEtudiant extends JPanel {
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
		private JButton deleteBtn;
		
		private FormListener formListener;
		
		public FormPanelEtudiant(){
			Dimension dim = getPreferredSize();
			dim.width=250;
			setPreferredSize(dim);
			
			nomLabel = new JLabel("Nom: ");
			prenomLabel = new JLabel("Prenom: ");
			courrielLabel = new JLabel("Courriel: ");
			domaineLabel = new JLabel("Domaine d'activité: ");
			matriculeLabel = new JLabel("Matricule: ");
			
			nomField = new JTextField(10);
			prenomField = new JTextField(10);
			courrielField = new JTextField(10);
			domaineField = new JTextField(10);
			matriculeField = new JTextField(10);
			
			insertBtn = new JButton("Insérer");
			deleteBtn = new JButton("Supprimer");
			
			insertBtn.setMnemonic(KeyEvent.VK_0);
			nomLabel.setDisplayedMnemonic(KeyEvent.VK_N);
			nomLabel.setLabelFor(nomField);
			
			insertBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String nom= nomField.getText();
					String prenom = prenomField.getText();
					String courriel = courrielField.getText();
					String domaine = domaineField.getText();
					String matricule = matriculeField.getText();
					
					//FormEventEnseignat ev = new FormEventEnseignat(this,nom,prenom,courriel,domaine,phone,poste);
					if(formListener !=null){
						/*try {
							//formListener.formEventOccured(ev);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}*/
					}
				}
				
			});
			Border innerBorder = BorderFactory.createTitledBorder("Enseignant");
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
			
			gc.gridy =6;
			gc.gridx =1;
			gc.insets = new Insets(0,0,0,0);
			gc.anchor = GridBagConstraints.CENTER;
			add(deleteBtn,gc);
			
		}
		public void setFormListener(FormListener listener){
			this.formListener =listener;
		}
		
}
