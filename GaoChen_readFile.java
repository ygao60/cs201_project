package gaoChen_project;
/* This class read an input file of existing orders and then sort the orders.
 * Then it write all the sorted orders to an output file.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */

import java.io.FileReader;

import java.util.Scanner;
import java.io.FileNotFoundException;



public class GaoChen_readFile {

	public GaoChen_Sub_GenericList<GaoChen_ChickenDelivery> read(String file){
		
		GaoChen_Sub_GenericList<GaoChen_ChickenDelivery>  arr=new GaoChen_Sub_GenericList<GaoChen_ChickenDelivery>();
		try{
		FileReader aFile = new FileReader(file);      
		Scanner inFile = new Scanner(aFile);
		String line = "";	
		String [] temp;
		GaoChen_ChickenDelivery anOrder;
		GaoChen_E_Coupon couponOrder;
		
		GaoChen_Time aTime;
		GaoChen_Choice aChoice;
		
		while (inFile.hasNext())			
		{
			line= inFile.nextLine();
			temp=line.split(",");
			aTime=new GaoChen_Time(temp[3],temp[4]);
			aChoice=new GaoChen_Choice(Integer.parseInt(temp[5]),Integer.parseInt(temp[6]),Integer.parseInt(temp[7]));
			
			if(temp.length==8){
				anOrder=new GaoChen_ChickenDelivery(temp[0],temp[1],temp[2],aTime,aChoice);
				arr.add(anOrder);
			}
			else if(temp.length==9){
				couponOrder=new GaoChen_E_Coupon(temp[0],temp[1],temp[2],aTime,aChoice,Integer.parseInt(temp[8]));
				arr.add(couponOrder);
			}
		}
		arr.selectSort();
		GaoChen_outFileOrder out1=new GaoChen_outFileOrder();
		out1.writeFile(arr);
		
		
		
		}catch(FileNotFoundException fnfe)
		{
		System.out.println(fnfe.toString());
		System.out.println(fnfe.getMessage());
		System.out.println("Cannot find the file");
		}
		catch (NumberFormatException n) {
			System.out.println("Could not convert to int");
		}
		return arr;
	}
}

