package gaoChen_project;

/* This class is a subclass of ChickenDelivery. It encapsulate the orders with coupon.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */

import java.text.DecimalFormat;

public class GaoChen_E_Coupon extends GaoChen_ChickenDelivery {
	private int dollarOff;
	
	public GaoChen_E_Coupon() {
		super();
		dollarOff=5;
	}

	public GaoChen_E_Coupon(int off) {
		super();
		dollarOff=off;
	}
	
	public GaoChen_E_Coupon(String name1,String phone1,String add1,GaoChen_Time time1,GaoChen_Choice choice1,int off){
		super(name1,phone1,add1, time1,choice1);
		dollarOff=off;
	}
	
	public int getDollarOff(){
		return dollarOff;
	}
	
	public void setDollarOff(int off){
		dollarOff=off;
	}
	
	public boolean equals(GaoChen_E_Coupon couponOrder){
		return super.equals(couponOrder) && (dollarOff==couponOrder.getDollarOff());
	}
	
	public String toString(){
		DecimalFormat money = new DecimalFormat("$####.##");
		return super.toString()+",   coupon: "+money.format(dollarOff);
	}
	
	public double totPrice(){
		double num=super.totPrice()-dollarOff;
		if(num>=0){
			return num;
		}
		else{
			return 0.0;
		}
	}
}
