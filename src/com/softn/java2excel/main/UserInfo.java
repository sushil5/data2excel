package com.softn.java2excel.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;

public class UserInfo implements Serializable {

	/**
	 * Author:Sushil Mankar
	 */
	private static final long serialVersionUID = 1L;
	static UIWindow uwin = null;
	FileOutputStream fileOut = null;
	final static String FILENAME = "E:/main.xls";
	File file = new File(FILENAME);
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow rowhead;
	private int len;
	private HSSFRow row1;
	int ar[];

	public static void main(String[] args) throws IOException {
		uwin = new UIWindow();
	}

	public void create() {
		try {
			
			workbook = new HSSFWorkbook();
			sheet = workbook.createSheet("FirstSheet");

			HSSFCellStyle cellStyle = workbook.createCellStyle();
			HSSFFont font = workbook.createFont();
			font.setFontHeightInPoints((short) 10);
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);

			// cellStyle.setWrapText(true);
			cellStyle.setFont(font);
			// cellStyle.setAlignment(CellStyle.ALIGN_JUSTIFY);

			rowhead = sheet.createRow((short) 0);

			HSSFCell cell0 = rowhead.createCell(0);
			cell0.setCellStyle(cellStyle);
			cell0.setCellValue(uwin.l1.getText());

			HSSFCell cell1 = rowhead.createCell(1);
			cell1.setCellStyle(cellStyle);
			cell1.setCellValue(uwin.l2.getText());

			HSSFCell cell2 = rowhead.createCell(2);
			cell2.setCellStyle(cellStyle);
			cell2.setCellValue(uwin.l3.getText());

			HSSFCell cell3 = rowhead.createCell(3);
			cell3.setCellStyle(cellStyle);
			cell3.setCellValue(uwin.l4.getText());

			HSSFCell cell4 = rowhead.createCell(4);
			cell4.setCellStyle(cellStyle);
			cell4.setCellValue(uwin.l5.getText());

			HSSFCell cell5 = rowhead.createCell(5);
			cell5.setCellStyle(cellStyle);
			cell5.setCellValue(uwin.l6.getText());

			HSSFCell cell6 = rowhead.createCell(6);
			cell6.setCellStyle(cellStyle);
			cell6.setCellValue(uwin.l7.getText());

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	private int getRow() {
		
		int i=0;
	      if(file.exists()) {
	    	  try {
				FileInputStream fis=new FileInputStream(FILENAME);
				workbook = new HSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);
		        i=sheet.getLastRowNum();
				
			} catch (IOException e) {
				e.printStackTrace();
			

			}
	      }
	      return i;
		}

	

	public void add() {
		int i=getRow();
		if (i == 0) {
			create();
		}

		row1 = sheet.createRow((short) ++i);

		row1.createCell(0).setCellValue(uwin.t1.getText());
		row1.createCell(1).setCellValue(uwin.t2.getText());
		row1.createCell(2).setCellValue(uwin.t3.getText());
		row1.createCell(3).setCellValue(uwin.t4.getText());
		row1.createCell(4).setCellValue(uwin.t5.getText());
		row1.createCell(5).setCellValue(uwin.t6.getText());
		row1.createCell(6).setCellValue(uwin.t7.getText());
		//setWidth();
		System.out.println(UIWindow.index+ " User saved");
          UIWindow.index++;
	}

	private void setWidth() {
		
		int no=sheet.getRow(0).getLastCellNum()-1;
		if(UIWindow.index==1)
		ar=new int[no+1];

		for (int i = 0; i <= no; i++) {
		if(UIWindow.index==1)	{

			len = Math.max(row1.getCell(i).getStringCellValue().length() *350 ,
		    rowhead.getCell(i).getStringCellValue().length() * 350);
		}
		else
			len=Math.max(row1.getCell(i).getStringCellValue().length() *350, ar[i]);
		
		ar[i]=len;

		sheet.setColumnWidth(i, len);
	}
 	}

	public void save() throws IOException {

		fileOut = new FileOutputStream(FILENAME);

		workbook.write(fileOut);

		fileOut.close();

		System.out.println("Your excel file has been generated!");

	}

}
