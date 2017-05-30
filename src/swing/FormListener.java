package swing;

import java.sql.SQLException;
import java.util.EventListener;

public interface FormListener extends EventListener{
	public void formEventOccured(FormEventEnseignat e) throws SQLException;
<<<<<<< HEAD
=======
	public void formEventOccuredAddEtudiant(FormEventEtudiant e) throws SQLException;
>>>>>>> master
}
