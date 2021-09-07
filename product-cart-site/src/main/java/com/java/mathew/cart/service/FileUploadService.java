package com.java.mathew.cart.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.java.mathew.cart.entity.Document;


public interface FileUploadService {
	
	Document saveFile(MultipartFile file);
	

}
