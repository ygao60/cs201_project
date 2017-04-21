package gaoChen_project;

/* This class display all existing number of wings ordered each delivery day.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */

public class GaoChen_displayWings {
	public void showWings(GaoChen_Sub_GenericList<GaoChen_WingsPerDay>  wingArr){
		
			GaoChen_WingsPerDay wingDay;
			
			wingArr.reset();
			while(wingArr.hasNext()){
				wingDay=wingArr.getNext();
				System.out.println(wingDay.toString());
			}
			
	}

}
