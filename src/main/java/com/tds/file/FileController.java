package com.tds.file;

import com.tds.response.FileResponse;
import com.tds.response.ResponseObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tds/file")
@CrossOrigin(origins = "*")
public class FileController {
    public final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/save-file")
    public ResponseObject<File> saveFile(@RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseObject<>(true, "Success", "Saved file successfully", fileService.saveFile(file));
    }

    @GetMapping("/files")
    public ResponseObject<List<FileResponse>> getFiles() {
        List<FileResponse> fileList = fileService.findAllFiles();
        return new ResponseObject<>(true, "Success", "Success", fileList);
    }

    @GetMapping("/files/{filePath}")
    public ResponseObject<Object> getFile(@PathVariable String filePath) {
        return new ResponseObject<>(true, "Success", "Success", fileService.getFile(filePath));
    }

}
