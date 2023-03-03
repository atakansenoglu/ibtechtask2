package operations;

import java.util.List;

import hibernate.model.Customer;

public class CustomerOperations {

	public void add(List<Customer> customerList, Customer customer) {
		customerList.add(customer);
	}
	
	public void update(List<Customer> customerList, Customer customer, int index) {
		customerList.set(index, customer);
	}
	
	public void delete(List<Customer> customerList, Customer customer) {
		customerList.remove(customer);
	}
}
