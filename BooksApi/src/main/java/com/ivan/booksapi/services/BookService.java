package com.ivan.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ivan.booksapi.models.Book;
import com.ivan.booksapi.repositories.BookRepository;

//This file here does the heavy lifting it does the CRUD

//This file is doing dependency injection for the @Repository file

//SERVICE IS WHERE WE HAVE FULL CRUD

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    //READ ALL
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    //CREATE
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    
    //READ ONE 
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    

	public void deleteBook(Long id) {	//instead of void use book to use the line below
//		return bookRepository.deleteById(id);
		bookRepository.deleteById(id);
	}
		// TODO Auto-generated method stub
	
		
	
//	public Book updateBook(Book book) {
//	
//		return bookRepository.save(book);
//	}

	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book book = bookRepository.findById(id).get();
		book.setTitle(title);
		book.setDescription(desc);
		book.setLanguage(lang);
		book.setNumberOfPages(numOfPages);
		return bookRepository.save(book);
	}
	
	
}