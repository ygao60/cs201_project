package gaoChen_project;

/* This class add an order to the existing orders. It then sort all the orders by delivery time.
 * And it write to output files.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */

import java.text.DecimalFormat;



public class GaoChen_addOrder {
	public void addAnOrder(GaoChen_Sub_GenericList<GaoChen_ChickenDelivery> allOrder1,GaoChen_Sub_GenericList<GaoChen_WingsPerDay> allWing1){
	
		GaoChen_input allInput=new GaoChen_input();
		String date,name,phone,addr,time;
		char coupon;
		int a,b,c,wing1;
		int dollarOff=0;
		boolean enough1,flag;
		System.out.println("Enter the date you want to order (yyyymmdd): \nonly from year 2000 to year 2020  ");
		
		date=allInput.getDate();
		GaoChen_calcWings calc_wing=new GaoChen_calcWings();

		GaoChen_wingsLeft wings=new GaoChen_wingsLeft(date,allWing1);
		GaoChen_ChickenDelivery order=new GaoChen_ChickenDelivery();
		GaoChen_WingsPerDay wingDay;
		GaoChen_WingsArr wingArr=new GaoChen_WingsArr();
	
		
		GaoChen_Choice choice1=new GaoChen_Choice();
		GaoChen_Time time1;
		if(wings.checkEmpty()){
			System.out.println("Sorry "+date+" is fully booked. Please choose another day.");
		}
		else{
			GaoChen_menu menu1=new GaoChen_menu();
			menu1.showMenu();
			System.out.println("Please enter your choice:");
			System.out.println("How many set A do you want? Please enter a number.");
			a=allInput.getNumOfSet();
			System.out.println("How many set B do you want? Please enter a number.");
			b=allInput.getNumOfSet();
			System.out.println("How many set C do you want? Please enter a number.");
			c=allInput.getNumOfSet();
			choice1=new GaoChen_Choice(a,b,c);
			wing1=calc_wing.calc_wing(choice1);
			enough1=wings.checkEnough(wing1);
			if(!enough1){
				System.out.println("Sorry there is not enough wings on "+date);
				System.out.println(wings.toString());
				System.out.println("Please order again.");
			}
			else{
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
					System.out.println("Do you have a coupon? y/n");
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
				if(order.under50Dollar()){
					System.out.println(order.toString());
					System.out.println("Sorry, we only deliver when your total price is 50 dollars or more. Please order again.");
				}
				else{
				wingDay=new GaoChen_WingsPerDay(date,wing1);
				wingArr.add(allWing1, wingDay);
				DecimalFormat money = new DecimalFormat("$####.##");
				
				allOrder1.add(order);
				allOrder1.selectSort();
				allWing1.selectSort();
				System.out.println(order.toString());
				System.out.println("Your total price is :"+money.format(order.totPrice()));
				
				GaoChen_outFileOrder out1=new GaoChen_outFileOrder();
				out1.writeFile(allOrder1);
				GaoChen_outFileWing out2=new GaoChen_outFileWing();
				out2.writeFile(allWing1);	
				
				}
			}
		}
	

	}	

}
