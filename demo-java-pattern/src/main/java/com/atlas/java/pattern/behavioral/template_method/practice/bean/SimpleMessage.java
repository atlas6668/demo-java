/**
 * <p>Title: SimpleMessage.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月5日
 * @version 1.0
 */
package com.atlas.java.pattern.behavioral.template_method.practice.bean;


/**
 * <p>Title: SimpleMessage</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月5日
 */
public class SimpleMessage extends WeiXinMessage {

	/**
	 * serialVersionUID 
	 */
	private static final long serialVersionUID = -5767544215788248380L;
	/**
	 * ToUserName 接收方帐号（一个OpenID）
	 */
	private String ToUserName; 
    /**
     * FromUserName 发送方帐号（一个OpenID） 
     */
    private String FromUserName;
    
    /**
     * CreateTime 消息创建时间 （整型）
     */
    private Long CreateTime; 
    
    /**
     * MsgType 消息类型(text image voice video location link event)
     */
    private String MsgType;
    
/* ********** ********** getter and setter ********** ********** */

	/**
	 * @return the toUserName
	 */
	public String getToUserName() {
		return ToUserName;
	}

	/**
	 * @param toUserName the toUserName to set
	 */
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	/**
	 * @return the fromUserName
	 */
	public String getFromUserName() {
		return FromUserName;
	}

	/**
	 * @param fromUserName the fromUserName to set
	 */
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	/**
	 * @return the createTime
	 */
	public Long getCreateTime() {
		return CreateTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	/**
	 * @return the msgType
	 */
	public String getMsgType() {
		return MsgType;
	}

	/**
	 * @param msgType the msgType to set
	 */
	public void setMsgType(String msgType) {
		MsgType = msgType;
	} 
    
}
