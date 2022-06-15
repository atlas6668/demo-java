/**
 * <p>Title: Factory.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月5日
 * @version 1.0
 */
package com.atlas.java.pattern.creational.factory_method;

/**
 * <p>Title: Factory</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月5日
 */
public abstract class Factory {

	public final Product create(String owner) {
		Product p = createProduct(owner);
		registerProduct(p);
		return p;
	}
	
	protected abstract Product createProduct(String owner);
	
	protected abstract void  registerProduct(Product product);
	
}
