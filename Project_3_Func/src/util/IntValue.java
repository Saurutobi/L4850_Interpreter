/**
 * 
 */
package util;

/**
 * @author carr
 *
 */
public class IntValue extends Value {

	/**
	 * 
	 */
	public IntValue(int val) {
		this.val = new Integer(val);
	}
	
	public int getInt() {
		return ((Integer)val).intValue();
	}

	@Override
	public String toString() {
		return val.toString();
	}

}
