package ua.sombra.service;

import java.util.List;

import ua.sombra.domain.BookDTO;

public interface BookService {
	
	void create(BookDTO dto);
	
	List<BookDTO> findAllBooks();
	
	BookDTO findBookById(Long id);
	
	void updateBook(BookDTO dto);
	
	void deleteBook(Long id);
	

}
