package gaoChen_project;

/* This class is the user interface.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */

public class GaoChen_takeOrder {
	
	public void userMenu(GaoChen_Sub_GenericList<GaoChen_ChickenDelivery> allOrder) {	
		GaoChen_WingsArr wing1=new GaoChen_WingsArr();
		GaoChen_Sub_GenericList<GaoChen_WingsPerDay> allWing=wing1.createWingArr(allOrder);
		GaoChen_addOrder add1=new GaoChen_addOrder();
		GaoChen_cancelOrder cancel1=new GaoChen_cancelOrder();
		GaoChen_checkOrder check1=new GaoChen_checkOrder();
		GaoChen_validChoice getChoice=new GaoChen_validChoice();
		GaoChen_displayOrders displayOrder=new GaoChen_displayOrders();
		GaoChen_displayWings displayWing=new GaoChen_displayWings();
		int choice1;
		
		boolean flag=false;
		
		while(!flag){
			
			choice1=getChoice.valid_choice();
			switch (choice1){
				case 1: add1.addAnOrder(allOrder,allWing); 
				displayOrder.showOrders(allOrder);
				 displayWing.showWings(allWing);
				break;
				case 2: cancel1.cancelAnOrder(allOrder,allWing);
				displayOrder.showOrders(allOrder);
				 displayWing.showWings(allWing);
				 break;
				case 3: check1.checkAnOrder(allOrder); break;
				case 4:  displayOrder.showOrders(allOrder); break;
				case 5:  displayWing.showWings(allWing); break;
				case -1: flag=true; System.out.println("exit"); break;
				default: System.out.println("Not a valid choice. Please enter an integer between -1 to 3");
			}
		}	
	}

}
