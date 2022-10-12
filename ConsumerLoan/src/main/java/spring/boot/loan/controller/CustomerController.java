package spring.boot.loan.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.loan.entity.Collateral;
import spring.boot.loan.entity.Customer;
import spring.boot.loan.entity.Employee;
import spring.boot.loan.response.ResponsePage;
import spring.boot.loan.service.CollateralService;
import spring.boot.loan.service.CustomerService;
import spring.boot.loan.service.EmployeeService;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CollateralService collateralService;
	

	@Autowired
	private EmployeeService employeeservice;
	
	@GetMapping("/{email}")
	public String details(HttpSession session)
	{
		System.out.println("rediect "+session.getAttribute("custemail"));
		return "customer";
	}
	

	
	@PostMapping("/cust")
	public ResponseEntity<ResponsePage> insertCustomer1(
			@RequestBody Customer customer) throws Exception
	{
			this.customerService.addCustomer(customer);
			return ResponseEntity.status(HttpStatus.CREATED).body(new ResponsePage(200, "Customer inserted"));
		
	}
	
	@PostMapping("/employee")
	public ResponseEntity<ResponsePage> insertEmployee(
			@RequestBody Employee employee) throws Exception
	{
			this.employeeservice.addEmployee(employee);
			return ResponseEntity.status(HttpStatus.CREATED).body(new ResponsePage(201, "Employee inserted"));
		
	}
	
	@PutMapping("/customerupdate")
	public ResponseEntity<ResponsePage> updateCustomer(
			@RequestBody Customer customer) throws Exception
	{
			this.customerService.updateCustomer(customer);
			return ResponseEntity.status(HttpStatus.CREATED).body(new ResponsePage(201, "Customer updated"));
	}
	
	@GetMapping("/emp/{empid}")
	public ResponseEntity<ResponsePage> approveLoans(@PathVariable String empid) throws Exception
	{
		
		this.employeeservice.approveLoan(empid);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponsePage(200, "Status Updated"));
	}
	
}
