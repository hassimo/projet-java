package fr.univ.evry.factory;

public class Entreprise {

	private String idEntreprise;
	private String reseau;
	private String ville;
	private String rue;
	private String codePostal;
	private String tel;
	private String secteur;
	private String mail;
	
	public Entreprise (String idEntreprise, String reseau, String ville, String rue, String codePostal, String tel, String secteur, String mail) {
		this.idEntreprise = idEntreprise;
		this.reseau = reseau;
		this.ville = ville;
		this.rue = rue;
		this.codePostal = codePostal;
		this.tel = tel;
		this.secteur = secteur;
		this.mail = mail;
	}

	public String getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(String idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public String getReseau() {
		return reseau;
	}

	public void setReseau(String reseau) {
		this.reseau = reseau;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Entreprise [idEntreprise=" + idEntreprise + ", reseau=" + reseau + ", ville=" + ville + ", rue=" + rue
				+ ", codePostal=" + codePostal + ", tel=" + tel + ", secteur=" + secteur + ", mail=" + mail + "]";
	}
}
