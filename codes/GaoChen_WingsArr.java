package gaoChen_project;
/* This class encapsulate the manipulation of the array of ordered wings.
 * Yuan Gao, Jingting Chen
 * CS 201 - Spring 2015
 * 150430
 * 
 */


public class GaoChen_WingsArr {
	public void add(GaoChen_Sub_GenericList<GaoChen_WingsPerDay> arr,GaoChen_WingsPerDay aWing){
		GaoChen_WingsPerDay temp;
		String date=aWing.getDate();
		arr.reset();
		int wing;
		boolean flag=false;
		while(arr.hasNext() && !flag){
			temp=(GaoChen_WingsPerDay)arr.getNext();
			if(temp.getDate().equals(date)){
				wing=temp.getWings();
				temp.setWings(wing+aWing.getWings());
				flag=true;
			}
		}
		if(!flag){
			arr.add(aWing);
		}
	}
	
	public void delete(GaoChen_Sub_GenericList<GaoChen_WingsPerDay> arr1,GaoChen_WingsPerDay aWing){
		GaoChen_WingsPerDay temp1;
		String date=aWing.getDate();
		int wing;
		arr1.reset();
		boolean flag1=false;
		while(arr1.hasNext() && !flag1){
			temp1=(GaoChen_WingsPerDay)arr1.getNext();
			if(temp1.getDate().equals(date)){
				wing=temp1.getWings();
				if(wing-aWing.getWings()==0){
					arr1.delete(arr1.getPointer()-1);
				}
				else{
				temp1.setWings(wing-aWing.getWings());
				}
				flag1=true;
				
			}
		}
		
	}

	public GaoChen_Sub_GenericList<GaoChen_WingsPerDay> createWingArr(GaoChen_Sub_GenericList<GaoChen_ChickenDelivery> arr) {
		
		GaoChen_WingsPerDay wingDay;
		GaoChen_WingsPerDay temp;
		GaoChen_ChickenDelivery order;
		GaoChen_Sub_GenericList<GaoChen_WingsPerDay> wingArr=new GaoChen_Sub_GenericList<GaoChen_WingsPerDay>();
		String date;
		int wing;
		boolean flag;
		arr.reset();
		while(arr.hasNext()){
			order=(GaoChen_ChickenDelivery)arr.getNext();
			date=order.getTime().getDate();
			wingArr.reset();
			flag=false;
			while(wingArr.hasNext() && !flag){
				temp=(GaoChen_WingsPerDay)wingArr.getNext();
				if(temp.getDate().equals(date)){
					wing=temp.getWings();
					temp.setWings(wing+order.totChickenWings());
					flag=true;
				}
			}
			if(!flag){
				wingDay=new GaoChen_WingsPerDay(order.getTime().getDate(),order.totChickenWings());
				wingArr.add(wingDay);
			}
		}
		wingArr.selectSort();
		GaoChen_outFileWing out1=new GaoChen_outFileWing();
		out1.writeFile(wingArr);		
		
		return wingArr;
	}

}
