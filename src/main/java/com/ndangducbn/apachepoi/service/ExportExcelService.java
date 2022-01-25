package com.ndangducbn.apachepoi.service;

import com.ndangducbn.apachepoi.constants.LocationConstants;
import com.ndangducbn.apachepoi.model.Book;
import com.ndangducbn.apachepoi.utils.ExcelUtils;
import com.ndangducbn.apachepoi.utils.FileUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ExportExcelService {
    public String exportExcel() throws IOException {
        // Tạo đường dẫn khi xuất Excel
        String pathExport = createPathExport();


        // Load Excel Templates
        XSSFWorkbook excelTemplates = loadExcelTemplates();

        // Fill Data to Excel
        fillDataToExcel(excelTemplates, FakeData.bookList);


        // Xuất file
        return returnPathExport(pathExport, excelTemplates);
    }

    private String returnPathExport(String pathExport, XSSFWorkbook excelTemplates) {
        try (FileOutputStream outputStream = new FileOutputStream(pathExport)) {
            if (excelTemplates != null) {
                excelTemplates.write(outputStream);
            }
            outputStream.flush();
            return pathExport;
        } catch (Exception e) {
            e.getMessage();
        }
        return pathExport;
    }

    private void fillDataToExcel(XSSFWorkbook workbook, List<Book> bookList) {
        XSSFSheet sheet = workbook.getSheetAt(0);
        CellStyle cellStyle = ExcelUtils.textCellStyle(workbook);
        Integer rowNumber = 4, stt = 0;

        for (Book book : bookList) {
            int i = 0;
            Row row = sheet.createRow(rowNumber++);
            stt++;
            ExcelUtils.createCell(row, i, stt.toString(), cellStyle);
            ExcelUtils.createCell(row, ++i, book.getId().toString(), cellStyle);
            ExcelUtils.createCell(row, ++i, book.getTitle().toString(), cellStyle);
            ExcelUtils.createCell(row, ++i, book.getPrice().toString(), cellStyle);
            ExcelUtils.createCell(row, ++i, book.getQuantity().toString(), cellStyle);
            ExcelUtils.createCell(row, ++i, book.getTotalMoney().toString(), cellStyle);
        }
    }

    private XSSFWorkbook loadExcelTemplates() throws IOException {
        InputStream excelFile = new ClassPathResource(LocationConstants.FILE_EXPORT_TEMPLATES).getInputStream();
        return new XSSFWorkbook(excelFile);
    }

    private String createPathExport() {
        File dir = new File(LocationConstants.PATH_EXPORT_EXCEL);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return LocationConstants.PATH_EXPORT_EXCEL +
                new StringBuilder()
                        .append("[").append(FileUtils.getStrDate(System.currentTimeMillis(), "yyyy_MM_dd_hh_mm_ss"))
                        .append("]").append("Danh sách Book").append(".xlsx").toString();
    }
}
