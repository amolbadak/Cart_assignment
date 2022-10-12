package spring.boot.loan.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
//@Table(name="customer_amol")
public class Customer implements Serializable {

	
	//@GeneratedValue(strategy = GenerationType.AUTO)
	
	private String custname;
	private String custadd;
	@Id
	private String custemail;
	private String identity;
	private double annualincome;
	private String password;
	private boolean incometaxreturnattached;
	//@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//private List<Loan> loans=new ArrayList<Loan>();
	
	
	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getCustadd() {
		return custadd;
	}

	public void setCustadd(String custadd) {
		this.custadd = custadd;
	}

	public String getCustemail() {
		return custemail;
	}

	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public double getAnnualincome() {
		return annualincome;
	}

	public void setAnnualincome(double annualincome) {
		this.annualincome = annualincome;
	}

	public boolean isIncometaxreturnattached() {
		return incometaxreturnattached;
	}

	public void setIncometaxreturnattached(boolean incometaxreturnattached) {
		this.incometaxreturnattached = incometaxreturnattached;
	}


	
	
	
	@Override
	public String toString() {
		return "Customer [custname=" + custname + ", custadd=" + custadd + ", custemail=" + custemail + ", identity="
				+ identity + ", annualincome=" + annualincome + ", incometaxreturnattached=" + incometaxreturnattached
				+ "]";
	}

	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String custname, String custadd, String custemail, String identity, double annualincome,
			String password, boolean incometaxreturnattached) {
		super();
		this.custname = custname;
		this.custadd = custadd;
		this.custemail = custemail;
		this.identity = identity;
		this.annualincome = annualincome;
		this.password = password;
		this.incometaxreturnattached = incometaxreturnattached;
		
	}
	
}
