/*
 * interface pour l'implementation de la suppression/modification par click droit
 */
package swing;

public interface EnseignantTableListener {
	public void rowDeleted(int row);
	public void rowUpdate(int row);
}
