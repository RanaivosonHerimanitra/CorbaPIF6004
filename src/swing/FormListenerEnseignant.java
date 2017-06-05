package swing;

import java.sql.SQLException;
import java.util.EventListener;

public interface FormListenerEnseignant extends EventListener{
	public void formEventOccured(FormEventEnseignat e) throws SQLException;

	void formEventOccuredUpdateEnseignant(FormEventEnseignat e);

	void formEventOccuredCancelEnseignant();

	public void formEventOccuredCancelDomain();

	public void formEventOccuredSearchByDomain(String string);
	public void formEventOccuredSearchByNomPrenom(String nom, String prenom) ;

}
