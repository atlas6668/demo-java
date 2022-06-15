/**
 * <p>Title: AbstractWeiXinMessageXmlBuild.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月4日
 * @version 1.0
 */
package com.atlas.java.pattern.behavioral.template_method.practice;


import sun.exercise.pattern.behavioral.template_method.practice.bean.WeiXinMessage;

/**
 * <p>Title: AbstractWeiXinMessageXmlBuild</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月4日
 */
public abstract class AbstractWeiXinMessageXmlBuild {
	
	/**
	 * WX_XML_XMLB XML开始标签
	 */
	public static final String WX_XML_XML_B = "<xml>";
	
	/**
	 * WX_XML_XMLE XML结束标签
	 */
	public static final String WX_XML_XML_E = "</xml>";
	
	/**
	 * WX_XML_TOUSERNAME_B 接收方帐号开始标签
	 */
	public static final String WX_XML_TOUSERNAME_B = "<ToUserName><![CDATA[";
	
	/**
	 * WX_XML_TOUSERNAME_E 接收方帐号结束标签
	 */
	public static final String WX_XML_TOUSERNAME_E = "]]></ToUserName>";
	
	/**
	 * WX_XML_FROMUSERNAME_B 发送方帐号开始标签
	 */
	public static final String WX_XML_FROMUSERNAME_B = "<FromUserName><![CDATA[";
	
	/**
	 * WX_XML_FROMUSERNAME_E 发送方帐号结束标签
	 */
	public static final String WX_XML_FROMUSERNAME_E = "]]></FromUserName>";
	
	/**
	 * WX_XML_CREATETIME_B 消息创建时间开始标签
	 */
	public static final String WX_XML_CREATETIME_B = "<CreateTime>";
	
	/**
	 * WX_XML_CREATETIME_E 消息创建时间结束标签
	 */
	public static final String WX_XML_CREATETIME_E = "</CreateTime>";
	
	/**
	 * WX_XML_MSGTYPE_B 消息类型开始标签
	 */
	public static final String WX_XML_MSGTYPE_B = "<MsgType><![CDATA[";
	
	/**
	 * WX_XML_MSGTYPE_E 消息类型结束标签
	 */
	public static final String WX_XML_MSGTYPE_E = "]]></MsgType>";
	
	/**
	 * WX_XML_CONTENT_B 文本消息内容开始标签
	 */
	public static final String WX_XML_CONTENT_B = "<Content><![CDATA[";
	
	/**
	 * WX_XML_CONTENT_E 文本消息内容结束标签
	 */
	public static final String WX_XML_CONTENT_E = "]]></Content>";
	
	private WeiXinMessage message;
	
	private StringBuffer xmlStr = new StringBuffer();
	
	public void setMessage(WeiXinMessage message){
		this.message = message;
	}
	
	public StringBuffer getXmlStr() {
		return this.xmlStr;
	}
	
	public AbstractWeiXinMessageXmlBuild(WeiXinMessage message){
		this.message = message;
	}

	public void build() {
		topBuild();
		middleBuild(this.xmlStr, this.message);
		bottomBuild();
	}
	
	private void topBuild() {
		this.xmlStr.append(WX_XML_XML_B);
	}
	
	protected void middleBuild(StringBuffer xmlStr, WeiXinMessage message) {
		// 
	}
	
	private void bottomBuild() {
		this.xmlStr.append(WX_XML_XML_E);
	}
	
}
