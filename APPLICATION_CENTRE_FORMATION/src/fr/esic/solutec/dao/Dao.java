package fr.esic.solutec.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {

	private static final String JPA_UNIT_NAME = "APPLICATION_CENTRE_FORMATION";
	static protected EntityManagerFactory emf = 
	Persistence.createEntityManagerFactory(JPA_UNIT_NAME);
	static protected EntityManager em = emf.createEntityManager(); 
	static public void close(){
	em.close();
	emf.close();
	}
	
}
	

