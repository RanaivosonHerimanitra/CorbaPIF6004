package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	private StringListener textListener;

	public Toolbar(){
		setBorder(BorderFactory.createEtchedBorder());
	}

	public void setStringListener(StringListener listener){
		this.textListener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		
	}

}
