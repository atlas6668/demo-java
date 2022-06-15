/**
 * <p>Title: Manager.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月8日
 * @version 1.0
 */
package com.atlas.java.pattern.creational.prototype.framework;

import java.util.Hashtable;

/**
 * <p>Title: Manager</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月8日
 */
public class Manager {

	private Hashtable<String, Product> showcase = new Hashtable<String, Product>();
	
	public void register(String name, Product product) {
		showcase.put(name, product);
	}
	
	public Product create(String name) {
		Product p = showcase.get(name);
		return p.createClone();
	}
}
