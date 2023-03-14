/**
 * <p>Title: UnderlinePen.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月8日
 * @version 1.0
 */
package com.atlas.java.pattern.creational.prototype;


import com.atlas.java.pattern.creational.prototype.framework.Product;

/**
 * <p>Title: UnderlinePen</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月8日
 */
public class UnderlinePen implements Product {
	
	private char ulchar;
	public UnderlinePen(char ulchar){
		this.ulchar = ulchar;
	}

	@Override
	public void use(String s) {
		int length = s.getBytes().length;
		System.out.println("\"" + s + "\"");
		System.out.print(" ");
		for(int i = 0; i < length; i++){
			System.out.print(ulchar);
		}
		System.out.println("");
	}

	@Override
	public Product createClone() {
		Product p = null;
		try {
			p = (Product) clone();
		} catch (CloneNotSupportedException e){
			e.printStackTrace();
		}
		return p;
	}

}
