package spring.boot.loan.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@Table(name="loan_amol")
public class Loan implements Serializable{

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String loanid;
	private String loantype;
	private double loanamount;
	private double interestrate;
	private double period;
	private boolean isapproved=false;
	private String remarks;
	@OneToOne
	@JoinColumn(name = "customer_email")
	private Customer customer;
	@OneToOne
	@JoinColumn(name="empid")
	private Employee employee;
	@ManyToMany() 
	@JoinTable(
			name= "LOAN_COLLATERAL",
			joinColumns = { @JoinColumn(name = "loanid") }, 
			inverseJoinColumns = { @JoinColumn(name = "collateralid") }
			)
	private List<Collateral> collaterals;
	
	
	
	
	
	public Loan(String loanid, String loantype, double loanamount, double interestrate, double period,
			boolean isapproved, String remarks) {
		super();
		this.loanid = loanid;
		this.loantype = loantype;
		this.loanamount = loanamount;
		this.interestrate = interestrate;
		this.period = period;
		this.isapproved = isapproved;
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Loan [loanid=" + loanid + ", loantype=" + loantype + ", loanamount=" + loanamount + ", interestrate="
				+ interestrate + ", period=" + period + ", isapproved=" + isapproved + ", remarks=" + remarks + "]";
	}

	public String getLoanid() {
		return loanid;
	}

	public void setLoanid(String loanid) {
		this.loanid = loanid;
	}

	public String getLoantype() {
		return loantype;
	}

	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}

	public double getLoanamount() {
		return loanamount;
	}

	public void setLoanamount(double loanamount) {
		this.loanamount = loanamount;
	}

	public double getInterestrate() {
		return interestrate;
	}

	public void setInterestrate(double interestrate) {
		this.interestrate = interestrate;
	}

	public double getPeriod() {
		return period;
	}

	public void setPeriod(double period) {
		this.period = period;
	}

	public boolean isIsapproved() {
		return isapproved;
	}

	public void setIsapproved(boolean isapproved) {
		this.isapproved = isapproved;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
