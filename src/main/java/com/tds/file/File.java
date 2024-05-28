package com.tds.file;

import jakarta.persistence.*;

@Entity
//@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String fileId;

    String fileName;

    String fileType;

    String fileSize;

    String filePath;

    byte[] fileContent;

    public File() {
    }

    public File(String fileId, String fileName, String fileType, String fileSize, String filePath, byte[] fileContent) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.filePath = filePath;
        this.fileContent = fileContent;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }
}
