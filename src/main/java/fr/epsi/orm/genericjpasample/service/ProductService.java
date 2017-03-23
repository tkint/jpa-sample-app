package fr.epsi.orm.genericjpasample.service;

import java.util.List;

import fr.epsi.orm.genericjpasample.dao.ProductDAO;
import fr.epsi.orm.genericjpasample.entities.Product;
import fr.epsi.orm.genericjpasample.managers.SimpleEntityManager;

/**
 * @author gabriel
 *
 * Oct 17, 2013
 */
public class ProductService {
	private ProductDAO dao;
	
	private SimpleEntityManager simpleEntityManager;
	
	public ProductService(SimpleEntityManager simpleEntityManager){
		this.simpleEntityManager = simpleEntityManager;
		dao = new ProductDAO(simpleEntityManager.getEntityManager());
	}
	
	public void save(Product product){
		try{
			simpleEntityManager.beginTransaction();
			product.validate();
			dao.save(product);
			simpleEntityManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}
	
	public List<Product> findAll(){
		return dao.findAll();
	}
}
