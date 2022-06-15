/**
 * <p>Title: Main.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月4日
 * @version 1.0
 */
package com.atlas.java.pattern.behavioral.template_method;

/**
 * <p>Title: Main</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月4日
 */
public class Main {

	/**
	 * <p>main</p>
	 * <p></p>
	 * @author damon
	 * @date 2016年1月4日
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractDisplay d1 = new CharDisplay('H');
		d1.diplay();
		
//		AbstractDisplay d2 = new StringDisplay("Hello");
//		d2.diplay();
	}

}
