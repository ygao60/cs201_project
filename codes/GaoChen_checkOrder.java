package gaoChen_project;


/* This class check an order of the existing orders. 
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */

public class GaoChen_checkOrder {
	public void checkAnOrder(GaoChen_Sub_GenericList<GaoChen_ChickenDelivery> allOrder1){
		GaoChen_input allInput=new GaoChen_input();
		String date,name,phone,addr,time;
		char coupon;
		int a,b,c;
		int dollarOff=0;
		boolean flag;
		System.out.println("Enter your delivery date (yyyymmdd):");
		
		date=allInput.getDate();
		
		GaoChen_ChickenDelivery order=new GaoChen_ChickenDelivery();
		
		GaoChen_Choice choice1=new GaoChen_Choice();
		GaoChen_Time time1;
		
			
			System.out.println("Please enter your choice:");
			System.out.println("How many set A did you order? Please enter a number.");
			a=allInput.getNumOfSet();
			System.out.println("How many set B did you order? Please enter a number.");
			b=allInput.getNumOfSet();
			System.out.println("How many set C did you order? Please enter a number.");
			c=allInput.getNumOfSet();
			choice1=new GaoChen_Choice(a,b,c);
			
				System.out.println("Please enter your name");
				name=allInput.getName();
				System.out.println("Please enter your 10-digit phone number");
				phone=allInput.getPhone();
				System.out.println("Please enter your address");
				addr=allInput.getAddr();
				System.out.println("Please enter the delivery time in 24hr format (hhmm) (e.g. 1830):  \nWe only deliver from 0800 to 2200");
				time=allInput.getTime();
				time1=new GaoChen_Time(date,time);
				flag=false;
				while(!flag){
					System.out.println("Did you use a coupon? y/n");
					coupon=allInput.getChar();
					switch (coupon){
					case 'y':
					case 'Y':  System.out.println("Enter your coupon amount: ");
							dollarOff=allInput.getCoupon();
						
							flag=true;
							order=new GaoChen_E_Coupon(name,phone,addr,time1,choice1,dollarOff);
							break;
					case 'n':
					case 'N':  flag=true; 
								order=new GaoChen_ChickenDelivery(name,phone,addr,time1,choice1);
								break;
					default:   System.out.println("Invalid choice. Please enter again");
					}
				}
				if(allOrder1.isThere(order)>=0){
					System.out.println("Yes. We found your order");
				}
				else{
					System.out.println("Sorry. We cannot find your order");
				}
				
		}

		/*GaoChen_input allInput=new GaoChen_input();
		String phone;
		System.out.println("Enter your phone number");
		phone=allInput.getPhone();
	
		allOrder1.reset();
		boolean flag=false;
		GaoChen_ChickenDelivery order1;
		System.out.println("Here is your orders: ");
		while(allOrder1.hasNext()){
			order1=(GaoChen_ChickenDelivery)allOrder1.getNext();
			if(order1.getPhone().equals(phone)){
				System.out.println(order1.toString());
				flag=true;
			}
		}
		if(!flag){
			System.out.println("You don't have any order");
		}
		*/
		
}

