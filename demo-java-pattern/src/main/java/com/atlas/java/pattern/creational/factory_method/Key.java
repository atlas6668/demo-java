/**
 * <p>Title: IDCard.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月5日
 * @version 1.0
 */
package com.atlas.java.pattern.creational.factory_method;

/**
 * <p>Title: IDCard</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月5日
 */
public class Key extends Product {

	private String owner;

	public Key(String owner){
		System.out.println("创建" + owner + "的钥匙。");
		this.owner = owner;
	}
	
	public void use() {
		System.out.println("使用" + owner + "的钥匙。");
	}
	
	public String getOwner() {
		return owner;
	}
	
}
