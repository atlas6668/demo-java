/**
 * <p>Title: Main.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月5日
 * @version 1.0
 */
package com.atlas.java.pattern.creational.factory_method;

/**
 * <p>Title: Main</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月5日
 */
public class Main {

	/**
	 * <p>main</p>
	 * <p></p>
	 * @author damon
	 * @date 2016年1月5日
	 * @param args
	 */
	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		final Product card1 = factory.create("A");
		final Product card2 = factory.create("B");
		card1.use();
		card2.use();
		Factory factory1 = new KeyFactory();
		final Product key1 = factory1.create("A");
		final Product key2 = factory1.create("B");
		key1.use();
		key2.use();
	}

}
