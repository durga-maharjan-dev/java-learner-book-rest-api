package javalearner.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javalearner.comparator.SortingByNameComparator;
import javalearner.dto.BookDTO;
import javalearner.exception.BookNotFoundException;
import javalearner.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	@PostMapping("/book")
	public ResponseEntity<String> postBook(@RequestBody BookDTO dto){
		if (!dto.getBookName().isEmpty() && dto.getBookPrice() >= 0) {
			this.bookService.postBook(dto);
			return new ResponseEntity<String>("book record saved.", HttpStatus.OK);
		}
		throw new BookNotFoundException("Book properties are not inserted properly.");
	}
	
	@GetMapping("/book")
	public ResponseEntity<List<BookDTO>> getBooks(){
		List<BookDTO> dtoList = this.bookService.getBooks();
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<?> getById(@PathVariable int id){
		BookDTO dto =  this.bookService.getById(id);
		if (dto != null) {
			return new ResponseEntity<BookDTO>(dto, HttpStatus.FOUND);
		}
		throw new BookNotFoundException("Book Record Is Not Found");
	}
	
	@PutMapping("/book/{id}")
	public ResponseEntity<String> updateBook(@RequestBody BookDTO dto, @PathVariable int id){
		this.bookService.updateBook(dto, id);
		return new ResponseEntity<String>("Record updated.", HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable int id){
		this.bookService.deleteById(id);
		return new ResponseEntity<String>("Alert: A book record deleted!", HttpStatus.OK);
	}
	
	@GetMapping("/book/sortingByBookName")
	public ResponseEntity<List<BookDTO>> sortingByBookName(){
		List<BookDTO> dtoList = this.bookService.getBooks();
		Collections.sort(dtoList, new SortingByNameComparator());
		System.out.println(dtoList);
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}
	
	

}
