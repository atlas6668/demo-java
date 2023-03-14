/**
 * <p>Title: Main.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月8日
 * @version 1.0
 */
package com.atlas.java.pattern.creational.prototype;


import com.atlas.java.pattern.creational.prototype.framework.Manager;
import com.atlas.java.pattern.creational.prototype.framework.Product;

/**
 * <p>Title: Main</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月8日
 */
public class Main {

	/**
	 * <p>main</p>
	 * <p></p>
	 * @author damon
	 * @date 2016年1月8日
	 * @param args
	 */
	public static void main(String[] args) {
		Manager manager = new Manager();
		UnderlinePen upen = new UnderlinePen('~');
		MessageBox mbox = new MessageBox('*');
		MessageBox sbox = new MessageBox('/');
		manager.register("Strong message", upen);
		manager.register("warning box", mbox);
		manager.register("slash box", sbox);
		
		Product p1 = manager.create("Strong message");
		p1.use("Hello, world.");
		Product p2 = manager.create("warning box");
		p2.use("Hello, world.");
		Product p3 = manager.create("slash box");
		p3.use("Hello, world.");

		Product p11 = manager.create("Strong message");
		p11.use("Hello, world.");
		System.out.println(p1);
		System.out.println(p11);
	}

}
