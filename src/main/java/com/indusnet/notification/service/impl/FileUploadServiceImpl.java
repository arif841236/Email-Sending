package com.indusnet.notification.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.indusnet.notification.dto.FileUploadSuccessResponse;
import com.indusnet.notification.service.FileUploadService;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Override
	public FileUploadSuccessResponse uploadFile(MultipartFile[] files) throws IOException {
		//String pathDirectory = new ClassPathResource("static/image").getFile().getAbsolutePath();
		List<String> attachmentList = new ArrayList<>();
		String pathDirectory = "D:\\attachedFile";
		for (MultipartFile file : files) {
			Files.copy(file.getInputStream(), Paths.get(pathDirectory+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			attachmentList.add(pathDirectory.concat("\\"+file.getOriginalFilename()));
		}
		return FileUploadSuccessResponse.builder().attachedFile(attachmentList.toArray(new String[attachmentList.size()])).status(HttpStatus.OK.value()).message("Files Uploaded Successfully").build();
	}

}
