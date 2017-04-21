package gaoChen_project;

/* This class encapsulate number of chicken wings for each set.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */

public class GaoChen_NumOfWings {
	private int numOfWings_A;
	private int numOfWings_B;
	private int numOfWings_C;
	
	GaoChen_NumOfWings(){
		numOfWings_A = 5;
		numOfWings_B = 8;
		numOfWings_C= 12;
	}
	
	public int getNumOfWingsA(){
		return numOfWings_A;	
	}
	
	public int getNumOfWingsB(){
		return numOfWings_B;
	}
	
	public int getNumOfWingsC(){
		return numOfWings_C;
	}
	public void setNumOfWingsA(int a){
		numOfWings_A=a;	
	}
	public int setNumOfWingsB(int b){
		return numOfWings_B=b;	
	}
	public int setNumOfWingsC(int c){
		return numOfWings_C=c;	
	}
	public boolean equals(GaoChen_NumOfWings n){
		return (numOfWings_A==n.getNumOfWingsA()) && (numOfWings_B==n.getNumOfWingsB()) && (numOfWings_C==n.getNumOfWingsC());
	}
	public String toString(){
		return "number of Wings in set A: "+numOfWings_A+"\nnumber of Wings in set B: "+numOfWings_B+"\nnumber of Wings in set C: "+numOfWings_C;
	}
}
