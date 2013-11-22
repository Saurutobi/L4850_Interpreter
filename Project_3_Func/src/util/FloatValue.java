/**
 * 
 */
package util;

/**
 * @author carr
 *
 */
public class FloatValue extends Value {

	/**
	 * 
	 */
	public FloatValue(float val) {
		this.val = new Float(val);
	}
	
	public float getFloat() {
		return ((Float)val).floatValue();
	}

	@Override
	public String toString() {
		return val.toString();
	}

}
