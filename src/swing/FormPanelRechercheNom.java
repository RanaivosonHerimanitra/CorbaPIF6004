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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import PersonnelAPP.Enseignant;
import controller.ControllerEnseignant;

public class FormPanelRechercheNom extends JPanel {
			//JLabel
			private JLabel nomLabel;
			private JLabel prenomLabel;
			
			//JTextField
			
			private JTextField nomField;
			private JTextField prenomField;
			//JButton
			//JButton
			private JButton searchBtn;
			private JButton cancelBtn;
			
			
			/*
			 * addition Herimanitra, 16h, 06 02 2017
			 */
			private FormListener formListener;
			private FormPanelEnseignant formPanelEnseignant;
			ControllerEnseignant controller = new ControllerEnseignant();
			TablePanel tablePanel = new TablePanel();
			FormPanelEnseignant formPanel = new FormPanelEnseignant();
			//

			public FormPanelRechercheNom(){
				Dimension dim = getPreferredSize();
				dim.width=250;
				setPreferredSize(dim);
				nomLabel = new JLabel("Nom: ");
				nomField = new JTextField(10);
				prenomLabel = new JLabel("Prénom: ");
				prenomField = new JTextField(10);
				
				searchBtn = new JButton("Rechercher");
				cancelBtn = new JButton("Annuler");
				searchBtn.setMnemonic(KeyEvent.VK_0);
				nomLabel.setDisplayedMnemonic(KeyEvent.VK_N);
				nomLabel.setLabelFor(nomField);
				
				Border innerBorder = BorderFactory.createTitledBorder("Recherche par Noms");
				Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
				setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

				layoutComponents();
				
				/*
				 * action to search for Enseignant by nom prenom
				 */
				formPanelEnseignant.setFormListener(new FormListener(){
					@Override
					public void formEventOccured(FormEventEnseignat e) throws SQLException 
					{
						Enseignant[] ens = controller.getProfesseurs();
						for ( Enseignant x: ens) 
						{
							if ( x.p.nom.equals(nomField) & x.p.prenom.equals(prenomField) )
							{
								JOptionPane.showMessageDialog(tablePanel, "enseignant trouvÉ");
								tablePanel.setData(controller.getProfesseurs());
								tablePanel.refresh();
								formPanel.clearfileds();
							 }
						}
					}

					@Override
					public void formEventOccuredUpdateEnseignant(FormEventEnseignat e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void formEventOccuredCancelEnseignant() {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void formEventOccuredCancelDomain() {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void formEventOccuredSearchByDomain(String string) {
						// TODO Auto-generated method stub
						
					}});
				searchBtn.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						String nom= nomField.getText();
						String prenom = prenomField.getText();
						FormEventEnseignat ev = new FormEventEnseignat(this,nom,prenom,"","",0,0);
						if(formListener !=null)
						{
							try 
							{
								//input checking validation :
								if (!InputValidationErrorDialog.areFieldEmpty(nom, prenom) )
										
												formListener.formEventOccured(ev);

							} catch (SQLException e1) {

								e1.printStackTrace();
							}
						}
					}

				});


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
				
				//derniere ligne
				gc.weightx = 1;
				gc.weighty = 2.0;
				gc.gridy =6;
				gc.gridx =0;
				gc.insets = new Insets(0,0,0,5);
				gc.anchor = GridBagConstraints.LINE_END;
				add(searchBtn,gc);
				//add(updateBtn,gc);
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
			}

			public void setNom(String nom){
				nomField.setText(nom);
			}
			
			public void setPrenom(String prenom){
				prenomField.setText(prenom);
			}
}
