package com.test.spring.boot.jijin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.alibaba.fastjson.JSONObject;
import com.test.spring.boot.jijin.entity.ReturnCode;
import com.test.spring.boot.jijin.entity.TableEntity;
import com.test.spring.boot.jijin.entity.TestParam;
import com.test.spring.boot.jijin.service.JiJinService;
import com.test.spring.boot.jijin.util.FileImportUtil;

@RestController
@RequestMapping("/jijin")
public class JiJinController {
	
	@Autowired
	private JiJinService jiJinService;
	private Logger logger = Logger.getLogger("JiJinController");
	@GetMapping("/test")
	public String test(TestParam param){
		//param.setId(1+"");
		return jiJinService.test(param);
	}
	
	@RequestMapping("/import")
	public String importData(HttpServletRequest request){
		try {
	         MultipartRequest multipartRequest=(MultipartRequest) request;
	         MultipartFile excelFile=multipartRequest.getFile("excelFile");
	         if(excelFile!=null){
	             List<List<String>> datas = FileImportUtil.readExcel(excelFile);
	             logger.info(JSONObject.toJSONString(datas));
	             return ReturnCode.success.getCode()+"";
	         }else{
	             return ReturnCode.paramErr.name();
	         }
	     } catch (Exception e) {
	         return ReturnCode.systemErr.name();
	     }
	}
	@RequestMapping("/table")
	public Object table(TestParam param){
		logger.info(JSONObject.toJSONString(param));
		TableEntity en1 = new TableEntity("a","b","c");
		TableEntity en2 = new TableEntity("中","国","人");
		TableEntity en3 = new TableEntity("中","国","人");
		TableEntity en4 = new TableEntity("中","国","人");
		TableEntity en5 = new TableEntity("中","国","人");
		TableEntity en6 = new TableEntity("中","国","人");
		TableEntity en7 = new TableEntity("中","国","人");
		TableEntity en8 = new TableEntity("中","国","人");
		TableEntity en9 = new TableEntity("中","国","人");
		List list = new ArrayList();
		list.add(en1);list.add(en2);
		list.add(en1);list.add(en2);
		list.add(en1);list.add(en2);
		list.add(en1);list.add(en2);
		list.add(en1);list.add(en2);
		list.add(en1);list.add(en2);
		list.add(en1);list.add(en2);
		list.add(en1);list.add(en2);
		list.add(en1);list.add(en2);
		list.add(en1);list.add(en2);
		list.add(en1);list.add(en2);
		list.add(en1);list.add(en2);
		list.add(en1);list.add(en2);
		list.add(en1);list.add(en2);
		list.add(en1);list.add(en2);
		return list;
	}
}
