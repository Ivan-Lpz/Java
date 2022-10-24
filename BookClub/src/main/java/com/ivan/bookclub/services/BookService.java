package com.ivan.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivan.bookclub.models.Book;
import com.ivan.bookclub.repos.BookRepo;



@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	
	//CREATE
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	//READ ALL
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	
	//READ ONE
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
			
	}
	//UPDATE/EDIT
	public Book updateBook(Book book) {
		Book updateBook = bookRepo.save(book);
		return updateBook;
		
	}
	
	//DELETE 
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	
}
