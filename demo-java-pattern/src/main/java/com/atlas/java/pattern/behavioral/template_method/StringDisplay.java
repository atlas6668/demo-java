/**
 * <p>Title: StringDisplay.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月4日
 * @version 1.0
 */
package com.atlas.java.pattern.behavioral.template_method;

/**
 * <p>Title: StringDisplay</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月4日
 */
public class StringDisplay extends AbstractDisplay {

	private String string;
	private int width;
	
	public StringDisplay(String string){
		this.string = string;
		this.width = string.getBytes().length;
	}
	
	public void open() {
		// 具体实现
		printLine();
	}

	public void print() {
		// 具体实现
		System.out.println("|" + string + "|");
	}

	public void close() {
		// 具体实现
		printLine();
	}
	
	private void printLine(){
		System.out.print("+");
		for(int i = 0; i < width; i++){
			System.out.print("-");
		}
		System.out.println("+");
	}

}
