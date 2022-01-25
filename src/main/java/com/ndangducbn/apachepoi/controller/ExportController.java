package com.ndangducbn.apachepoi.controller;

import com.ndangducbn.apachepoi.service.ExportExcelService;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/api/")
public class ExportController {
    private final ExportExcelService exportExcel;

    public ExportController(ExportExcelService exportExcel) {
        this.exportExcel = exportExcel;
    }

    @RequestMapping(value = "v1/export-excel", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> exportExcel() throws IOException {
        String path = this.exportExcel.exportExcel();
        File file = FileUtils.getFile(path);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                // Content-Type
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                // Contet-Length
                .contentLength(file.length()) //
                .body(resource);
    }
}
