package com.test.spring.boot.jijin.common.util;

import java.util.List;

public class CheckUtil {
	
	public static boolean checkList(List list){
		if(list == null || list.isEmpty())
			return true;
		return false;
	}
}
