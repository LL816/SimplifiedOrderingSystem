package cheryl.ordering.comprise;

import java.util.ArrayList;

public class MyPair {
	private int element_num;
	private ArrayList<ArrayList> element;

	@SuppressWarnings("unchecked")
	public MyPair(){
		element_num = 0;
		element = new ArrayList();
	}
	public MyPair(int defined_num){
		element_num = defined_num;
		element = new ArrayList<ArrayList>();
	}
	
	public void setElement(int index, ArrayList target){
		if(index < element_num){
			element.add(index, target);
		}
		else{
			System.out.print("Out of range");
		}
	}
	
	public ArrayList getElement(int index){
		if(index < element_num){
			return element.get(index);
		}
		else{
			System.out.print("Out of range");
			return null;
		}
	}

}
