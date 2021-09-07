package com.java.mathew.cart.dao;

import org.springframework.data.repository.CrudRepository;

import com.java.mathew.cart.entity.Document;

public interface FileUploadRepository extends CrudRepository<Document, Integer> {

}
