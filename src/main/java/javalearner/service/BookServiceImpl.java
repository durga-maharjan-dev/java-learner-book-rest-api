package javalearner.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javalearner.dao.BookRepository;
import javalearner.dto.BookDTO;
import javalearner.entity.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public void postBook(BookDTO dto) {
		Book book = new Book();
		BeanUtils.copyProperties(dto, book);
		this.bookRepository.save(book);
		
	}

	@Override
	public List<BookDTO> getBooks() {
		List<Book> bookList = this.bookRepository.findAll();
		System.out.println(bookList);
		
		List<BookDTO> dtoList = new ArrayList<>();
		BookDTO dto =null;
		
		for(Book book: bookList) {
			dto = new BookDTO();
			BeanUtils.copyProperties(book, dto);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public BookDTO getById(int id) {
		BookDTO dto = null;
		
		Optional<Book> optional = this.bookRepository.findById(id);
		if (optional.isPresent()) {
			Book book = optional.get();
			dto = new BookDTO();
			BeanUtils.copyProperties(book, dto);
			return dto;
		}
		return dto;
	}



	@Override
	public void updateBook(BookDTO dto, int id) {
		BookDTO dbBookDTO = getById(id);
		BeanUtils.copyProperties(dto, dbBookDTO);
		
		Book book = new Book();
		BeanUtils.copyProperties(dbBookDTO, book);
		this.bookRepository.save(book);
	}

	@Override
	public void deleteById(int id) {
		this.bookRepository.deleteById(id);
	}
	
	
	
	

}
