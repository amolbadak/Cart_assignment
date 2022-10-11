package spring.boot.loan.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@Getter
@Setter
@Entity
//@Table(name="collateral_amol")

public class Collateral implements Serializable{

	@Id
	private String collateralid;
	private String colletraltype;
	
	
	public String getCollateralid() {
		return collateralid;
	}


	public void setCollateralid(String collateralid) {
		this.collateralid = collateralid;
	}


	public String getColletraltype() {
		return colletraltype;
	}


	public void setColletraltype(String colletraltype) {
		this.colletraltype = colletraltype;
	}


	@Override
	public String toString() {
		return "Collateral [collateralid=" + collateralid + ", colletraltype=" + colletraltype + "]";
	}


	public Collateral(String collateralid, String colletraltype) {
		super();
		this.collateralid = collateralid;
		this.colletraltype = colletraltype;
	}


	public Collateral() {
		super();
		// TODO Auto-generated constructor stub
	}
}
