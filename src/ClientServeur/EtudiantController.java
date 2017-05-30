/*
 * contains all crud method for Etudiant
 */
package ClientServeur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import PersonnelAPP.Etudiant;
import PersonnelAPP.PersonInfo;

public class EtudiantController {
	private Connection conn;
	
	public EtudiantController() {
		conn = ConnectionDB.getConnection();
	}
	
	public void insertion(Etudiant e) throws SQLException {
		String sql = "INSERT INTO etudiant (nom_et, prenom_et, matricule_et, courriel_et, domaine_act_et) VALUES (?, ?, ?, ?,?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, e.p.nom);
		statement.setString(2, e.p.prenom);
		statement.setString(3, e.matricul);
		statement.setString(4, e.p.mail);
		statement.setString(5, e.p.domain);
		
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("A new student was inserted successfully into table etudiant!");
		}
	}
	
	public void update(Etudiant oldE, Etudiant modifE) throws SQLException {
		String sql = "UPDATE etudiant SET nom_et=?, prenom_et=?, matricule_et=?, courriel_et=?, domaine_act_et=? WHERE nom_et=?";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, modifE.p.nom);
		statement.setString(2, modifE.p.prenom);
		statement.setString(3, modifE.matricul);
		statement.setString(4, modifE.p.mail);
		statement.setString(5, modifE.p.domain);
		statement.setString(6, oldE.p.nom);
		 
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing student was updated successfully!");
		}
		
	}
	
	public void delete(Etudiant e) throws SQLException{
		String sql = "DELETE FROM etudiant WHERE nom_et=?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, e.p.nom);
		 
		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("A user was deleted successfully!");
		}
	}
	
	public ArrayList<Etudiant> getStudents() throws SQLException{
		String sql = "SELECT * FROM etudiant";
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery(sql);
		ArrayList<Etudiant> ListEtudiant = new ArrayList<Etudiant>();
		
		while (rs.next()){
		    ListEtudiant.add(new Etudiant(new PersonInfo(rs.getString("nom_et"),rs.getString("prenom_et"),rs.getString("courriel_et"),rs.getString("domaine_act_et")),rs.getString("matricule_et")));
		}
		return ListEtudiant;
	}
	
	public Etudiant getStudent(String nom) throws SQLException{
		String sql = "SELECT * FROM etudiant WHERE nom_et=?";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, nom);
		 
		ResultSet result= statement.executeQuery();
		while (result.next()){
		    Etudiant e = new Etudiant(new PersonInfo(result.getString("nom_et"), result.getString("prenom_et"), result.getString("courriel_et"),result.getString("domaine_act_et")), result.getString("matricule_et"));
			System.out.println(e.p.nom+" is found");
			return e;
		}
		return null;
	}
}
