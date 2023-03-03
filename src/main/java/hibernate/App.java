package hibernate;

import hibernate.dao.CustomerDao;
import hibernate.model.Customer;
import hibernate.dao.AccountDao;
import hibernate.model.Account;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	public static void main(String[] args) {

	    // Create entity manager factory and entity manager
	    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();

	    // Create customer DAO and save a customer
	    CustomerDao customerDao = new CustomerDao(entityManager);

	    Customer customer = new Customer();
	    customer.setName("Atakan Şenoğlu");

	    customerDao.save(customer);
	    
	    // Create account DAO and save some accounts
	    AccountDao accountDAO = new AccountDao(entityManager);

	    Account account1 = new Account("123456789", customer);
	    Account account2 = new Account("987654321", customer);

	    accountDAO.save(account1);
	    accountDAO.save(account2);
	    
	    Customer retrievedCustomer = customerDao.getById(1);
	    retrievedCustomer.setName("John Doe");
	    
	    // Associate accounts with the customer
	    customerDao.addAccount(customer, account1);
	    customerDao.addAccount(customer, account2);

	    // Retrieve customer and print its associated accounts
	    customer = customerDao.getById(customer.getId());

	    System.out.println("Customer: " + customer.getName());

	    for (Account account : customer.getAccounts()) {
	        System.out.println("Account: " + account.getAccountNumber());
	    }

	    // Close entity manager and factory
	    entityManager.close();
	    entityManagerFactory.close();
	}


}
