package fr.esic.solutec.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private int idUser;

	private String login;

	private String password;

	@Column(name="type_user")
	private String typeUser;

	//uni-directional many-to-one association to ContactSociete
	@ManyToOne
	@JoinColumn(name="id_contact")
	private ContactSociete contactSociete;

	//uni-directional many-to-one association to EmployeCentre
	@ManyToOne
	@JoinColumn(name="id_employe")
	private EmployeCentre employeCentre1;

	//uni-directional many-to-one association to EmployeCentre
	@ManyToOne
	@JoinColumn(name="id_employe_employe_centre")
	private EmployeCentre employeCentre2;

	//uni-directional many-to-one association to Formateur
	@ManyToOne
	@JoinColumn(name="id_formateur")
	private Formateur formateur;

	//uni-directional many-to-one association to Stagiaire
	@ManyToOne
	@JoinColumn(name="id_stagiaire")
	private Stagiaire stagiaire;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTypeUser() {
		return this.typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public ContactSociete getContactSociete() {
		return this.contactSociete;
	}

	public void setContactSociete(ContactSociete contactSociete) {
		this.contactSociete = contactSociete;
	}

	public EmployeCentre getEmployeCentre1() {
		return this.employeCentre1;
	}

	public void setEmployeCentre1(EmployeCentre employeCentre1) {
		this.employeCentre1 = employeCentre1;
	}

	public EmployeCentre getEmployeCentre2() {
		return this.employeCentre2;
	}

	public void setEmployeCentre2(EmployeCentre employeCentre2) {
		this.employeCentre2 = employeCentre2;
	}

	public Formateur getFormateur() {
		return this.formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Stagiaire getStagiaire() {
		return this.stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

}