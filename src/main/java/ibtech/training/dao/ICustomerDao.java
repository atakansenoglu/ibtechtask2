package ibtech.training.dao;

import java.util.List;

import ibtech.training.model.CustomerModel;
import ibtech.training.model.AccountModel;

public interface ICustomerDao {
	
	void save(CustomerModel customer);
	void update(CustomerModel customer);
	void delete(CustomerModel customer);
	CustomerModel getById(long id);
	List<CustomerModel> getAll();
	void addAccount(CustomerModel customer, AccountModel account);
	void removeAccount(CustomerModel customer, AccountModel account);
	
}