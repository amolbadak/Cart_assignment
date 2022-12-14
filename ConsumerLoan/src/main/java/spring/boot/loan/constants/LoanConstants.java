package spring.boot.loan.constants;

import java.util.ArrayList;

import spring.boot.loan.entity.Collateral;
import spring.boot.loan.entity.Employee;

public class LoanConstants {

	
	
	public static final String LOAN_TYPE[]= {"Home","Vehicle","Education","Marriage","Hospitalization"};
	public static final String ID_TYPE[]= {"Passport", "Driving license","Aadhar Card"};
	public static final String LOANTABLE = "LOAN";
	public static final String CUSTOMERTABLE = "CUSTOMER";
	public static final String EMPLOYEETABLE = "EMPLOYEE";
	public static final String LOANCOLLATERALTABLE = "LOAN_COLLATERAL";
	public static final String COLLATERALTABLE = "COLLATERAL";

	
	 //List <COLLATERALTYPE> collate=new ArrayList<Collateral>();
	
	public LoanConstants() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static double calculateRate(double period)
	{
		if(period <=2)
			return 0.05;
		else if (period >2 && period <= 5)
			return 0.06;
		else if (period >5 && period <8)
			return 0.08;
		else
			return 0.085;
	}
	
	
}
