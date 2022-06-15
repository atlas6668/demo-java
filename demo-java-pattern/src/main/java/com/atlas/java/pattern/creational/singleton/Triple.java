/**
 * <p>Title: Triple.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月8日
 * @version 1.0
 */
package com.atlas.java.pattern.creational.singleton;

/**
 * <p>Title: Triple</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月8日
 */
public class Triple {

	private static Triple[] triplearr = new Triple[3];

	public int id;

//	public Triple(){}
	
	private Triple(int id) {
		this.id = id;
		System.out.println("实例" + id + "已建立。");
	}
	
	public static synchronized Triple getInstance(int id) {
		if(triplearr[id % 3] == null){
			triplearr[id % 3] = new Triple(id % 3);
		}
		return triplearr[id % 3];
	}

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		for(int i = 0; i < 10000; i++){
			Triple triple = Triple.getInstance(i);
			System.out.println(triple.id);
		}

//		Triple triple = (Triple) Class.forName("sun.exercise.pattern.creational.singleton.Triple").newInstance();
//		System.out.println(triple.id);
	}
}
