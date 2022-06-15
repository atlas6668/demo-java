/**
 * <p>Title: TextMessage.java</p>
 * <p></p>
 * @author damon
 * @date 2016年1月5日
 * @version 1.0
 */
package com.atlas.java.pattern.behavioral.template_method.practice.bean;

/**
 * <p>Title: TextMessage</p>
 * <p></p> 
 * @author damon
 * @date 2016年1月5日
 */
public class TextMessage extends SimpleMessage {

	/**
	 * serialVersionUID 
	 */
	private static final long serialVersionUID = 8610896716915796315L;
	
	/**
	 * Content 文本消息内容 
	 */
	private String Content;
	
/* ********** ********** getter and setter ********** ********** */
	
	/**
	 * @return the content
	 */
	public String getContent() {
		return Content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		Content = content;
	}

}
