package spring.boot.loan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.loan.entity.Collateral;
import spring.boot.loan.repository.CollateralRepository;

@Service
public class CollateralService {

	@Autowired
	private CollateralRepository collateralRepository;

	
	public List<Collateral> getAllCollaterals() throws Exception
	{
		List<Collateral> collaterals = new ArrayList<Collateral>();
		this.collateralRepository.findAll().forEach(collateral-> collaterals.add(collateral));
		return collaterals;
	}

	public boolean addCollateral(Collateral collateral) throws Exception {

		try {
			if(this.collateralRepository.findById(collateral.getCollateralid()).isPresent())
			{
				return false;
			}
			this.collateralRepository.save(collateral);
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException("The id is null");
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return true;
	}
}
