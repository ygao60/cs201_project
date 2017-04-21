package gaoChen_project;

/* This class encapsulate an order.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */


import java.text.DecimalFormat;


public class GaoChen_ChickenDelivery implements Comparable<GaoChen_ChickenDelivery >  {

	private String name;
	private GaoChen_Time time;
	private String addr;
	private String phone;
	private GaoChen_Choice choice;
	
	public GaoChen_ChickenDelivery() {
		name="Jane";
		time=new GaoChen_Time();
		addr="300 west 31st street";
		phone="31200988232";
		choice=new GaoChen_Choice();
	}
	
	
	public GaoChen_ChickenDelivery(String name1,String phone1,String add1,GaoChen_Time time1,GaoChen_Choice choice1){
		name = name1;
		time = time1;
		addr=add1;
		phone = phone1;
		choice = choice1;	
	}
	
	public String getName(){
		return name;
	}
	
	public GaoChen_Time getTime(){
		return time;
	}
	
	public String getAddr(){
		return addr;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public GaoChen_Choice getChoice(){
		return choice;
	}
	
	public void setName(String name1){
		name=name1;
	}
	
	public void setTime(GaoChen_Time time1){
		time=time1;
	}
	
	public void setAddr(String add1){
		addr=add1;
	}
	
	public void setPhone(String phone1){
		phone=phone1;
	}
	
	public void setChoice(GaoChen_Choice choice1){
		choice=choice1;
	}
	
	public String toString(){
		DecimalFormat money = new DecimalFormat("$####.##");	
		return name + ", " + phone + ", " + addr + ", " + time.toString()+", "+
		choice.toString()+"\n"+",  total price: "+money.format(totPrice())+ ", total "+totChickenWings()+" chicken wings";
	}
	
	public boolean equals(GaoChen_ChickenDelivery order1){
		return name.equals(getName()) && phone.equals(order1.getPhone()) && addr.equals(getAddr())
				&& time.equals(order1.getTime()) && choice.equals(order1.getChoice());
	}
	
	public int compareTo(GaoChen_ChickenDelivery order1){
		return time.compareTo(order1.getTime());
	}
	
	public double totPrice(){
		double result = 0;
		GaoChen_Prices prices=new GaoChen_Prices();
		result = choice.getNumOfA() *prices.getPriceOfA()
				+choice.getNumOfB() * prices.getPriceOfB()
				+choice.getNumOfC() * prices.getPriceOfC(); 
		return result;
	}
	
	public boolean under50Dollar(){
		return (totPrice()<50);
	}
	
	public int totChickenWings(){
		GaoChen_NumOfWings wings=new GaoChen_NumOfWings();
		return choice.getNumOfA() * wings.getNumOfWingsA()
				+choice.getNumOfB() * wings.getNumOfWingsB()
				+choice.getNumOfC() * wings.getNumOfWingsC(); 
	}
}
