package com.ctl.demo.SpringbootMongo.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctl.demo.SpringbootMongo.model.Book;
import com.ctl.demo.SpringbootMongo.repository.BookRepository;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("rest")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/addbook")
	@ApiResponses(value= {@ApiResponse(code=500,message="Internal Server Error"),
			@ApiResponse(code=200,message="Successfully Added to database")})
	public String saveBook(@ModelAttribute Book book) {
		bookRepository.save(book);
		return "Added book "+book.getId();
		
		
	}
	
	@GetMapping("/findallbook")
	public List<Book> getAllBook(){
		return bookRepository.findAll();
		
	}
	
	@GetMapping("/findbook/{id}")
	public Optional<Book> getBook(@PathVariable int id) {
		return bookRepository.findById(id);
		
	}
	@DeleteMapping("/deletebook/{id}")
	public String deleteBook(@PathVariable int id) {
		bookRepository.deleteById(id);
		return "deleted book "+id;
		
	}
	
	@GetMapping("/getStringdata")
	public String getStringData() {
		return "Returning the String";
		
	}
}
