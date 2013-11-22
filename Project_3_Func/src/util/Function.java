/**
 * 
 */
package util;

import java.util.ArrayList;

/**
 * @author carr
 *
 */
public abstract class Function extends Value {

	public abstract Value invoke(Environment env,ArrayList<Value> args) throws L485Error;
}
