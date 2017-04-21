package gaoChen_project;

/* This class checks how many wings is available per day.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */


public class GaoChen_wingsLeft {
	String date;
	int wings_left;
	
	GaoChen_wingsLeft(String d,GaoChen_Sub_GenericList<GaoChen_WingsPerDay> arrWing){
		date=d;
		wings_left=checkWingsLeft(d,arrWing);
	}

	
	public int checkWingsLeft(String date,GaoChen_Sub_GenericList<GaoChen_WingsPerDay> arrWing){
		
		arrWing.reset();
		GaoChen_WingsPerDay wingDay;
		while(arrWing.hasNext()){
			wingDay=(GaoChen_WingsPerDay)arrWing.getNext();
			if(wingDay.getDate().equals(date)){
				return 1000-wingDay.getWings();
			}
		}
		return 1000;
	}

	public boolean checkEnough(int wingOrder){
		return (wingOrder<=wings_left);
	}
	
	public String toString(){
		return "There is only "+wings_left+" wings left on "+date;
	}
	
	public boolean checkEmpty(){
		return (wings_left<=0);
	}
	
	public int getWingsLeft(){
		return wings_left;
	}
	

}
