package gaoChen_project;
/* This class is a subclass of GenericList_gaoY. It has methods of binary search, sequential search and select sort.
 * Yuan Gao
 * CS 201 - Spring 2015
 * 150419
 * 
 */
public class GaoChen_Sub_GenericList<T extends Comparable<T>>  extends GaoChen_GenericList<T> {

	public GaoChen_Sub_GenericList() {
		super();
	}

	public GaoChen_Sub_GenericList(int size) {
		super(size);
	}
	
	int seqSearch(T t){
		for(int i=0;i<getIndex();i++){
			if (t.equals((T)getElement(i))){
				return i;
			}
		}
		return -1;
	}
	
	int binSearch(T t){
		int start=0;
		int end=getIndex();
		int middle=0;
		while(start<=end){
			middle=(start+end)/2;
			if(getElement(middle).equals(t)){
				return middle;
			}
			else if((getElement(middle)).compareTo(t)<0){
				start=middle+1;
			}
			else{
				end=middle-1;
			}
		}
		return -1;
	}
	
	void selectSort(){
		int i,j,temp;
		for(i=0;i<getIndex();i++){
			temp=i;
			for(j=i+1;j<getIndex();j++){
				if(getElement(j).compareTo(getElement(temp))<0){
					temp=j;
				}
			}
			if(temp!=i){
				swap(i,temp);
			}
		}
	}

}
