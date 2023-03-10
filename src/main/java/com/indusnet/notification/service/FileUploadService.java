package com.indusnet.notification.service;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

import com.indusnet.notification.dto.FileUploadSuccessResponse;

public interface FileUploadService {

	FileUploadSuccessResponse uploadFile(MultipartFile[] files)throws IOException;

}
