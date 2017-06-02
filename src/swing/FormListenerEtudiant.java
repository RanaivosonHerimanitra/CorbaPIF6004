package swing;

import java.util.EventListener;

public interface FormListenerEtudiant extends EventListener{
	public void formEventOccuredAddEtudiant(FormEventEtudiant e);

	public void formEventOccuredUpdateEtudiant(FormEventEtudiant ev);

	public void formEventOccuredCancelEtudiant();
}
