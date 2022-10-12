package spring.boot.loan.repository;

import org.springframework.data.repository.CrudRepository;

import spring.boot.loan.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
