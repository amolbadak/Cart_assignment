package spring.boot.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.loan.entity.Collateral;
import spring.boot.loan.entity.Loan;
import spring.boot.loan.exception.EntityNotFoundException;
import spring.boot.loan.response.ResponsePage;
import spring.boot.loan.service.CollateralService;
import spring.boot.loan.service.LoanService;


@RestController
@RequestMapping("/loan")
public class LoanController {

	@Autowired
	private CollateralService collateralService;
	
	
	@Autowired
	private LoanService loanservice;
	
	@PostMapping("/{email}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Loan applyLoan(
		@RequestBody Loan loan, @PathVariable String email)
	{
		return this.loanservice.applyForLoan( loan.getLoantype(),
				loan.getLoanamount(), loan.getPeriod(), email);
	}
	
	@PostMapping("/upload/{loanid}")
	@ResponseStatus(code = HttpStatus.CREATED)
	
	public ResponseEntity<ResponsePage> uploadCollaterals(
			@PathVariable String loanid,  
			@RequestParam List<String> ids)
	{
		System.out.println(ids);
		System.out.println(loanid);
		 if(this.loanservice.uploadCollateral(loanid, ids))
			 return ResponseEntity.status(HttpStatus.CREATED)
					 .body(new ResponsePage(201, "Collaterals Updated"));
		 return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
				 .body(new ResponsePage(202, "Collaterals were not updated"));
	}
	@GetMapping("/{loanid}")
	public Loan getLoanById(@PathVariable String loanid)
	{
		try {
			return this.loanservice.findLoanById(loanid);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("/collateral")
	public ResponseEntity<ResponsePage> insertColateral(
			@RequestBody Collateral collateral) throws Exception
	{
		
			this.collateralService.addCollateral(collateral);
			return ResponseEntity.status(HttpStatus.CREATED).body(new ResponsePage(200, "Collateral inserted"));
		}
	
	@GetMapping("/collaterals")
	public List<Collateral> getAllCollaterals() throws Exception
	{
		return this.collateralService.getAllCollaterals();
	}
}
