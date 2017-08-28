package springmvc_example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc_example.dao.CustomerDao;
import springmvc_example.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	CustomerDao customerDao;
	
	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
    
	public List<Customer> listAllCustomer() {
		return customerDao.listAllCustomer();
	}

	
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);

	}

	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);

	}


	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);

	}

	
	public Customer findCustomerById(int id) {
		return customerDao.findCustomerById(id);
	}

}
