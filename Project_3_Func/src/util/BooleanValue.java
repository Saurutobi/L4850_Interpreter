/**
 * 
 */
package util;

/**
 * @author carr
 *
 */
public class BooleanValue extends Value {

	/**
	 * 
	 */
	public BooleanValue(boolean val) {
		this.val = new Boolean(val);
	}
	
	public boolean getBoolean() {
		return ((Boolean)val).booleanValue();
	}

	public String toString() {
		return val.toString();
	}
}
