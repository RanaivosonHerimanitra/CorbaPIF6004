package swing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

	private JFrame frame;
	private JTextField userField;
	private JPasswordField passwordField;
	private final String login="admin";
	private final String pass="admin";
	private final String login1="user";
	private final String pass1 ="user";

	//Methode initialiser
	public void initialiser(){
		userField.setText("");
		passwordField.setText("");

		userField.requestFocus();
	}//fin methode
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel userLabel = new JLabel("Nom Utilisateur:");
		userLabel.setBounds(24, 84, 124, 27);
		frame.getContentPane().add(userLabel);

		JLabel pwLabel = new JLabel("Mot de passe:");
		pwLabel.setBounds(24, 122, 98, 21);
		frame.getContentPane().add(pwLabel);

		userField = new JTextField();
		userField.setBounds(137, 87, 124, 20);
		frame.getContentPane().add(userField);
		userField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(137, 122, 124, 20);
		frame.getContentPane().add(passwordField);

		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(userField.getText().equals(login) && passwordField.getText().equals(pass)){
					Menu a = new Menu();
					a.setVisible(true);
					frame.setVisible(false);
					initialiser();
				}else if(userField.getText().equals(login1) && passwordField.getText().equals(pass1)){
					MenuUser mu = new MenuUser();
					mu.setVisible(true);
				}
			}
		});
		btnConnexion.setBounds(134, 165, 124, 20);
		frame.getContentPane().add(btnConnexion);
	}
}
