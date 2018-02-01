package com.test.spring.boot.jijin.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;



/**
* @author leiyong E-mail:
* 类说明
* 		
*/
public class FileImportUtil {
	//读取excel信息，存入List中
	public static List<List<String>> readExcel(MultipartFile file) throws Exception  {
		List<List<String>> res = new ArrayList<>();
		Workbook wb;
        Sheet st ;
        Row row ;
        //获取输入流
        InputStream in = file.getInputStream();
        try {
            wb = WorkbookFactory.create(in);
            st = wb.getSheetAt(0);
            //从第二行开始读取，每行数据存入一个list中
            for (int rowNum = 1; rowNum <= st.getLastRowNum(); rowNum++) {// 第一行为标题
            	row = st.getRow(rowNum);
                if (row == null || isNullRow(row)) {
                    continue;
                }
                List<String> list = new ArrayList<>();
                for(int cellNum=0;cellNum<row.getLastCellNum();cellNum++){//获取每列数据
                	Cell cell = row.getCell(cellNum);
                	list.add(cellNum, cell == null ? "" : cell.toString());
                }
                res.add(list);
            }
            
        } catch (Exception e) {
        	throw new Exception("文档格式错误", e);
        }finally{
        	in.close();
        }
        
		return res;
	}
	//校验cell中数据是否为空
	private static boolean isNullRow(Row row) {
        short max = row.getLastCellNum();
        for (short i = 0; i < max; i++) {
            Cell c = row.getCell(i);
            if (c == null || c.equals("") || c.getCellTypeEnum().equals(CellType.BLANK) ) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
