package gaoChen_project;
/* This class encapsulates a generic type <T> List.
 * Yuan Gao
 * CS 201 - Spring 2015
 * 150419
 * 
 */
public class GaoChen_GenericList<T> {


	final int MAX_SIZE=300;
	private T [] objectArr;
	private int index;
	private int pointer;

	public GaoChen_GenericList () {
		objectArr=(T[])new Object [MAX_SIZE];
		index=0;
		pointer=0;
	}
	
	public GaoChen_GenericList(int size){
		objectArr=(T[])new Object [size];
		index=0;
		pointer=0;
	}
	
	public int getLength(){
		return objectArr.length;
	}
	
	public T [] getArray(){
		int l=objectArr.length;
		T [] newArr=(T[])new Object [l];
		for (int i=0;i<index;i++){
			newArr[i]=objectArr[i];
		}
		return newArr;
	}
	
	public int getIndex(){
		return index;
	}
	
	public T getElement(int pos){
		if(pos>=index){
			System.out.println("The pos is out of range!");
			return null;
		}
		else{
			return objectArr[pos];
		}
	}
	
	public void setArray(T [] anArray){
		int l=anArray.length;
		T [] newArr=(T[])new Object [l];
		for (int i=0;i<l;i++){
			newArr[i]=anArray[i];
		}
		objectArr=newArr;
	}
	
	public void setIndex(int anIndex){
		index=anIndex;
	}
	
	public void setElement(T aObj, int pos){
		if(pos>=index){
			System.out.println("The pos is out of range!");
		}
		else{
			objectArr[pos]=aObj;
		}
	}
	
	public String toString(){
		String s="";
		for(int i=0;i<index;i++){
			s=s+objectArr[i].toString()+"\n";
		}
		return s;
	}
	
	public boolean equals(GaoChen_GenericList anArr){
		if(anArr.getLength()!=objectArr.length){
			return false;
		}
		else if(anArr.getIndex()!=index){
			return false;
		}
		else{
			for(int i=0;i<index;i++){
				if(!objectArr[i].equals(anArr.getElement(i))){
					return false;
				}
			}
			return true;
		}
	}
	
	public void add(T obj1){
		if(index>=objectArr.length){
			moreCapacity(2);
		}
		objectArr[index]=obj1;
		index++;
	}
	
	//searches for and returns the index of anObj, -1 if not found
	public int isThere(T anObj){
		for(int i=0;i<index;i++){
			if (((GaoChen_ChickenDelivery)objectArr[i]).equals((GaoChen_ChickenDelivery)anObj)){
				return i;
			}
		}
		return -1;
	}
	
	//searches for anObj, returns the index of anObj, -1 if not found
	public int delete(T anObj){
		int pos=isThere(anObj);
		if(pos!=-1){
			for(int i=pos;i<index;i++){
				objectArr[i]=objectArr[i+1];
			}
			index--;
		}
		return pos;
	}
	
	//deletes the object at pos and moves all elements up
	public void delete(int pos){
		if(pos>=index){
			System.out.println("The pos is out of range!");
		}
		else{
			for(int i=pos;i<index;i++){
				objectArr[i]=objectArr[i+1];
			}
			index--;
		}
	}
	
	//inserts the object at pos and moves all elements down
	public void insert(int pos, T anObj){
		if(pos>index){
			System.out.println("The pos is out of range!");
		}
		else{
			if(index>=objectArr.length){
				moreCapacity(2);
			}
			for(int i=index;i>pos;i--){
				objectArr[i]=objectArr[i-1];
			}
			index++;
			objectArr[pos]=anObj;
		}	
	}
	
	public void swap(int pos1, int pos2){
		if(pos1<index && pos2<index){
			T temp=objectArr[pos1];
			objectArr[pos1]=objectArr[pos2];
			objectArr[pos2]=temp;
		}
		else{
			System.out.println("The pos is out of range!");
		}
	}
	
	//allocate more memory by instantiating a new larger array which is int times the current array 
	public void moreCapacity(int times){
		int len=objectArr.length*(times);
		T [] newArr=(T[])new Object [len];
		for (int i=0;i<index;i++){
			newArr[i]=objectArr[i];
		}
		objectArr=newArr;
	}
	
	//remove excess capacity so that capacity matches size
	public void trim(){
		T [] newArr=(T[])new Object[index];
		for (int i=0;i<index;i++){
			newArr[i]=objectArr[i];
		}
		objectArr=newArr;
	}
	
	//returns true if array is full, false if array is not
	public boolean isFull(){
		if (index>=objectArr.length){
			return true;
		}
		else{
			return false;
		}
	}
	
	//returns true if array is empty, false if array is not
	public boolean isEmpty(){
		if(index==0){
			return true;
		}
		else{
			return false;
		}
	}
	
	//deletes all data from list
	public void clear(){
		int len=objectArr.length;
		T [] newArr=(T[])new Object [len];
		objectArr=newArr;
		index=0;
	}
	
	//sets the iterator “pointer” to 0
	public void reset(){
		pointer=0;
	}
	
	//returns boolean if there is more data in the array
	public boolean hasNext(){
		return (pointer<index);
	}
	
	public int getPointer(){
		return pointer;
	}
	
	//returns the object at the iterator “pointer”, increments pointer
	public T getNext(){
		if(pointer>=index){
			System.out.println("There is no more data!");
			return null;
		}
		else{
			pointer++;
			return objectArr[pointer-1];
		}
	}
}






