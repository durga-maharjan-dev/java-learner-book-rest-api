package javalearner.service;

import java.util.List;

import javalearner.dto.BookDTO;

public interface BookService {

	void postBook(BookDTO dto);

	List<BookDTO> getBooks();

	BookDTO getById(int id);

	void updateBook(BookDTO dto, int id);

	void deleteById(int id);

}
