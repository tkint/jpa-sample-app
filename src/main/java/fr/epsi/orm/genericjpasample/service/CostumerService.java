package fr.epsi.orm.genericjpasample.service;

import java.util.List;

import fr.epsi.orm.genericjpasample.dao.CostumerDAO;
import fr.epsi.orm.genericjpasample.entities.Customer;
import fr.epsi.orm.genericjpasample.managers.SimpleEntityManager;

/**
 * @author gabriel
 *
 * Oct 17, 2013
 */
public class CostumerService {
	private CostumerDAO dao;
	
	private SimpleEntityManager simpleEntityManager;
	
	public CostumerService(SimpleEntityManager simpleEntityManager){
		this.simpleEntityManager = simpleEntityManager;
		dao = new CostumerDAO(simpleEntityManager.getEntityManager());
	}
	
	public void save(Customer customer){
		try{
			simpleEntityManager.beginTransaction();
			customer.validate();
			dao.save(customer);
			simpleEntityManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}
	
	public List<Customer> findAll(){
		return dao.findAll();
	}
}
