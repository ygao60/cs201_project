package gaoChen_project;

/* This class cancel an order of the existing orders. 
 * And it write to output files.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */


public class GaoChen_cancelOrder {
	
	public void cancelAnOrder(GaoChen_Sub_GenericList<GaoChen_ChickenDelivery> allOrder1,GaoChen_Sub_GenericList<GaoChen_WingsPerDay> allWing1){
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
				int pos=allOrder1.isThere(order);
				if(pos>=0){
					System.out.println("Yes. We found your order");
					flag=false;
					
					char cancel1;
					GaoChen_WingsPerDay wingDay;
					GaoChen_WingsArr wingArr=new GaoChen_WingsArr();
					while(!flag){
						System.out.println("Do you want to cancel it? y/n");
						cancel1=allInput.getChar();
						switch (cancel1){
						case 'y':
						case 'Y':  allOrder1.delete(pos);
								wingDay=new GaoChen_WingsPerDay(order.getTime().getDate(),order.totChickenWings());
								wingArr.delete(allWing1, wingDay);
								flag=true;
								System.out.println("you have cancelled it");
								GaoChen_outFileOrder out1=new GaoChen_outFileOrder();
								out1.writeFile(allOrder1);
								GaoChen_outFileWing out2=new GaoChen_outFileWing();
								out2.writeFile(allWing1);	
								
								break;
						case 'n':
						case 'N':  flag=true;
							break;
						default:   System.out.println("Invalid choice. Please enter again");
						}
					}
				}
				else{
					System.out.println("Sorry. We cannot find your order");
				}
				
		
		/*GaoChen_input allInput=new GaoChen_input();
	
		String phone;
		boolean flag;
		char cancel1;
		
		GaoChen_WingsPerDay wingDay;
		GaoChen_WingsArr wingArr=new GaoChen_WingsArr();
		System.out.println("Enter your phone number");
		phone=allInput.getPhone();
		allOrder1.reset();
		GaoChen_ChickenDelivery order1;
		boolean record=false;
		while(allOrder1.hasNext()){
			order1=(GaoChen_ChickenDelivery)allOrder1.getNext();
			if(order1.getPhone().equals(phone)){
				record=true;
				System.out.println(order1.toString());
				flag=false;
				while(!flag){
					System.out.println("Do you want to cancel it? y/n");
					cancel1=allInput.getChar();
					switch (cancel1){
					case 'y':
					case 'Y':  allOrder1.delete(order1);
							wingDay=new GaoChen_WingsPerDay(order1.getTime().getDate(),order1.totChickenWings());
							wingArr.delete(allWing1, wingDay);
							flag=true;
							System.out.println("you have cancelled it");
							GaoChen_outFileOrder out1=new GaoChen_outFileOrder();
							out1.writeFile(allOrder1);
							GaoChen_outFileWing out2=new GaoChen_outFileWing();
							out2.writeFile(allWing1);	
							
							break;
					case 'n':
					case 'N':  flag=true;
						break;
					default:   System.out.println("Invalid choice. Please enter again");
					}
				}
			}
		}
		if(!record){
			System.out.println("You don't have any order.");
		}
		*/
	}
}
