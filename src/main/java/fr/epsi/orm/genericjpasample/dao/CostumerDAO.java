package fr.epsi.orm.genericjpasample.dao;

import javax.persistence.EntityManager;

import fr.epsi.orm.genericjpasample.entities.Customer;

/**
 * @author gabriel
 *
 * Oct 17, 2013
 */
public class CostumerDAO extends GenericDAO<Long, Customer> {
	public CostumerDAO(EntityManager entityManager) {
		super(entityManager);
	}
}
