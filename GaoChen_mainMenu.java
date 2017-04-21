package gaoChen_project;
/*This application is a chicken wings online order system. The chicken wings restaurant provide three
 *  kinds of options: set A, set B, set C. Each set has different price and contain different amount 
 *  of chicken wings. The customers can order online and the chicken wings restaurant will deliver 
 *  the food to the address and time assigned by the customer. A customer need to input how many of
 *  each set he want, his name and phone number, his address, and the day and time he want the food
 *  delivered to the address. The interface will ask whether the customer has E-coupon. The customer
 *  can enter the amount of E-coupon they have. The system will then show the total Price of the
 *  order. The restaurant can sort all the orders by the delivery time, from the earliest to the
 *  latest. The restaurant will only deliver if the order is equal to or above 50 dollars. The
 *  system will show that the order is not valid if the total price is below 50 dollars. The
 *  restaurant will sell no more than 1000 chicken wings each day. The customer can choose whether
 *  they want to make an order, cancel an order, confirm an order, see existing orders or see the
 *  number of chicken wings ordered on each day so that they will know whether there is enough
 *  chicken wings on the day they want it. The input data are the existing delivery orders. 
 *  This class is where main() is in. It read an input file and then pass to menu.
 * We use one arraylist to save all the orders and another arraylist to save all the chicken wings ordered in each day.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */

public class GaoChen_mainMenu {

	public static void main(String[] args) {
		GaoChen_readFile read1=new GaoChen_readFile();
		GaoChen_Sub_GenericList<GaoChen_ChickenDelivery> order=read1.read("GaoChen_orders.txt");
		GaoChen_takeOrder user=new GaoChen_takeOrder();
		user.userMenu(order);
	}

}
