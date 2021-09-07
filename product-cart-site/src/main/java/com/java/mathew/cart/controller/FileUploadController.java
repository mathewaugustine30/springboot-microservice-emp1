package com.java.mathew.cart.controller;

import java.io.IOException;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.java.mathew.cart.entity.Document;
import com.java.mathew.cart.service.FileUploadService;


@Controller
@RequestMapping("/") 
public class FileUploadController {
	
	@Autowired
	FileUploadService fileUploadService;
	
	
	@GetMapping("/fileupload")
    public String index(Model model)  
    {  
        return "fileUpload";  
    }   
	
	@PostMapping("/saveFile")
    public String edit(@PathParam("file") MultipartFile file,Model model)  
    {  
		
		Document documetUploaded = fileUploadService.saveFile(file);
		String downloadPath = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(documetUploaded.getDocId().toString()).toUriString();
		model.addAttribute("downloadPath", downloadPath);
		return "fileUpload";
    } 

}
