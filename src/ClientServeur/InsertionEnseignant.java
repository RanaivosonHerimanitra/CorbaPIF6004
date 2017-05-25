package ClientServeur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertionEnseignant {
	
	public InsertionEnseignant(String nom,String prenom, String courriel, String domaine_activite, int tel, int numPost) throws SQLException {
		Connection conn = ConnectionDB.getConnection();
		String sql = "INSERT INTO enseignant (nom_ens, prenom_ens, domaine_act_ens, tel_bureau, numero_poste, courriel_ens) VALUES (?, ?, ?, ?,?,?)";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, nom);
		statement.setString(2, prenom);
		statement.setString(3, domaine_activite);
		statement.setInt(4, tel);
		statement.setInt(5, numPost);
		statement.setString(6, courriel);
		
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("A new user was inserted successfully!");
		    conn.close();
		}
	}

}
