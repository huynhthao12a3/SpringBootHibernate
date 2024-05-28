package com.tds.file;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
            String filePath = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/").path(file.getFileId()).toUriString();
            file.setFilePath(filePath);
        });
        return fileList;
    }

    public File getFile(String fileId) {
        return fileRepository.findById(fileId).get();
    }
}
