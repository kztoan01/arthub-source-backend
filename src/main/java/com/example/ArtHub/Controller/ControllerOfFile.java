package com.example.ArtHub.Controller;

import java.io.IOException;
import java.util.List;

import com.example.ArtHub.Service.InterfaceOfFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/files")
public class ControllerOfFile {

    @Autowired
    InterfaceOfFileService interfaceOfFileService;

    //List all file name
    @GetMapping
    public ResponseEntity<List<String>> listOfFiles() {

        List<String> files = interfaceOfFileService.listOfFiles();

        return ResponseEntity.ok(files);
    }

    //Upload file
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file) throws IOException {
        interfaceOfFileService.uploadFile(file);
        return ResponseEntity.ok("File uploaded successfully!");
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteFile(@RequestParam String fileName) {
        interfaceOfFileService.deleteFile(fileName);
        return ResponseEntity.ok("File deleted successfully!");
    }


    @GetMapping("download")
    public ResponseEntity<Resource> downloadFile(@RequestParam String fileName)  {
        ByteArrayResource resource = interfaceOfFileService.downloadFile(fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + fileName + "\"");
        return ResponseEntity.ok().
                contentType(MediaType.APPLICATION_OCTET_STREAM).
                headers(headers).body(resource);
    }
}