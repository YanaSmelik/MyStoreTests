package com.mystore.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Helper class for working with excel documents
 */
public class XLUtils {
    public static FileInputStream input;
    public static FileOutputStream output;
    public static XSSFWorkbook workbook;
    public static XSSFSheet worksheet;
    public static XSSFRow row;
    public static XSSFCell cell;


    public static int getRowsTotalNum(String xlFile, String xlSheet) throws IOException {
        input = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(input);
        worksheet = workbook.getSheet(xlSheet);
        int rowCount = worksheet.getLastRowNum();
        workbook.close();
        input.close();
        return rowCount;
    }


    public static int getCellsNumber(String xlFile, String xlSheet, int rowNumber) throws IOException {
        input = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(input);
        worksheet = workbook.getSheet(xlSheet);
        row = worksheet.getRow(rowNumber);
        int cellCount = row.getLastCellNum();
        workbook.close();
        input.close();
        return cellCount;
    }


    public static String getCellData(String xlFile, String xlSheet, int rowNumber, int column) throws IOException {
        input = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(input);
        worksheet = workbook.getSheet(xlSheet);
        row = worksheet.getRow(rowNumber);
        cell = row.getCell(column);
        String data;
        try {
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
            return data;
        } catch (Exception e) {
            data = "Error occurred";
        }
        workbook.close();
        input.close();
        return data;
    }


    public static void setCellData(String xlFile, String xlSheet, int rowNumber, int column, String data) throws IOException {
        input = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(input);
        worksheet = workbook.getSheet(xlSheet);
        row = worksheet.getRow(rowNumber);
        cell = row.createCell(column);
        cell.setCellValue(data);
        output = new FileOutputStream(xlFile);
        workbook.write(output);
        workbook.close();
        input.close();
        output.close();
    }
}
