package spring.boot.loan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.boot.loan.entity.Collateral;


@Repository
public interface CollateralRepository extends CrudRepository<Collateral, String> {

}




