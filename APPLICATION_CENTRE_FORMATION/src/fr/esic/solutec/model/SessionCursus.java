package fr.esic.solutec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the session_cursus database table.
 * 
 */
@Entity
@Table(name="session_cursus")
@NamedQuery(name="SessionCursus.findAll", query="SELECT s FROM SessionCursus s")
public class SessionCursus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_session_cursus")
	private int idSessionCursus;

	@Temporal(TemporalType.DATE)
	@Column(name="date_debut")
	private Date dateDebut;

	@Temporal(TemporalType.DATE)
	@Column(name="date_fin")
	private Date dateFin;

	private String nom;

	//bi-directional many-to-many association to SessionFormation
	@ManyToMany(mappedBy="sessionCursuses")
	private List<SessionFormation> sessionFormations;

	//uni-directional many-to-one association to Cursus
	@ManyToOne
	@JoinColumn(name="id_cursus")
	private Cursus cursus;

	public SessionCursus() {
	}

	public int getIdSessionCursus() {
		return this.idSessionCursus;
	}

	public void setIdSessionCursus(int idSessionCursus) {
		this.idSessionCursus = idSessionCursus;
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

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<SessionFormation> getSessionFormations() {
		return this.sessionFormations;
	}

	public void setSessionFormations(List<SessionFormation> sessionFormations) {
		this.sessionFormations = sessionFormations;
	}

	public Cursus getCursus() {
		return this.cursus;
	}

	public void setCursus(Cursus cursus) {
		this.cursus = cursus;
	}

}