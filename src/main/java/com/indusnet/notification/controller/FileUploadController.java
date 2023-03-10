package com.indusnet.notification.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.indusnet.notification.dto.FileUploadSuccessResponse;
import com.indusnet.notification.service.FileUploadService;

@RestController
@RequestMapping("/api/v0.0.1/notification")
@CrossOrigin
public class FileUploadController {
	
	@Autowired
	private FileUploadService uploadService;
	
	@PostMapping("/uploadFile")
	public ResponseEntity<FileUploadSuccessResponse> uploadFile(@RequestParam("files") MultipartFile[] files)
			throws IOException {
		FileUploadSuccessResponse response = uploadService.uploadFile(files);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
