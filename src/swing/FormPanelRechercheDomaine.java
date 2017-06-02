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

public class FormPanelRechercheDomaine extends JPanel {
		//JLabel
		
		private JLabel domaineLabel;
		
		//JTextField
		
		private JTextField domaineField;
		
		//JButton
		private JButton searchBtn;
		private JButton cancelBtn;
		private FormListener formListener;

		public FormPanelRechercheDomaine(){
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

			

			Border innerBorder = BorderFactory.createTitledBorder("Recherche par Domaine");
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
			add(domaineLabel,gc);

			gc.gridx =1;
			gc.gridy =0;
			gc.insets = new Insets(0,0,0,0);
			gc.anchor = GridBagConstraints.LINE_START;
			add(domaineField,gc);

			
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
			
			domaineField.setText("");
			
		}

		
		
		public void setDomaine(String domaine){
			domaineField.setText(domaine);
		}
		
		/*public void changeButtons(){
			insertBtn.setEnabled(!insertBtn.isEnabled());
			insertBtn.setVisible(!insertBtn.isVisible());
			updateBtn.setEnabled(!updateBtn.isEnabled());
			updateBtn.setVisible(!updateBtn.isVisible());
		}
		
		public boolean isUpdateON(){
			return updateBtn.isEnabled();
		}*/


}
