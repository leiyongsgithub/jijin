package com.test.spring.boot.Factory;

import org.apache.log4j.Logger;

/**
* @author leiyong E-mail:
* @version 创建时间：2018年2月3日 下午2:28:44
* 类说明
*		
*/
public class LocalLoggerFactory {

	public static Logger getLogger(){
		return Logger.getLogger("LocalLoggerFactory");
	}
}
