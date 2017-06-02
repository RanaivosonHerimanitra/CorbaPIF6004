package swing;

import java.sql.SQLException;
import java.util.EventListener;

public interface FormListener extends EventListener{
	public void formEventOccured(FormEventEnseignat e) throws SQLException;

	void formEventOccuredUpdateEnseignant(FormEventEnseignat e);

	void formEventOccuredCancelEnseignant();

}
