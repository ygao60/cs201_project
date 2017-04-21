package gaoChen_project;

/* This class encapsulate the prices of each kind of set.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */
import java.text.DecimalFormat;

public class GaoChen_Prices {
	
	private double priceOfA;
	private double priceOfB;
	private double priceOfC;
	
	GaoChen_Prices(){
		priceOfA = 15;
		priceOfB = 20;
		priceOfC = 25;
	}
	
	GaoChen_Prices(double a,double b,double c){
		priceOfA = a;
		priceOfB = b;
		priceOfC = c;
	}
	
	public double getPriceOfA(){
		return priceOfA;	
	}
	
	public double getPriceOfB(){
		return priceOfB;
	}
	
	public double getPriceOfC(){
		return priceOfC;
	}
	
	public void setPriceOfA(double a){
		priceOfA=a;	
	}
	public void setPriceOfB(double b){
		priceOfB=b;	
	}
	public void getPriceOfC(double c){
		priceOfC=c;	
	}
	
	public String toString(){
		DecimalFormat money = new DecimalFormat("$####.##");	
		return "price of set A:" +money.format(priceOfA)+"\nprice of set B"+money.format(priceOfB)+"\nprice of set C"+money.format(priceOfC);
	}
	
	
}
