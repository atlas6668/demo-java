/**
 * <p>Title: CharDisplay.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月4日
 * @version 1.0
 */
package com.atlas.java.pattern.behavioral.template_method;

/**
 * <p>Title: CharDisplay</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月4日
 */
public class CharDisplay extends AbstractDisplay {

	private char ch;
	public CharDisplay(char ch) {
		this.ch = ch;
	}

	public void open() {
		// 具体实现
		System.out.print("<<");
	}

	public void print() {
		// 具体实现
		System.out.print(ch);
	}

	public void close() {
		// 具体实现
		System.out.println(">>");
	}

}
