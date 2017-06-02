/*
 * A class to handle errors when user try to crud in Swing
 * Source:https://stackoverflow.com/questions/8204680/java-regex-email
 * http://www.journaldev.com/641/regular-expression-phone-number-validation-in-java
 */
package swing;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class InputValidationErrorDialog 
{
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX =  Pattern.compile(
			"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
	public static final String PHONE_REGEX = "\\+\\d(-\\d{3}){2}-\\d{4}";
	public static final  Pattern VALID_TELEPHONE = Pattern.compile(PHONE_REGEX);

	public static void showErrorMsg(String message){

		JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);

	}

	public static boolean isEmailValid(String e){
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(e);
		if( !matcher.find()) 	
		{
			showErrorMsg("n'est pas une adresse email valide!");
			return false;
		} else 
		{
			return true;
		}
	}

	public static boolean isPhoneNumberValid(String e){
		//validate phone numbers of format "1234567890"
		if (e.matches("\\d{10}")) return true;
		//validating phone number with -, . or spaces
		else if(e.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
		//validating phone number with extension length from 3 to 5
		else if(e.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
		//validating phone number where area code is in braces ()
		else if(e.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
		//return false if nothing matches the input
		else {
			showErrorMsg("n'est pas un telephone valide!");
			return false;	
		}
	}

	public static boolean isPostValid(String e){
		if( e.matches("\\d{4}")) return true;	
		showErrorMsg("n'est pas un numéro de post valide! un numéro de post valide contient 4 chiffres");
		return false;
	}
	/*
	 * ensure some key fields are not empty during data entry
	 */
	public static boolean areFieldEmpty (String nom, String prenom) {
	   if (!nom.isEmpty() & !prenom.isEmpty() ) {
		   return false;
	   } else {
		   showErrorMsg("le nom et prenom ne doivent pas etre vides");
		   return true;
	   }
	}
	/*
	 * surcharge
	 */
	public static boolean areFieldEmpty (String nom, String prenom,String matricule) {
		   if (!nom.isEmpty() & !prenom.isEmpty()  & !matricule.isEmpty() ) {
			   return false;
		   } else {
			   showErrorMsg("le nom,prenom et matricule ne doivent pas etre vides");
			   return true;
		   }
		}
	
}
