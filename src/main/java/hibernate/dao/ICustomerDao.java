package hibernate.dao;

import java.util.List;

import hibernate.model.Account;
import hibernate.model.Customer;

public interface ICustomerDao {
	
	void save(Customer customer);
	void update(Customer customer);
	void delete(Customer customer);
	Customer getById(long id);
	List<Customer> getAll();
	void addAccount(Customer customer, Account account);
	void removeAccount(Customer customer, Account account);
	
}
