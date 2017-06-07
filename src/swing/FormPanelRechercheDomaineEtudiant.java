/*
 * UI pour la recherche d'etudiants par son domaine
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

public class FormPanelRechercheDomaineEtudiant extends JPanel {
	private static final long serialVersionUID = 1L;
	//JLabel
	
	private JLabel domaineLabel;
	
	//JTextField
	
	private JTextField domaineField;
	
	//JButton
	private JButton searchBtn;
	private JButton cancelBtn;

	private FormListenerEtudiant formListener;

	public FormPanelRechercheDomaineEtudiant(){
		Dimension dim = getPreferredSize();
		dim.width=250;
		setPreferredSize(dim);

		domaineLabel = new JLabel("Domaine d'activité: ");
		
		domaineField = new JTextField(10);
		searchBtn = new JButton("Rechercher");
		cancelBtn = new JButton("Annuler");
		
		searchBtn.setMnemonic(KeyEvent.VK_0);
		domaineLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		domaineLabel.setLabelFor(domaineField);

		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(formListener !=null)
					formListener.formEventOccuredCancelDomain();
			}
		});
		
		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(formListener !=null & !InputValidationErrorDialog.areFieldEmpty(domaineField.getText()))
					formListener.formEventOccuredSearchByDomain(domaineField.getText());

			}
		});

		
		Border innerBorder = BorderFactory.createTitledBorder("Recherche par Domaine");
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
		add(domaineLabel,gc);

		gc.gridx =1;
		gc.gridy =0;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(domaineField,gc);
		
		//derniere ligne
				gc.weightx = 1;
				gc.weighty = 2.0;
				gc.gridy =1;
				gc.gridx =0;
				gc.insets = new Insets(0,0,0,5);
				gc.anchor = GridBagConstraints.LINE_END;
				add(searchBtn,gc);

				gc.gridy =1;
				gc.gridx =1;
				gc.insets = new Insets(0,0,0,0);
				gc.anchor = GridBagConstraints.CENTER;
				add(cancelBtn,gc);

	}

	public void setFormListener(FormListenerEtudiant listener){
		this.formListener =listener;
	}

	public void clearfileds(){
		domaineField.setText("");
	}

	public void setDomaine(String domain) {
		domaineField.setText(domain);
	}

}
