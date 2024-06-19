package javalearner.comparator;

import java.util.Comparator;

import javalearner.dto.BookDTO;

public class SortingByBookPriceComparator implements Comparator<BookDTO> {

	@Override
	public int compare(BookDTO o1, BookDTO o2) {
		
		return (int) (o1.getBookPrice() - o2.getBookPrice());
	}

} 
