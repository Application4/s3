package com.javatechie.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
public class StorageService {

    @Autowired
    private AmazonS3 amazonS3Client;

    public void uploadFile(String keyName, MultipartFile file) throws IOException {
        var putObjectResult = amazonS3Client.putObject("myapp-bucket8", keyName, file.getInputStream(), null);
        log.info(String.valueOf(putObjectResult.getMetadata()));
    }

    public S3Object getFile(String keyName) {
        return amazonS3Client.getObject("myapp-bucket8", keyName);
    }

}
