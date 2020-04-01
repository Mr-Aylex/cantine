package cantine;
/**
 * @author CARMONE_Al
 *
 */
public class Utilisateur {
	protected int id;
	protected String nom;
	protected String prenom;
	protected int age;
	protected String mail;
	protected String mdp;
	protected Boolean admin;
	protected String classe;
	/**
	 * Utilisateur constructor
	 */
	public Utilisateur(/*String nom, String prenom, String mail, String mdp, Boolean admin*/) {
		
	}
	/**
	 * @return int
	 */
	public int getId() {
		return this.id;
	}
	public Utilisateur setId(int id) {
		this.id = id;
		return this;
	}
	/**
	 * @return String
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param String nom
	 * @return Utilisateur
	 */
	public Utilisateur setNom(String nom) {
		this.nom = nom;
		return this;
	}
	/**
	 * @return String prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param String nom
	 * @return Utilisateur
	 */
	public Utilisateur setPrenom(String prenom) {
		this.prenom = prenom;
		return this;
	}
	public int getAge() {
		return this.age;
	}
	public Utilisateur setAge(int age) {
		this.age = age;
		return this;
	}
	/**
	 * 
	 * @return String mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param String mail
	 * @return Utilisateur
	 */
	public Utilisateur setMail(String mail) {
		this.mail = mail;
		return this;
	}
	/**
	 * @return String
	 */
	public String getMdp() {
		return mdp;
	}
	/**
	 * @param String mdp
	 * @return Utilisateur
	 */
	public Utilisateur setMdp(String mdp) {
		this.mdp = mdp;
		return this;
	}
	/**
	 * 
	 * @return Boolean
	 */
	public Boolean getAdmin() {
		return admin;
	}
	/**
	 * 
	 * @param Boolean admin
	 * @return Utilisateur
	 */
	public Utilisateur setAdmin(Boolean admin) {
		this.admin = admin;
		return this;
	}
	public String getClasse() {
		return classe;
	}
	public Utilisateur setClasse(String classe) {
		this.classe = classe;
		return this;
	}
}
