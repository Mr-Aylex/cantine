package cantine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @author Carmone Alexandre
 *
 */
public class bd {
	private String url="jdbc:mysql://localhost/cantine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String user="root";
	private String password="";
	
	/**
	 * 
	 */
	public Connection bd() {
		try {
			Connection cnx = DriverManager.getConnection(this.url,this.user,this.password);
			System.out.println("Etat de la connexion");
			System.out.println(cnx.isClosed()?"fermé":"ouvert");
			System.out.println("création de l'etat");
			return cnx;
		}
		catch (SQLException e){
			System.out.println("Eurreur");
			e.printStackTrace();
		}
		return null;
	}
	public Utilisateur connexion(String mail, String mdp) throws SQLException {
		Connection cnx = this.bd();
		String sql = "SELECT * FROM Utilisateur WHERE mail=? and mdp=? and admin = 1";
		PreparedStatement stm = cnx.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		stm.setString(1, mail);
		stm.setString(2, mdp);
		ResultSet rs = stm.executeQuery();
		Utilisateur ut = new Utilisateur();
		while(rs.next()) {
			ut.setNom(rs.getString("nom"))
			.setPrenom(rs.getString("prenom"))
			.setMail(rs.getString("mail"))
			.setMdp(rs.getString("mdp"))
			.setAdmin(rs.getBoolean("admin"))
		;
		}
		rs.close();
		cnx.close();
		return ut;
	}
	public int nb_ligne() throws SQLException {
		Connection cnx = this.bd();
		String sql = "SELECT * FROM utilisateur WHERE admin NOT LIKE 1";
		PreparedStatement stm = cnx.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stm.executeQuery();
		int i=0;
		while(rs.next()) {
			i++;
		}
		return i;
	}
	/**
	 * @return
	 */
	public Utilisateur[] getUsers()  throws SQLException {
		int nb = this.nb_ligne();
		Utilisateur[] users = new Utilisateur[nb];
		Connection cnx = this.bd();
		String sql = "SELECT * FROM utilisateur WHERE admin NOT LIKE 1";
		PreparedStatement stm = cnx.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stm.executeQuery();
		int i=0;
		while(rs.next()) {
			Utilisateur ut = new Utilisateur();
			ut.setNom(rs.getString("nom"))
			.setPrenom(rs.getString("prenom"))
			.setAge(rs.getInt("age"))
			.setMail(rs.getString("mail"))
			.setMdp(rs.getString("mdp"))
			.setAdmin(rs.getBoolean("admin"))
			.setId(rs.getInt("id"))
			.setClasse(rs.getString("classe"))
			;
			System.out.println(i);
			users[i] = ut;
			i++;
		}
		return users;
	}
	public boolean newUsers(String nom, String prenom, int age, String mail, String mdp, boolean admin, String classe) throws SQLException {
		Connection cnx = this.bd();
		String sql = "INSERT INTO utilisateur (nom, prenom, age, mail, mdp, admin, classe) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement stm = cnx.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		System.out.println(nom);
		stm.setString(1, nom);
		stm.setString(2, prenom);
		stm.setInt(3, age);
		stm.setString(4, mail);
		stm.setString(5, mdp);
		stm.setBoolean(6, admin);
		stm.setString(7, classe);
		boolean rs = stm.execute();
		return true;
	}
}
