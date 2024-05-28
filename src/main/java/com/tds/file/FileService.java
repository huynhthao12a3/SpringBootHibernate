package com.tds.file;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.*;

@Service
public class FileService {
    public final IFileRepository fileRepository;

    public FileService(IFileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public File saveFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String fileType = "." + fileName.substring(fileName.lastIndexOf(".") + 1);
        String fileSize = String.valueOf(file.getSize());
        String filePath = file.getOriginalFilename();
        byte[] fileContent = file.getBytes();

        File newFile = new File();
        newFile.setFileName(fileName);
        newFile.setFileType(fileType);
        newFile.setFileSize(fileSize);
        newFile.setFilePath(filePath);
        newFile.setFileContent(fileContent);

        return fileRepository.save(newFile);
    }

    public List<File> findAllFiles() {
        List<File> fileList = fileRepository.findAll();
        fileList.forEach(file -> {
            String filePath = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/" + file.getFileId()).toUriString();
            file.setFilePath(filePath);
        });
        return fileList;
    }

    public String getFile(String fileId) {
        File file = fileRepository.findById(fileId).orElse(null);
//        byte[] fileContent = Objects.requireNonNull(file).getFileContent();
        if (file != null) {
            String fileType = file.getFileType().substring(file.getFileType().lastIndexOf(".") + 1);
            String base64String = Base64.getEncoder().encodeToString(file.getFileContent());
            return "data:image/"+ fileType +";base64," + base64String;
        }
        return "";
//        System.out.println(Arrays.toString(fileContent));
    }
}
