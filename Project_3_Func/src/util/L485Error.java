/**
 * 
 */
package util;

/**
 * @author carr
 *
 */
public class L485Error extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8480673268859231478L;

	/**
	 * 
	 */
	public L485Error() {
	}

	/**
	 * @param arg0
	 */
	public L485Error(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public L485Error(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public L485Error(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	public String toString() {
		return this.getMessage();
	}

}
