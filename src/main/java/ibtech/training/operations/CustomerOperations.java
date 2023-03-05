package ibtech.training.operations;
import java.util.List;

import ibtech.training.model.CustomerModel;

public class CustomerOperations {

	public void add(List<CustomerModel> customerList, CustomerModel customer) {
		customerList.add(customer);
	}
	
	public void update(List<CustomerModel> customerList, CustomerModel customer, int index) {
		customerList.set(index, customer);
	}
	
	public void delete(List<CustomerModel> customerList, CustomerModel customer) {
		customerList.remove(customer);
	}
}