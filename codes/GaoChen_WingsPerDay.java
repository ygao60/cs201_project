package gaoChen_project;
/* This class encapsulate ordered wings for the delivery date.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */

public class GaoChen_WingsPerDay  implements Comparable<GaoChen_WingsPerDay> {
	String date;
	int wings;

	public GaoChen_WingsPerDay(String d,int w) {
		date=d;
		wings=w;
	}
	
	public int compareTo(GaoChen_WingsPerDay w1){
		return date.compareTo(w1.getDate());
	}
	
	public String getDate(){
		return date;
	}
	
	public int getWings(){
		return wings;
	}
	
	public void setDate(String d){
		date=d;
	}
	
	public void setWings(int w){
		wings=w;
	}
	
	public boolean hasWings(){
		return (wings<=1000);
	}
	
	public boolean equals(GaoChen_WingsPerDay w1){
		return date.equals(w1.getDate()) && (wings==w1.getWings());
	}
	public String toString(){
		return date+" "+wings+" wings";
	}

}
