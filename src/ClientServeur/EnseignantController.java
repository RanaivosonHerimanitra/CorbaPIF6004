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
	//private static  LinkedList<Enseignant> ListEnseignant ;//today
	private Connection conn;

	public EnseignantController()  {
		conn = ConnectionDB.getConnection();
		//ListEnseignant = new LinkedList<Enseignant>();//today
	}


	public ArrayList<Enseignant> getEnseignant() throws SQLException{
		String sql = "SELECT * FROM enseignant";
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery(sql);
		ArrayList<Enseignant> ListEnseignant = new ArrayList<Enseignant>();

		while (rs.next()){
			ListEnseignant.add(new Enseignant(new PersonInfo(rs.getString("nom_et"),rs.getString("prenom_et"),
					rs.getString("courriel_et"),rs.getString("domaine_act_et")),rs.getLong("tel_bureau"),
					rs.getLong("numero_poste")));
		}
		return ListEnseignant;
		/*
		String sql = "SELECT * FROM enseignant";
		//today
		ArrayList<Enseignant> ListEnseignant = new ArrayList<Enseignant>();
		//List<Enseignant> ListEnseignant = new LinkedList<Enseignant>();
		//today fin
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()){
		    String nom = result.getString("nom_ens");
		    String prenom = result.getString("prenom_ens");
		    String domaine = result.getString("domaine_act_ens");
		    long tel_bureau = result.getLong("tel_bureau");
		    long numero_poste = result.getLong("numero_poste");
		    String courriel_ens = result.getString("courriel_ens");
		    Enseignant e = new Enseignant(new PersonInfo(nom,prenom,courriel_ens,domaine),tel_bureau,numero_poste) ;

		    ListEnseignant.add(e);
		}
		//today 

		System.out.println("la");
		return ListEnseignant;
		//return (ArrayList<Enseignant>) Collections.unmodifiableList(ListEnseignant);
		//today
		 */

	}
	//today debut
	public void removeEnseignant(int index){
		try {
			getEnseignant().remove(index);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//today fin
	public Enseignant selectEnseignant(String nom, String prenom) throws SQLException{
		String sql = "SELECT * FROM enseignant WHERE nom_ens=? AND prenom_ens=?";
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, nom);
			statement.setString(2, prenom);
			System.out.println("before search");
			ResultSet result;
			System.out.println("before query");
			result = statement.executeQuery();
			System.out.println("After query");
			while (result.next()){
				Enseignant e = new Enseignant(new PersonInfo(result.getString("nom_ens"),result.getString("prenom_ens"),result.getString("courriel_ens"),result.getString("domaine_act_ens")),result.getInt("tel_bureau"),result.getInt("numero_poste")) ;
				System.out.println(e.p.nom+" is found");
				return e;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
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
		System.out.println(statement);
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("A new user was inserted successfully!");
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

}