package gaoChen_project;

/* This class calculate the total number of wings of a selection of sets.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */

public class GaoChen_calcWings {

	public int calc_wing(GaoChen_Choice choice){
		GaoChen_NumOfWings wings=new GaoChen_NumOfWings();
		return choice.getNumOfA() * wings.getNumOfWingsA()
				+choice.getNumOfB() * wings.getNumOfWingsB()
				+choice.getNumOfC() * wings.getNumOfWingsC();
	}
}
