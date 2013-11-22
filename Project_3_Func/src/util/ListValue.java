/**
 * 
 */
package util;

import java.util.ArrayList;

/**
 * @author carr
 *
 */
public class ListValue extends Value {

	/**
	 * 
	 */
	public ListValue(ArrayList<Value> list) {
		this.val = list;
	}
	
	public Value first() {
		return ((ArrayList<Value>)val).get(0);
	}
	
	public ListValue rest() {
		ArrayList<Value> newL = (ArrayList<Value>) ((ArrayList<Value>)val).clone();
		newL.remove(0);
		
		return new ListValue(newL);
	}
	
	public ListValue insert(Value v) {
		ArrayList<Value> theList = (ArrayList<Value>) val;
		theList.add(0,v);
		
		return this;
	}
	
	public int length() {
		return ((ArrayList<Value>)val).size();
	}
	
	public String toString() {
		String str = "[";
		
		for (Value v: (ArrayList<Value>) val) {
			str += (v + ", ");
		}
		
		return str.substring(0,str.length()-2)+"]";
	}

}
