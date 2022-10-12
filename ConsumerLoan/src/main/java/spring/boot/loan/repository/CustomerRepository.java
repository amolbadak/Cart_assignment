package spring.boot.loan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.boot.loan.entity.Customer;


@Repository

public interface CustomerRepository extends  CrudRepository<Customer, String>{

}


