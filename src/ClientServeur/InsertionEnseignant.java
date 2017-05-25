package ClientServeur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertionEnseignant {
	
	public InsertionEnseignant(String nom,String prenom, String courriel, String categorie, String domaine_activite) throws SQLException {
		ConnectionDB c = new ConnectionDB();
		Connection conn = c.getConnection();
		String sql = "INSERT INTO Personne (nom, prenom, courriel, categorie, domaine_activite) VALUES (?, ?, ?, ?,?)";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, nom);
		statement.setString(2, prenom);
		statement.setString(3, courriel);
		statement.setString(4, categorie);
		statement.setString(5, domaine_activite);
		 
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("A new user was inserted successfully!");
		    c.closeConnection();
		}
	}

}
