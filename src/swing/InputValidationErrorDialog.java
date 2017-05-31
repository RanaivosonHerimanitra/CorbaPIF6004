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
	public static final String PHONE_REGEX = "\\+\\d(-\\d{3}){2}-\\d{4}";
	public static final  Pattern VALID_TELEPHONE = Pattern.compile(PHONE_REGEX);
	
	public static void showErrorMsg(String message)
	{
		
		JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
		
	}
	public static void isEmailValid(Etudiant e)
	{
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(e.p.mail);
        if( !matcher.find()) 	
        {
        	showErrorMsg("n'est pas une adresse email valide!");
        }
	}
	public static void isEmailValid(Enseignant e)
	{
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(e.p.mail);
		 if( !matcher.find()) 	
	        {
			 showErrorMsg("n'est pas une adresse email valide!");
	        }	
	}
	
	public static void isPhoneNumberValid(Etudiant e)
	{
		//boolean out =  e..matches(regexPattern);;
	
	}
	public static void isPhoneNumberValid(Enseignant e)
	{
		Matcher matcher = VALID_TELEPHONE .matcher( String.valueOf(e.tel));
		 if( !matcher.find()) 	
	        {
			 showErrorMsg("n'est pas un telephone valide!");
	        }	
		
	}
}
