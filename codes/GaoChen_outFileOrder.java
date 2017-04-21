package gaoChen_project;

/* This class write all existing orders to an output file.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
		
public class GaoChen_outFileOrder{
	
		public void writeFile(GaoChen_Sub_GenericList<GaoChen_ChickenDelivery> arr){
				try
				{
					GaoChen_ChickenDelivery anOrder;
					PrintWriter out = null;
					out = new PrintWriter(new FileWriter("GaoChen_OutFile.txt"));
					
					arr.reset();
					while(arr.hasNext()){
						anOrder=arr.getNext();
						out.println(anOrder.toString());
					}
					
				    out.close();
				} catch (IOException e) {
			        System.err.println("Caught IOException: " + e.getMessage());
			    }
	
	}

}
