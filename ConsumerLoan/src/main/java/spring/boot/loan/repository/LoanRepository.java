package spring.boot.loan.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import spring.boot.loan.entity.Loan;

public interface LoanRepository extends CrudRepository<Loan, String>{

	public List<Loan> findAllByEmployeeEmployeeId(String empid);
}
