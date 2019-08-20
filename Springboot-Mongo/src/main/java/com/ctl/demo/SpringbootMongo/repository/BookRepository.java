package com.ctl.demo.SpringbootMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ctl.demo.SpringbootMongo.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{
	

}
