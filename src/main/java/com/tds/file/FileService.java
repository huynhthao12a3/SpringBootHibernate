package com.tds.file;

import com.tds.response.FileResponse;
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
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
        String fileSize = String.valueOf(file.getSize());
        String filePath = file.getOriginalFilename() + "_" + new Date().getTime();
        byte[] fileContent = file.getBytes();

        File newFile = new File();
        newFile.setFileName(fileName);
        newFile.setFileType(fileType);
        newFile.setFileSize(fileSize);
        newFile.setFilePath(filePath);
        newFile.setFileContent(fileContent);

        File fileItem = fileRepository.save(newFile);
        return fileRepository.findById(fileItem.getFileId()).orElse(null);
    }

    public List<FileResponse> findAllFiles() {
        List<FileResponse> fileResponseList = new ArrayList<>();
        List<File> fileList = fileRepository.findAll();

        for (File file : fileList) {
            FileResponse fileResponse = new FileResponse();
            String base64String = Base64.getEncoder().encodeToString(file.getFileContent());
            String fileData = "data:image/" + file.getFileType() + ";base64," + base64String;

            fileResponse.setFileId(file.getFileId());
            fileResponse.setFileName(file.getFileName());
            fileResponse.setFileType(file.getFileType());
            fileResponse.setFileSize(file.getFileSize());
            fileResponse.setFilePath(file.getFilePath());
            fileResponse.setFileData(fileData);

            fileResponseList.add(fileResponse);
        }
        ;

        return fileResponseList;
    }

    public String getFile(String filePath) {
        File file = fileRepository.findByFilePathEndsWith(filePath);
        if (file != null) {
            String base64String = Base64.getEncoder().encodeToString(file.getFileContent());
            return "data:image/" + file.getFileType() + ";base64," + base64String;
        }
        return "";
    }
}
