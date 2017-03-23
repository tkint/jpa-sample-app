package fr.epsi.orm.genericjpasample.service;

import java.util.List;

import fr.epsi.orm.genericjpasample.dao.CostumerDAO;
import fr.epsi.orm.genericjpasample.entities.Costumer;
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
	
	public void save(Costumer costumer){
		try{
			simpleEntityManager.beginTransaction();
			costumer.validate();
			dao.save(costumer);
			simpleEntityManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}
	
	public List<Costumer> findAll(){
		return dao.findAll();
	}
}
