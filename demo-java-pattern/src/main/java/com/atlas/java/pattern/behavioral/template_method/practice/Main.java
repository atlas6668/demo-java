/**
 * <p>Title: Main.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月5日
 * @version 1.0
 */
package com.atlas.java.pattern.behavioral.template_method.practice;


import com.atlas.java.pattern.behavioral.template_method.practice.bean.TextMessage;

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
//		SimpleMessage sm = new SimpleMessage();
//		sm.setToUserName("wx59b9035ec663ded4");
//    	sm.setFromUserName("wxdea97090fe1dcd9c");
//    	sm.setCreateTime(System.currentTimeMillis() / 1000);
//    	sm.setMsgType("text");
//		AbstractWeiXinMessageXmlBuild axb1 = new SimpleMessageXmlBuild(sm);
//		axb1.build();
//		System.out.println(axb1.getXmlStr().toString());
		
		TextMessage tm = new TextMessage();
		tm.setToUserName("wx59b9035ec663ded4");
		tm.setFromUserName("wxdea97090fe1dcd9c");
		tm.setCreateTime(System.currentTimeMillis() / 1000);
		tm.setMsgType("text");
		tm.setContent("welcome.");
		AbstractWeiXinMessageXmlBuild axb2 = new TextMessageXmlBuild(tm);
		axb2.build();
		System.out.println(axb2.getXmlStr().toString());
	}

}
