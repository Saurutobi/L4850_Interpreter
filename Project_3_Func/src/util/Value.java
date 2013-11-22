/**
 * 
 */
package util;

/**
 * @author carr
 *
 */
public abstract class Value {
	
	protected Object val;
	
	/**
	 * @return the val
	 */
	public Object get() {
		return val;
	}

	/**
	 * @param val the val to set
	 */
	public void set(Object val) {
		this.val = val;
	}

	public abstract String toString();
}
