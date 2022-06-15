/**
 * <p>Title: AbstractDisplay.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月4日
 * @version 1.0
 */
package com.atlas.java.pattern.behavioral.template_method;

/**
 * <p>Title: AbstractDisplay</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月4日
 */
public abstract class AbstractDisplay {

	// 方法抽象定义在父类
	public abstract void open();
	public abstract void print();
	public abstract void close();

	// 父类方法调用抽象方法
	public final void diplay() {
		open();
		for(int i = 0; i < 5; i++){
			print();
		}
		close();
	}
	
}
