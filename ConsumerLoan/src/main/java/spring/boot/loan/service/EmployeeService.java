package spring.boot.loan.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.loan.entity.Customer;
import spring.boot.loan.entity.Employee;
import spring.boot.loan.entity.Loan;
import spring.boot.loan.repository.CustomerRepository;
import spring.boot.loan.repository.EmployeeRepository;
import spring.boot.loan.repository.LoanRepository;

@Service
public class EmployeeService {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private LoanRepository loanRepository;
	
	
	public EmployeeService()
	{
		
	}
	
	public void approveLoan(String eid) throws Exception {

		if(searchEmployeeById(eid)) {

			List<Loan> loans = loanRepository.findAllByEmployeeEmployeeId(eid);
			if(loans.size()>0) {
				for(Loan loan:loans) {
					Customer customer = loan.getCustomer();
					System.out.println("get collaterals "+loan.getCollaterals());
					if(loan.getLoanamount() > (10 * customer.getAnnualincome())) {
						loan.setRemarks("Loan amount cannot be 10 times of annual income");
						loan.setIsapproved(false);
						this.loanRepository.save(loan);
						
					}
					else if(loan.getCollaterals() == null || loan.getCollaterals().size() == 0) {
						loan.setRemarks( "No collateral submitted");
						loan.setIsapproved(false);
						this.loanRepository.save(loan);
						
					}
					else if(!customer.isIncometaxreturnattached()) {
						loan.setRemarks( "Income proof not attached");
						loan.setIsapproved(false);
						this.loanRepository.save(loan);
						
					}
					else if(customer.getIdentity() == null) {
						loan.setRemarks( "Identity document not submitted");
						loan.setIsapproved(false);
						this.loanRepository.save(loan);
						
					}
					else
					{
						loan.setRemarks( "Approved");
						loan.setIsapproved(true);
						
						this.loanRepository.save(loan);
						
					}
				}
			}
			else {
				throw new Exception("No loan proposals against this employee id");
			}
		}
		else
			throw new EntityNotFoundException("Employee does not exist");
	}
	
	
	
	
	
	
	
	public boolean searchEmployeeById(String empid) throws Exception
{
	try {
		if(this.employeeRepository.findById(empid).isPresent())
			return true;
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
	
	
	

public boolean addEmployee(Employee employee) throws Exception {

	try {
		if(this.searchEmployeeById(employee.getEmployeeId()))
		{
			return false;
		}
		this.employeeRepository.save(employee);
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
	
	}
	
	


