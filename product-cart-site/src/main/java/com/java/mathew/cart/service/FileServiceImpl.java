package com.java.mathew.cart.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.mathew.cart.dao.FileUploadRepository;
import com.java.mathew.cart.dao.ProductRepository;
import com.java.mathew.cart.entity.Document;
import com.java.mathew.cart.entity.Product;

@Service
public class FileServiceImpl implements FileUploadService {
	
	@Autowired
	private FileUploadRepository fileUploadRepository;
	
	@Value("${data.filepath}")
	private String folderPath;

	@Override
	public Document saveFile(MultipartFile file) {
		System.out.println(file);
		Document document = new Document();
		
		document.setDocName(file.getOriginalFilename());
		document.setDocType(file.getContentType());
		try {
			document.setFile(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		saveFileToDirectory(file);
		return fileUploadRepository.save(document);
	}
	
	private void saveFileToDirectory(MultipartFile uploadedFile) {
		
		String filePath = createFolderPath("jpmc", "mathew", "docs");
		Path folderPath = Paths.get(filePath);
		File fileToCreate = new File(filePath);  
		if(!fileToCreate.exists()) {
			fileToCreate.mkdirs();
		}
		try {
			Files.copy(uploadedFile.getInputStream(),folderPath.resolve(uploadedFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
	}
	
	private String createFolderPath(String compantId,String userId,String categorey) {
		
		return folderPath
				.concat(File.separator).concat(compantId)
				.concat(File.separator).concat(userId)
				.concat(File.separator).concat(categorey);

		
	}

	
}
