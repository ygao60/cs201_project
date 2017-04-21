package gaoChen_project;

/* This class write all ordered chicken wing for each delivery day to an output file.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GaoChen_outFileWing {
	public void writeFile(GaoChen_Sub_GenericList<GaoChen_WingsPerDay>  wingArr){
		try
		{
			GaoChen_WingsPerDay wingDay;
			PrintWriter out_wing = null;
			out_wing = new PrintWriter(new FileWriter("GaoChen_OutFile_wing.txt"));
			wingArr.reset();
			while(wingArr.hasNext()){
				wingDay=wingArr.getNext();
				out_wing.println(wingDay.toString());
			}
			
		    out_wing.close();
		} catch (IOException e) {
	        System.err.println("Caught IOException: " + e.getMessage());
	    }

}

}
