/*
 * contains all crud method for Enseignant
 */
package ClientServeur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import PersonnelAPP.Enseignant;
import PersonnelAPP.PersonInfo;

public class EnseignantController {
	private Connection conn;
	
	public EnseignantController()  {
		conn = ConnectionDB.getConnection();
	}
	public ArrayList<Enseignant> getEnseignant() throws SQLException 
	{
		String sql = "SELECT * FROM enseignant";
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery(sql);
		ArrayList<Enseignant> ListEnseignant = new ArrayList<Enseignant>();

		while (rs.next()){
			String nom = rs.getString("nom_ens");
		    String prenom = rs.getString("prenom_ens");
		    String domaine = rs.getString("domaine_act_ens");
		    long tel_bureau = rs.getLong("tel_bureau");
		    long numero_poste = rs.getLong("numero_poste");
		    String courriel_ens = rs.getString("courriel_ens");
		    Enseignant e = new Enseignant(new PersonInfo(nom,prenom,courriel_ens,domaine),tel_bureau,numero_poste) ;
			ListEnseignant.add(e);
		}
		return ListEnseignant;
	
	}
	
	public Enseignant selectEnseignant(String nom, String prenom) {
		String sql = "SELECT * FROM enseignant WHERE nom_ens=? AND prenom_ens=?";
		PreparedStatement statement;
	
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, nom);
			statement.setString(2, prenom);
			ResultSet result;
			result = statement.executeQuery();
			if (result == null)
				return new Enseignant(new PersonInfo("","","",""),0,0);

			while (result.next()){
				Enseignant e = new Enseignant(new PersonInfo(result.getString("nom_ens"),result.getString("prenom_ens"),
						result.getString("courriel_ens"),result.getString("domaine_act_ens")),result.getLong("tel_bureau"),
						result.getLong("numero_poste")) ;
				return e;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return new Enseignant(new PersonInfo("","","",""),0,0);
		}
		return new Enseignant(new PersonInfo("","","",""),0,0);
	}
	
	public void insertion(Enseignant e) throws SQLException {
		String sql = "INSERT INTO enseignant (nom_ens, prenom_ens, domaine_act_ens, tel_bureau, numero_poste, courriel_ens) VALUES (?, ?, ?, ?,?,?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, e.p.nom);
		statement.setString(2, e.p.prenom);
		statement.setString(3, e.p.domain);
		statement.setLong(4, e.tel);
		statement.setLong(5, e.post);
		statement.setString(6, e.p.mail);
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("A new user was inserted successfully!");
		}
	}
	public void update(Enseignant oldE, Enseignant modifE) throws SQLException {
		String sql = "UPDATE enseignant SET nom_ens=?, prenom_ens=?, domaine_act_ens=?, tel_bureau=?, numero_poste=?, courriel_ens=? WHERE nom_ens=?";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, modifE.p.nom);
		statement.setString(2, modifE.p.prenom);
		statement.setString(3, modifE.p.domain);
		statement.setLong(4, modifE.tel);
		statement.setLong(5, modifE.post);
		statement.setString(6, modifE.p.mail);
		statement.setString(7, oldE.p.nom);
		 
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing user was updated successfully!");
		}
	}
	public void delete(Enseignant e) throws SQLException 
	{
		String sql = "DELETE FROM enseignant WHERE nom_ens=?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, e.p.nom);
		 
		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("A user was deleted successfully!");
		}
	}
	public ArrayList<Enseignant> getEnseignant(String domain) throws SQLException {
		String sql = "SELECT * FROM enseignant WHERE domaine_act_ens_ens=?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1,domain);
		ResultSet rs= statement.executeQuery(sql);
		ArrayList<Enseignant> ListEnseignant = new ArrayList<Enseignant>();

		while (rs.next()){
			String nom = rs.getString("nom_ens");
		    String prenom = rs.getString("prenom_ens");
		    String domaine = rs.getString("domaine_act_ens");
		    long tel_bureau = rs.getLong("tel_bureau");
		    long numero_poste = rs.getLong("numero_poste");
		    String courriel_ens = rs.getString("courriel_ens");
		    Enseignant e = new Enseignant(new PersonInfo(nom,prenom,courriel_ens,domaine),tel_bureau,numero_poste) ;
			ListEnseignant.add(e);
		}
		return ListEnseignant;
	}

}