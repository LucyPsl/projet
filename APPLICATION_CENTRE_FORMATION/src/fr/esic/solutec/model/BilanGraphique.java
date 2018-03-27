package fr.esic.solutec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bilan_graphique database table.
 * 
 */
@Entity
@Table(name="bilan_graphique")
@NamedQuery(name="BilanGraphique.findAll", query="SELECT b FROM BilanGraphique b")
public class BilanGraphique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_bilan")
	private int idBilan;

	//uni-directional many-to-one association to EmployeCentre
	@ManyToOne
	@JoinColumn(name="id_employe")
	private EmployeCentre employeCentre;

	//bi-directional many-to-many association to ContactSociete
	@ManyToMany(mappedBy="bilanGraphiques")
	private List<ContactSociete> contactSocietes;

	public BilanGraphique() {
	}

	public int getIdBilan() {
		return this.idBilan;
	}

	public void setIdBilan(int idBilan) {
		this.idBilan = idBilan;
	}

	public EmployeCentre getEmployeCentre() {
		return this.employeCentre;
	}

	public void setEmployeCentre(EmployeCentre employeCentre) {
		this.employeCentre = employeCentre;
	}

	public List<ContactSociete> getContactSocietes() {
		return this.contactSocietes;
	}

	public void setContactSocietes(List<ContactSociete> contactSocietes) {
		this.contactSocietes = contactSocietes;
	}

}