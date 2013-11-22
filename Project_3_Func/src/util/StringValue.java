/**
 * 
 */
package util;

/**
 * @author carr
 *
 */
public class StringValue extends Value {

	/**
	 * 
	 */
	public StringValue(String val) {
		this.val = val;
	}
	
	@Override
	public String toString() {
		return "'" + val.toString() + "'";
	}

	
}
