package gaoChen_project;

/* This class encapsulate a choice of each set.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */

public class GaoChen_Choice {
	private int numberOfA;
	private int numberOfB;
	private int numberOfC;
	
	public GaoChen_Choice() {
		numberOfA=1;
		numberOfB=2;
		numberOfC=3;
	}
	
	GaoChen_Choice(int a,int b,int c){
		numberOfA = a;
		numberOfB = b;
		numberOfC = c;
	}
	
	public int getNumOfA(){
		return numberOfA;
	}
	
	public int getNumOfB(){
		return numberOfB;
	}
	
	public int getNumOfC(){
		return numberOfC;
	}
	
	public void setNumOfA(int a){
		numberOfA=a;
	}
	
	public void setNumOfB(int b){
		numberOfB=b;
	}
	
	public void setNumOfC(int c){
		numberOfC=c;
	}
	
	public String toString(){
		return "number of set A: "+numberOfA+"  number of set B:"+numberOfB+"  number of set C:"+numberOfC;
	}
	
	public boolean equals(GaoChen_Choice choice){
		return (numberOfA==choice.getNumOfA()) && (numberOfB==choice.getNumOfB()) && (numberOfC==choice.getNumOfC());
	}
}
