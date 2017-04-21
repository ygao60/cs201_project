package gaoChen_project;

/* This class show a menu of prices and chicken wings to customers.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */

public class GaoChen_menu {

	public void showMenu(){
		GaoChen_Prices price=new GaoChen_Prices();
		GaoChen_NumOfWings wings=new GaoChen_NumOfWings();
		System.out.println(price.toString());
		System.out.println(wings.toString());
	}
}
