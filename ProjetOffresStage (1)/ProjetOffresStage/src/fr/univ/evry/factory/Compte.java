package fr.univ.evry.factory;

public class Compte {
	private String nom;
	private String prenom;
	private String user;
	private String mdp;
	private String type;

	
	public void seConnecter() {
		System.out.println("seConnecter");
	}
	
	public void seDeconnecter() {
		System.out.println("seConnecter");
	}
	
	public Compte(String nom, String prenom, String user, String mdp) {
		this.nom = nom;
		this.prenom = prenom;
		this.user = user;
		this.mdp = mdp;
		this.type = "utilisateur";
	}
	
	public Compte(String nom, String prenom, String user, String mdp, String type) {
		this.nom = nom;
		this.prenom = prenom;
		this.user = user;
		this.mdp = mdp;
		this.type = type;
	}

	public Compte() {
		this.nom = "";
		this.prenom = "";
		this.user = "";
		this.mdp = "";
	}
	
	
	@Override
	public String toString() {
		return "Compte [nom=" + nom + ", prenom=" + prenom + ", user=" + user + ", mdp=" + mdp + "]";
	}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getMdp() {
		return mdp;
	}
	
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
