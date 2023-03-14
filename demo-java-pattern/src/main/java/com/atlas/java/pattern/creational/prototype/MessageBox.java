/**
 * <p>Title: MessageBox.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月8日
 * @version 1.0
 */
package com.atlas.java.pattern.creational.prototype;


import com.atlas.java.pattern.creational.prototype.framework.Product;

/**
 * <p>Title: MessageBox</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月8日
 */
public class MessageBox implements Product {
	
	private char decochar;
	public MessageBox(char decochar) {
		this.decochar = decochar;
	}

	@Override
	public void use(String s) {
		int length = s.getBytes().length;
		for(int i = 0; i < length + 4; i++){
			System.out.print(decochar);
		}
		System.out.println("");
		System.out.println(decochar + " " + s + " " + decochar);
		for(int i = 0; i < length + 4; i++){
			System.out.print(decochar);
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
