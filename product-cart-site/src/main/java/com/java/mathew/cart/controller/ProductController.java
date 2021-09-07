package com.java.mathew.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.mathew.cart.entity.Product;
import com.java.mathew.cart.service.ProductService;

@Controller
@RequestMapping("/")  
public class ProductController {
	
	@Autowired
	private ProductService productService;
	

	@GetMapping("/index")
    public String index(Model model)  
    {  
		model.addAttribute("products", productService.getAllProducts());
        return "index";  
    }   
	@GetMapping("/add")
    public String add(Model model)  
    {  
		model.addAttribute("product", new Product());
        return "addProduct";  
    }   
	@GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id,Model model)  
    {  
		productService.deleteProduct(Integer.valueOf(id));
        return "redirect:/index";  
    }  
	
	@PostMapping("/save")
    public String save(@ModelAttribute("product") Product product,Model model)  
    {  
		productService.addProduct(product);
        return "redirect:/index";  
    }  
	
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id,Model model)  
    {  
		Product product = productService.getProduct(Integer.valueOf(id));
		model.addAttribute("product", product);
		return "addProduct";
    }  
}
