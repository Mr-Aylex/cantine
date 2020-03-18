package cantine;
/**
 * 
 * @author CARMONE_Al
 *
 */
public class utilisateur {
	protected String nom;
	protected String prenom;
	protected String mail;
	protected String mdp;
	protected String admin;
	/**
	 * Utilisateur constructor
	 */
	public utilisateur(/*String nom, String prenom, String mail, String mdp, String admin*/) {
		
	}
	public String getNom() {
		return nom;
	}
	public utilisateur setNom(String nom) {
		this.nom = nom;
		return this;
	}
	public String getPrenom() {
		return prenom;
	}
	public utilisateur setPrenom(String prenom) {
		this.prenom = prenom;
		return this;
	}
	public String getMail() {
		return mail;
	}
	public utilisateur setMail(String mail) {
		this.mail = mail;
		return this;
	}
	public String getMdp() {
		return mdp;
	}
	public utilisateur setMdp(String mdp) {
		this.mdp = mdp;
		return this;
	}
	public String getAdmin() {
		return admin;
	}
	public utilisateur setAdmin(String admin) {
		this.admin = admin;
		return this;
	}
	
}
