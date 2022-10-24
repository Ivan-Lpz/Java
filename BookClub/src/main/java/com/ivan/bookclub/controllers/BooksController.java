package com.ivan.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ivan.bookclub.models.Book;
import com.ivan.bookclub.models.User;
import com.ivan.bookclub.services.BookService;
import com.ivan.bookclub.services.UserService;

@Controller
public class BooksController {

	@Autowired
	private UserService userServ;

	@Autowired
	private BookService bookServ;

	// ---DISPLAYS PAGE WITH ALL BOOKS---
	@GetMapping("/books")
	public String home(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		// CHECK IF USER IS IN SESSION
		if (userId == null) {
			return "redirect:/";
		} else {

			User thisUser = userServ.findOne(userId);
			model.addAttribute("thisUser", thisUser);
			List<Book> allBooks = bookServ.allBooks();
			model.addAttribute("allBooks", allBooks);
			return "home.jsp";
		}
	}

	// ---PAGE TO CREATE/ADD A BOOK---
	@GetMapping("/books/new")
	public String createBook(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		//CHECK IF USER IS IN SESSION
		if (userId == null) {
			return "redirect:/";
		} else {
			Book newBook = new Book();
			model.addAttribute("newBook", newBook);
			
			return "createbook.jsp";
			
		}
	}

	// ---THIS WILL SUBMIT A BOOK TO THE DATABASE
	@PostMapping("/submitbook")
	public String submitBook(@Valid @ModelAttribute("newBook") Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "createbook.jsp";

		} else {

			bookServ.createBook(book);
			return "redirect:/books";
		}

	}

	// ---THIS WILL DISPLAY A SINGLE BOOK---
	@GetMapping("/show/book/{id}")
	public String singleBook(@PathVariable("id") Long id, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		//CHECK IF USER IS IN SESSION
		if(userId == null) {
			return "redirect:/";
		
		} else {
			Book book = bookServ.findBook(id);
			model.addAttribute("book", book);
			
			return "singlebook.jsp";
			
		}

	}

	// ---THIS PAGE WILL DISPLAY THE EDIT PAGE---
	@GetMapping("/editpage/{id}")
	public String editpage(@PathVariable("id") Long id, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		//CHECK IF USER IS IN SESSION
		if(userId == null) {
			return "redirect:/";
		} else {
			System.out.println(id);
			Book book = bookServ.findBook(id);
			model.addAttribute("newBook", book);
			return "editpage.jsp";
			
		}
	}

	// ---THIS ROUTE WILL SUBMIT THE EDIT---
	@RequestMapping(value = "/submit/edit/{id}", method = RequestMethod.PUT)
	public String submitedit(@Valid @ModelAttribute("newBook") Book book, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "editpage.jsp";

		} else {
			bookServ.updateBook(book);
			System.out.println(book);
			return "redirect:/books";
		}
	}
	//---DELETE THE BOOK---
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		bookServ.deleteBook(id);
		return "redirect:/books";
	}

}
