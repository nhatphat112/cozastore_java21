package com.cybersoft.cozastore_java21.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/demo")
public class DemoDownloadFile {
    @Value("${path.root}")
    private String spath;
    @GetMapping("downloadfile")
    public ResponseEntity<?> downloadFile(@RequestParam String filename) throws FileNotFoundException {
        // Tạo một đối tượng File từ tên tập tin được yêu cầu.
        Path path = Paths.get(spath);
        File file = new File(path.toString()+"/"+filename);

        // Tạo một InputStream từ đối tượng File.
        InputStream inputStream = new FileInputStream(file);

        // Tạo một đối tượng InputStreamResource từ InputStream.
        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);

        // Thiết lập các header để trình duyệt có thể tải xuống file.
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + filename);

        // Trả về đối tượng ResponseEntity bao lấy InputStreamResource và các header tương ứng.
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(inputStreamResource);
    }
}
