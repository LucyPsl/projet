package fr.esic.solutec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the session_formation database table.
 * 
 */
@Entity
@Table(name="session_formation")
@NamedQuery(name="SessionFormation.findAll", query="SELECT s FROM SessionFormation s")
public class SessionFormation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_session_formation")
	private int idSessionFormation;

	@Temporal(TemporalType.DATE)
	@Column(name="date_debut")
	private Date dateDebut;

	@Temporal(TemporalType.DATE)
	@Column(name="date_fin")
	private Date dateFin;

	@Column(name="type_session")
	private String typeSession;

	//bi-directional many-to-many association to Stagiaire
	@ManyToMany(mappedBy="sessionFormations")
	private List<Stagiaire> stagiaires;

	//bi-directional many-to-many association to ContactSociete
	@ManyToMany
	@JoinTable(
		name="choisit"
		, joinColumns={
			@JoinColumn(name="id_session_formation")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_contact")
			}
		)
	private List<ContactSociete> contactSocietes;

	//bi-directional many-to-many association to SessionCursus
	@ManyToMany
	@JoinTable(
		name="contient_sc_sf"
		, joinColumns={
			@JoinColumn(name="id_session_formation")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_session_cursus")
			}
		)
	private List<SessionCursus> sessionCursuses;

	//bi-directional many-to-many association to Formateur
	@ManyToMany
	@JoinTable(
		name="dispense"
		, joinColumns={
			@JoinColumn(name="id_session_formation")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_formateur")
			}
		)
	private List<Formateur> formateurs;

	//uni-directional many-to-one association to Formation
	@ManyToOne
	@JoinColumn(name="id_formation")
	private Formation formation;

	public SessionFormation() {
	}

	public int getIdSessionFormation() {
		return this.idSessionFormation;
	}

	public void setIdSessionFormation(int idSessionFormation) {
		this.idSessionFormation = idSessionFormation;
	}

	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getTypeSession() {
		return this.typeSession;
	}

	public void setTypeSession(String typeSession) {
		this.typeSession = typeSession;
	}

	public List<Stagiaire> getStagiaires() {
		return this.stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public List<ContactSociete> getContactSocietes() {
		return this.contactSocietes;
	}

	public void setContactSocietes(List<ContactSociete> contactSocietes) {
		this.contactSocietes = contactSocietes;
	}

	public List<SessionCursus> getSessionCursuses() {
		return this.sessionCursuses;
	}

	public void setSessionCursuses(List<SessionCursus> sessionCursuses) {
		this.sessionCursuses = sessionCursuses;
	}

	public List<Formateur> getFormateurs() {
		return this.formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	public Formation getFormation() {
		return this.formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

}