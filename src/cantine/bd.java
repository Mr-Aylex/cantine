package cantine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class bd {
	private String url="jdbc:mysql://localhost/cantine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String user="root";
	private String password="";
	/**
	 * 
	 */
	public Connection bd() {
		try {
			Connection cnx = DriverManager.getConnection(url,user,password);
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
	public utilisateur connexion(String mail, String mdp) throws SQLException {
		Connection cnx = this.bd();
		String sql = "SELECT * FROM utilisateur WHERE mail=? and mdp=?";
		PreparedStatement stm = cnx.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		stm.setString(1, mail);
		stm.setString(2, mdp);
		ResultSet rs = stm.executeQuery();
		utilisateur ut = new utilisateur();
		while(rs.next()) {
			ut.setNom(rs.getString("nom"))
			.setPrenom(rs.getString("prenom"))
			.setMail(rs.getString("mail"))
			.setMdp(rs.getString("mdp"))
			.setAdmin(rs.getString("admin"))
		;
		}
		rs.close();
		cnx.close();
		return ut;
	}
	
}
