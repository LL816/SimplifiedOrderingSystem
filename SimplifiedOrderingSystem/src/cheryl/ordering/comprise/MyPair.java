package cheryl.ordering.comprise;
import java.util.ArrayList;

public class MyPair {
	private ArrayList element1;
	private ArrayList element2;
	public MyPair(){
		element1 = new ArrayList();
		element2 = new ArrayList();
	}
	public MyPair(ArrayList temp1, ArrayList temp2){
		element1 = temp1;
		element2 = temp2;
	}
	
	public ArrayList getElement1(){
		return element1;
	}
	public ArrayList getElement2(){
		return element2;
	}

}
