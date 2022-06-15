/**
 * <p>Title: Product.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月8日
 * @version 1.0
 */
package com.atlas.java.pattern.creational.prototype.framework;

/**
 * <p>Title: Product</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月8日
 */
public interface Product extends Cloneable {

	void use(String s);
	
	Product createClone();
	
}
