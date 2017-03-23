package fr.epsi.orm.genericjpasample.dao;

import javax.persistence.EntityManager;

import fr.epsi.orm.genericjpasample.entities.Product;

/**
 * @author gabriel
 *
 * Oct 17, 2013
 */
public class ProductDAO extends GenericDAO<Long, Product> {
	public ProductDAO(EntityManager entityManager) {
		super(entityManager);
	}
}
