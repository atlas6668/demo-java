/**
 * <p>Title: TextMessageXmlBuild.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月5日
 * @version 1.0
 */
package com.atlas.java.pattern.behavioral.template_method.practice;


import sun.exercise.pattern.behavioral.template_method.practice.bean.TextMessage;
import sun.exercise.pattern.behavioral.template_method.practice.bean.WeiXinMessage;

/**
 * <p>Title: TextMessageXmlBuild</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月5日
 */
public class TextMessageXmlBuild extends SimpleMessageXmlBuild {

	/**
	 * <p></p>
	 * @param message
	 */
	public TextMessageXmlBuild(WeiXinMessage message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	protected void middleBuild(StringBuffer xmlStr, WeiXinMessage message) {
		if(message instanceof TextMessage){
			super.middleBuild(xmlStr, message);
			TextMessage tm = (TextMessage) message;
			xmlStr.append(WX_XML_CONTENT_B);
			xmlStr.append(tm.getContent());
			xmlStr.append(WX_XML_CONTENT_E);
		}
	}

}
