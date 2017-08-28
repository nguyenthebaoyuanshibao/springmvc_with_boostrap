package springmvc_example.dao;

import java.util.List;

import springmvc_example.model.Customer;

public interface CustomerDao {
	
	public List<Customer> listAllCustomer();
	
	public void addCustomer(Customer customer);
	
	public void deleteCustomer(int id);
	
	public void updateCustomer(Customer customer);
	
	public Customer findCustomerById(int id);

}
