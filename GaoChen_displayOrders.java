package gaoChen_project;

/* This class display all existing orders.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */


public class GaoChen_displayOrders {
	public void showOrders(GaoChen_Sub_GenericList<GaoChen_ChickenDelivery> arr){
		
			GaoChen_ChickenDelivery anOrder;
			arr.reset();
			while(arr.hasNext()){
				anOrder=arr.getNext();
				System.out.println(anOrder.toString());
			}
		  
	}
}


