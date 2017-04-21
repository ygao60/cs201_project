package gaoChen_project;
/* This class encapsulate delivery time, including date and time.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */

public class GaoChen_Time {
	private String date;
	private String time;
	
	public GaoChen_Time() {
		date="20140901";
		time="1730";	
	}
	
	public GaoChen_Time( String d, String t){
		date=d;
		time=t;
	}
	
	
	public String getDate(){
		return date;
	}
	
	public String getTime(){
		return time;
	}
	
	
	
	public void setDate(String d){
		date=d;
	}
	
	public void setTime(String t){
		time=t;
	}
	
	public String toString(){
		return date+", "+time;
	}
	
	public boolean equals(GaoChen_Time time1){
		return (date.equals(time1.getDate())) && (time.equals(time1.getTime()));
	}
	
	public int compareTo(GaoChen_Time time1){
		String t=date+time;
		String t1=time1.getDate()+time1.getTime();
		return t.compareTo(t1);
	}
}
