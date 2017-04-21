package gaoChen_project;
import java.io.*;
/* This class prompt for a choice of the user interface menu and get a valid choice.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */

public class GaoChen_validChoice {
	
	//method that accepts a num and returns true if the num is all digits false otherwise
	public boolean checkDigit(String num)
	{
		for (int i=0; i<num.length(); i++)
		{
			if (!Character.isDigit(num.charAt(i)))
				return false;
		}return true;
	}
	
	public void menu(){
		System.out.println();
		System.out.println("Enter your choice: ");
		System.out.println("1: new order");
		System.out.println("2: cancel your order");
		System.out.println("3: check your order");
		System.out.println("4: check all orders");
		System.out.println("5: check wings ordered so far");
		System.out.println("-1: exit");
	}

	public int valid_choice() {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String inputNum = "";
		int dig = 0;
		boolean done = false;
		menu();
		do {
			
			try {
				inputNum = in.readLine();
				//if (inputNum.length() <=2  && checkDigit(inputNum)) {
					 dig = Integer.parseInt(inputNum);
					 
				//}
				
			}catch (NumberFormatException n) {
				System.out.println("Could not convert to int. Please enter an integer");
			}catch (IOException e) {		
				System.out.println("Could not read input ");
			}
			if(dig<-1 || dig>5 || dig==0){
				System.out.println("Invalid input. Enter again.");
				
			}
			if(dig==-1 || (dig>=1 && dig<=5)){
				done=true;
			}
			
			
		} while (!done);
	
		return dig;
	}
}