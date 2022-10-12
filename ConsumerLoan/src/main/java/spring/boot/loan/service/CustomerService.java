package spring.boot.loan.service;

import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.loan.entity.Customer;
import spring.boot.loan.repository.CustomerRepository;

@Service
public class CustomerService {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public CustomerService()
	{
		
	}
	
	public Customer findCustomerByEmail(String email) throws Exception
	{
		Customer customer = null;
		try {

			Optional<Customer> opt = this.customerRepository.findById(email);
			if(opt.isPresent())
				customer = opt.get();
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException("Email cannot be null, Please provide ID");
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return customer;

	}
	
	public boolean addCustomer(Customer customer) throws Exception {

		try {
			if(this.customerRepository.findById(customer.getCustemail()).isPresent())
			{
				return false;
			}
			this.customerRepository.save(customer);
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException(e);
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return true;
	}
	
	public boolean updateCustomer(Customer customer) throws Exception {

		try {
			if(this.customerRepository.findById(customer.getCustemail()).isPresent())
			{
				this.customerRepository.save(customer);
				return true;
			}	
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException(e);
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return false;
	}

}
		
	
//	@Transactional
//	public Customer addCustomer(Customer customer) {
//		
//		Address savedAddress = this.addressRepository.save(employee.getAddress());
//		employee.setAddress(savedAddress);
//		Employee savedEmployee = this.employeeRepository.save(employee);
//		return savedEmployee;
//	}
	
//	public boolean save(Customer customer) {
//
//		if(this.customerRepository.existsById(customer.getCid()))
//		{
//				throw new EntityExistsException("Employee with "+customer.getCid()+" already exists");
//		}
//		this.customerRepository.save(customer);
//		return true;
//		
//	}
	
	
	
	

