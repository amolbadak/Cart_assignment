package spring.boot.loan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.loan.constants.LoanConstants;
import spring.boot.loan.entity.Collateral;
import spring.boot.loan.entity.Employee;
import spring.boot.loan.entity.Loan;
import spring.boot.loan.exception.EntityNotFoundException;
import spring.boot.loan.repository.CollateralRepository;
import spring.boot.loan.repository.CustomerRepository;
import spring.boot.loan.repository.EmployeeRepository;
import spring.boot.loan.repository.LoanRepository;

@Service
public class LoanService {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private CollateralRepository collateralRepository;
	
	public LoanService()
	{
		
	}
	
	
	public Loan findLoanById(String loanId) throws EntityNotFoundException
	{
		
		Optional<Loan> loan = loanRepository.findById(loanId);
		if(loan==null) {
			throw new EntityNotFoundException("Loan Proposal not found");
		}
		//loan.ifPresent(l -> Hibernate.initialize(l.getCollaterals()));
		return loan.get();
	}
	
	
	
	public boolean uploadCollateral(String loanId, List<String> collateralIds) 
	{
		Optional<Loan> loan = this.loanRepository.findById(loanId);
		System.out.println(collateralIds);
		if(!loan.isPresent()) {
			System.out.println("loan does not exist");
			return false;
		}
		loan.ifPresent(l->{
			List<Collateral> collaterals = new ArrayList<Collateral>();
			collateralIds.forEach(id->{
				collaterals.add(this.collateralRepository.findById(id).get());
			});
			System.out.println(collaterals);
			l.setCollaterals(collaterals);
			this.loanRepository.save(l);
		});
		return true;		
	}
	
	public Loan applyForLoan(String loanType,
			double loanAmount,
			double period, String email)
	{
		System.out.println("applying for loan");
		Loan loan = new Loan();
		loan.setCustomer(customerRepository.findById(email).get());
		System.out.println("loan customer");
		loan.setInterestrate(LoanConstants.calculateRate(period));
		loan.setPeriod(period);
		loan.setLoantype(loanType);
		loan.setLoanamount(loanAmount);
		int index = (int)(Math.random()* (employeeRepository.count()));
		System.out.println("index "+index);
		List<Employee> emps = new ArrayList<>();
		this.employeeRepository.findAll().forEach(emp->emps.add(emp));
		loan.setEmployee(emps.get(index));
		loan.setLoanid("SUVIDHA"+(this.loanRepository.count()+1)+"_"+email);
		loanRepository.save(loan);
		return loan;
	}
	
}
