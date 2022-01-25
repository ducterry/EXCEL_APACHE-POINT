package com.ndangducbn.apachepoi.utils;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {
    public static CellStyle textCellStyle(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        borderStyle(cellStyle);
        cellStyle.setAlignment(HorizontalAlignment.LEFT);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setWrapText(true);
        cellStyle.setFont(fontStyle(workbook));
        DataFormat format = workbook.createDataFormat();
        cellStyle.setDataFormat(format.getFormat("@"));
        return cellStyle;

    }

    public static void borderStyle(CellStyle cellStyle) {
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
    }

    public static Font fontStyle(Workbook workbook) {
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setFontName("Times New Roman");
        return font;
    }

    public static void createCell(Row row, Integer i, String value, CellStyle cellStyle) {
        Cell cell = row.createCell(i);
        cell.setCellValue(value);
        cell.setCellStyle(cellStyle);
    }
}
