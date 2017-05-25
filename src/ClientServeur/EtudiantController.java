package ClientServeur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import PersonnelAPP.Enseignant;
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
		statement.setLong(3, e.matricul);
		statement.setString(4, e.p.mail);
		statement.setString(5, e.p.domain);
		
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("A new student was inserted successfully into table etudiant!");
		}
	}
	
	public void update(Etudiant oldE, Etudiant modifE) throws SQLException {
		String sql = "UPDATE etudiant SET nom_et=?, prenom_et=?, matricule_et=?, courriel_et, domaine_act_et=? WHERE nom_ens=?";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, oldE.p.nom);
		statement.setString(2, oldE.p.prenom);
		statement.setLong(3, oldE.matricul);
		statement.setString(4, oldE.p.mail);
		statement.setString(5, oldE.p.domain);
		statement.setString(7, modifE.p.nom);
		 
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing student was updated successfully!");
		}
		
	}
	
	public void delete(Etudiant e) throws SQLException{
		String sql = "DELETE FROM etudiant WHERE nom_ens="+e.p.nom;
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		 
		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("An existing student was deleted successfully!");
		}
		
	}
	
	public ResultSet getStudents() throws SQLException{
		String sql = "SELECT * FROM etudiant";
		Statement stmt = conn.createStatement();
		return stmt.executeQuery(sql);		
	}
	
	public Etudiant getStudent(String nom) throws SQLException{
		String sql = "SELECT * FROM etudiant WHERE nom_et="+nom;
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery(sql);	
		if (rs==null) return null;
		return new Etudiant(new PersonInfo(rs.getString("nom_et"),rs.getString("prenom_et"),rs.getString("courriel_et"),rs.getString("domaine_act_et")),rs.getInt("matricule_et"));
	}
}
