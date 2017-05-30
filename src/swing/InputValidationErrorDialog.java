/*
 * A class to handle errors when user try to crud in Swing
 * Source:https://stackoverflow.com/questions/8204680/java-regex-email
 */
package swing;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import PersonnelAPP.Enseignant;
import PersonnelAPP.Etudiant;

public class InputValidationErrorDialog 
{
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public static void showErrorMsg(String message)
	{
		boolean out = true;
		//String message = "Les champs ne doivent pas etre vides!";
		JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
		
	}
	public static void isEmailValid(Etudiant e)
	{
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(e.p.mail);
        if( matcher.find()) 	
        {
        	
        } else {
        	
        }
	}
	public static void isEmailValid(Enseignant e)
	{
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(e.p.mail);
		 if( matcher.find()) 	
	        {
	        	
	        } else {
	        	
	        }	
	}
	
	public boolean isPhoneNumberValid(Etudiant e)
	{
		boolean out = true;
		return out;
	}
	public boolean isPhoneNumberValid(Enseignant e)
	{
		boolean out = true;
		return out;
	}
}
