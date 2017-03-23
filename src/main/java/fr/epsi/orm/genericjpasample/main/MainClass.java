package fr.epsi.orm.genericjpasample.main;

import fr.epsi.orm.genericjpasample.entities.Customer;
import fr.epsi.orm.genericjpasample.entities.Product;
import fr.epsi.orm.genericjpasample.managers.SimpleEntityManager;
import fr.epsi.orm.genericjpasample.service.CostumerService;
import fr.epsi.orm.genericjpasample.service.ProductService;

/**
 * @author gabriel
 *
 * Oct 17, 2013
 */
public class MainClass {
	public static void main(String[] args) {

		SimpleEntityManager simpleEntityManager = new SimpleEntityManager("pu");

		/**
		 * THE SERVICE LAYER ENCAPSULATES EVERY BEGIN/COMMIT/ROLLBACK
		 */
		CostumerService costumerService = new CostumerService(simpleEntityManager);
		ProductService productService = new ProductService(simpleEntityManager);
		
		costumerService.save(new Customer("test", "test"));
		costumerService.save(new Customer("test", "test"));
		costumerService.save(new Customer("test", "test"));
		costumerService.save(new Customer("test", "test"));
		
		for(Customer c : costumerService.findAll()){
			System.out.println(c.getName());
		}
		
		productService.save(new Product("test", "test"));
		productService.save(new Product("test", "test"));
		productService.save(new Product("test", "test"));
		productService.save(new Product("test", "test"));
		
		for(Product p : productService.findAll()){
			System.out.println(p.getName());
		}
		
		/**
		 * ALWAYS NEED TO BE CALLED!
		 */
		simpleEntityManager.close();
	}
}
