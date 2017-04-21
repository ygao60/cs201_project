package gaoChen_project;

/* This class is to get all kinds of keyboard input of an order.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GaoChen_input {
	
	public boolean checkDigit(String num)
	{
		for (int i=0; i<num.length(); i++)
		{
			if (!Character.isDigit(num.charAt(i)))
				return false;
		}return true;
	}
	
	public String getName(){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String name="";
		boolean done = false;
		do{
		try{
			
		name=in.readLine();
		if("".equals(name.trim())){
			System.out.println("Your input is empty.Please enter again ");
		}
		else{
			done=true;
		}
		}catch (IOException e) {		
			System.out.println("Could not read input ");
		}
		}while(!done);
		return name;
		
	}
	
	public char getChar(){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str="";
		boolean done = false;
		char ch=' ';
		do{
		try{	
		str=in.readLine();
		if("".equals(str.trim())){
			System.out.println("Your input is empty. Please enter again ");
		}
		else if(str.length()>1){
			System.out.println("Invalid input. Please enter again ");
		}
		else{
			ch=str.charAt(0);
			done=true;
		}
		}catch (IOException e) {		
			System.out.println("Could not read input ");
		}
		}while(!done);
		return ch;
		
	}
	
	public String getAddr(){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String addr="";
		boolean done = false;
		do{
		try{
		addr=in.readLine();
		if("".equals(addr.trim())){
			System.out.println("Your input is empty.Please enter again ");
		}
		else{
			done=true;
		}
		}catch (IOException e) {		
			System.out.println("Could not read input ");
		}
		}while(!done);
		return addr;
		
	}
	
	public String getPhone(){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String phone = "";
		boolean done = false;
	
		do {
			
			try {
				phone = in.readLine();
				if (!checkDigit(phone)) {
					System.out.println("Invalid input. Please enter again");
				} 
				else if(phone.length()!=10){
					System.out.println("Invalid phone number. Must be 10 digits. Please enter again");
				}
				else{
					done=true;
				}
				
			}catch (NumberFormatException n) {
				System.out.println("Could not convert to int. Please enter an integer");
			}catch (IOException e) {		
				System.out.println("Could not read input ");
			}
		} while (!done);
	
		return phone;
	}
	
	
	public int getNumOfSet(){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String inputNum = "";
		int dig =0;
		boolean done = false;
	
		do {
			
			try {
				inputNum = in.readLine();
				if (!checkDigit(inputNum)) {
					System.out.println("Invalid input. Please enter an integer");
				} 
				else{
					dig = Integer.parseInt(inputNum);
					done=true;
				}
				
			}catch (NumberFormatException n) {
				System.out.println("Could not convert to int. Please enter an integer");
			}catch (IOException e) {		
				System.out.println("Could not read input ");
			}
		} while (!done);
	
		return dig;
	}
	
	public int getCoupon(){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String inputNum = "";
		int dig = -1;
		boolean done = false;
	
		do {
			
			try {
				inputNum = in.readLine();
			
				if(!checkDigit(inputNum)){
					System.out.println("Invalid input. Please enter again");
				}
				else{
				dig = Integer.parseInt(inputNum);
				}
			}catch (NumberFormatException n) {
				System.out.println("Could not convert to int. Please enter a int");
			}catch (IOException e) {		
				System.out.println("Could not read input ");
			}
			
			if(dig==0){
				System.out.println("Invalid input. Please enter a positive integer");
			}
			else if(dig>0){
				done=true;
			}
		} while (!done);
		return dig;
	}
	
	
	public String getTime(){
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String time="";
		int hour,min,dig;
		boolean done = false;
		do {
			try {
				time = in.readLine();
				if(time.length()!=4 || !checkDigit(time)){
					System.out.println("Invalid input. Please enter again");
					System.out.println("Please enter the delivery time in 24hr format (hhmm) (e.g. 1830):");
				}
				else{
					 dig = Integer.parseInt(time);
					 min=dig%100;
					 hour=dig/100;
					 if(hour>24){
						 System.out.println("Invalid input. Please enter again");
					 }
					 else if(min>60){
						 System.out.println("Invalid input. Please enter again");
					 }
					 else if(hour<8 || hour>22){
						 System.out.println("Sorry we only deliver from 0800 to 2200. Please enter again");
					 }
					 else{
						 done=true;
					 }
					 
				}
				
			}catch (NumberFormatException n) {
				System.out.println("Could not convert to int. Please enter an integer");
			}catch (IOException e) {		
				System.out.println("Could not read input ");
			}
			
		} while (!done);
		return time;
	}
	
	public String getDate(){
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String date="";
		int dig,day,month,year,temp;
		boolean done = false;
		do {
			try {
				date = in.readLine();
				if(date.length()!=8 || !checkDigit(date)){
					System.out.println("Invalid input. Please enter again");
				}
				else{
					 dig = Integer.parseInt(date);
					 day=dig%100;
					 temp=dig/100;
					 month=temp%100;
					 year=temp/100;
					 if(year<2000 ||year>2020 ){
						 System.out.println("Invalid input. Please enter again. Only from year 2000 to year 2020");
					 }
					 else if(month>12||month<1){
						 System.out.println("Invalid month. Please enter again.");
					 }
					 else if(day>31||day<1){
						 System.out.println("Invalid day. Please enter again.");
					 }
					 else if((month==4||month==6||month==9||month==11)&& day>30){
						 System.out.println("This month only has 30 days. Please enter again");
					 }
					 else if(month==2){
						 if((year%4==0 && year%100!=0)||(year%400==0)){
								 if(day>29){
									 System.out.println("This month in this year only has 29 days. Please enter again");
								 }
								 else{
									 done=true;
								 }
						}
						 else{
							 if(day>28){
								 System.out.println("This month in this year only has 28 days. Please enter again");
							 }
							 else{
								 done=true;
							 }
						 }
						 
					 }
					 else{
						 done=true;
					 }
					 
				}
				
			}catch (NumberFormatException n) {
				System.out.println("Could not convert to int. Please enter an integer");
			}catch (IOException e) {		
				System.out.println("Could not read input ");
			}
			
		} while (!done);
		return date;
	}

}
