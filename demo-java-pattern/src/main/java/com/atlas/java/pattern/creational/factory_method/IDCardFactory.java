/**
 * <p>Title: IDCardFactory.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月5日
 * @version 1.0
 */
package com.atlas.java.pattern.creational.factory_method;

import java.util.Vector;

/**
 * <p>Title: IDCardFactory</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月5日
 */
public class IDCardFactory extends Factory {

	private Vector<String> owners = new Vector<String>();

	protected Product createProduct(String owner) {
		return new IDCard(owner);
	}

	protected void registerProduct(Product product) {
		IDCard card = (IDCard) product;
		owners.add(card.getOwner());
	}
	
	public Vector<String> getOwners() {
		return owners;
	}

}
