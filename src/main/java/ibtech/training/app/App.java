package ibtech.training.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ibtech.training.dao.AccountDao;
import ibtech.training.dao.CustomerDao;
import ibtech.training.model.AccountModel;
import ibtech.training.model.CustomerModel;

public class App {

	public static void main(String[] args) {

	    // Create entity manager factory and entity manager
	    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();

	    // Create customer DAO and save a customer
	    CustomerDao customerDao = new CustomerDao(entityManager);

	    CustomerModel customer = new CustomerModel();
	    customer.setName("Atakan Şenoğlu");

	    customerDao.save(customer);
	    
	    // Create account DAO and save some accounts
	    AccountDao accountDAO = new AccountDao(entityManager);

	    AccountModel account1 = new AccountModel("123-456-789", customer);
	    AccountModel account2 = new AccountModel("111-222-333", customer);

	    accountDAO.save(account1);
	    accountDAO.save(account2);
	    
	    // Associate accounts with the customer
	    customerDao.addAccount(customer, account1);
	    customerDao.addAccount(customer, account2);

	    // Retrieve customer and print its associated accounts
	    customer = customerDao.getById(customer.getId());
	    
	    // Retrieve a customer and set its name
	    // retrievedCustomer.setName("John Doe");

	    System.out.println("CustomerModel: " + customer.getName());

	    for (AccountModel account : customer.getAccounts()) {
	        System.out.println("AccountModel: " + account.getAccountNumber());
	    }

	    // Close entity manager and factory
	    entityManager.close();
	    entityManagerFactory.close();
	}


}