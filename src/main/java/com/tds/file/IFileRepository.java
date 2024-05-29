package com.tds.file;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IFileRepository extends JpaRepository<File, String> {
    File findByFilePathEndsWith(String filePath);
}
