package ClientServeur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import PersonnelAPP.Enseignant;

public class EnseignantController {
	private Connection conn;
	
	public EnseignantController()  {
		conn = ConnectionDB.getConnection();
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
		    conn.close();
		}
	}
	public void update(Enseignant oldE, Enseignant modifE) throws SQLException {
		String sql = "UPDATE enseignant SET nom_ens=?, prenom_ens=?, domaine_act_ens=?, tel_bureau=?, numero_poste=?, courriel_ens=? WHERE nom_ens=?";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, oldE.p.nom);
		statement.setString(2, oldE.p.prenom);
		statement.setString(3, oldE.p.domain);
		statement.setLong(4, oldE.tel);
		statement.setLong(5, oldE.post);
		statement.setString(6, oldE.p.mail);
		statement.setString(7, modifE.p.nom);
		 
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing user was updated successfully!");
		}
		
	}

}