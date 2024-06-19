package javalearner.comparator;

import java.util.Comparator;

import javalearner.dto.BookDTO;

public class SortingByBookNameComparator implements Comparator<BookDTO> {

	@Override
	public int compare(BookDTO o1, BookDTO o2) {

		return o1.getBookName().compareToIgnoreCase(o2.getBookName());
	}

}
