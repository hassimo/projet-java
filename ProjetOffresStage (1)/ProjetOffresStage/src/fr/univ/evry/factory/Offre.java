package fr.univ.evry.factory;

public class Offre {

	private String idOffre;
	private String libelle;
	private String descriptif;
	private String domaine;
	private String dateDebut;
	private String duree;
	private String chemin;
	private String valide;
	private String entreprise;
	private String entEmail;
	
	
	public Offre(String idOffre, String entreprise, String libelle, String descriptif, String domaine, String dateDebut, String duree, String chemin, String valide, String entEmail) {
		this.setIdOffre(idOffre);
		this.libelle = libelle;
		this.descriptif = descriptif;
		this.domaine = domaine;
		this.dateDebut = dateDebut;
		this.duree = duree;
		this.chemin = chemin;
		this.valide = valide;
		this.entreprise = entreprise;
		this.entEmail = entEmail;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public String getDescriptif() {
		return descriptif;
	}


	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}


	public String getDomaine() {
		return domaine;
	}


	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}


	public String getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}


	public String getDuree() {
		return duree;
	}


	public void setDuree(String duree) {
		this.duree = duree;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public String getEntreprise() {
		return entreprise;
	}


	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}


	public String getValide() {
		return valide;
	}


	public void setValide(String valide) {
		this.valide = valide;
	}


	@Override
	public String toString() {
		return "Offre [libelle=" + libelle + ", descriptif=" + descriptif + ", domaine=" + domaine + ", dateDebut="
				+ dateDebut + ", duree=" + duree + ", chemin=" + chemin + ", valide=" + valide + ", entreprise="
				+ entreprise + "]";
	}


	public String getEntEmail() {
		return entEmail;
	}


	public void setEntEmail(String entEmail) {
		this.entEmail = entEmail;
	}


	public String getIdOffre() {
		return idOffre;
	}


	public void setIdOffre(String idOffre) {
		this.idOffre = idOffre;
	}
}
