package swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener{
	private JButton searchBtn;
	private JButton displayBtn;
	
	
private StringListener textListener;
	
	public Toolbar() {
		setBorder(BorderFactory.createEtchedBorder());
		
		searchBtn = new JButton("Rechercher");
		displayBtn = new JButton("Afficher");
		
		
		searchBtn.addActionListener(this);
		displayBtn.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(searchBtn);
		add(displayBtn);
	}
	
	public void setStringListener(StringListener listener) {
		this.textListener = listener;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
JButton clicked = (JButton)e.getSource();
		
		if(clicked == searchBtn) {
			if(textListener != null) {
				textListener.textEmitted("Recherche\n");
			}
		}
		else if(clicked == displayBtn) {
			if(textListener != null) {
				textListener.textEmitted("Affiche\n");
			}
		}
		
		
	}
	
}
