/**
 * <p>Title: SimpleMessageXmlBuild.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月5日
 * @version 1.0
 */
package com.atlas.java.pattern.behavioral.template_method.practice;


import com.atlas.java.pattern.behavioral.template_method.practice.bean.SimpleMessage;
import com.atlas.java.pattern.behavioral.template_method.practice.bean.WeiXinMessage;

/**
 * <p>Title: SimpleMessageXmlBuild</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月5日
 */
public class SimpleMessageXmlBuild extends AbstractWeiXinMessageXmlBuild {

	/**
	 * <p></p>
	 * @param message
	 */
	public SimpleMessageXmlBuild(WeiXinMessage message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	protected void middleBuild(StringBuffer xmlStr, WeiXinMessage message) {
		if(message instanceof SimpleMessage){
			SimpleMessage sm = (SimpleMessage)message;
			xmlStr.append(WX_XML_TOUSERNAME_B);
			xmlStr.append(sm.getToUserName());
			xmlStr.append(WX_XML_TOUSERNAME_E);
			xmlStr.append(WX_XML_FROMUSERNAME_B);
			xmlStr.append(sm.getFromUserName());
			xmlStr.append(WX_XML_FROMUSERNAME_E);
			xmlStr.append(WX_XML_CREATETIME_B);
			xmlStr.append(sm.getCreateTime());
			xmlStr.append(WX_XML_CREATETIME_E);
			xmlStr.append(WX_XML_MSGTYPE_B);
			xmlStr.append(sm.getMsgType());
			xmlStr.append(WX_XML_MSGTYPE_E);
		}
	}
	
}
