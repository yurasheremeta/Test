package ua.sombra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//"name": "Dark",
//"published": "21-09-23",
//"genre": "fantastic",
//"rating": 1
import ua.sombra.domain.BookDTO;
import ua.sombra.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	private final BookService bookService;
	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	@PostMapping
	public ResponseEntity<Void> createBook(@RequestBody BookDTO dto){
		bookService.create(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	@GetMapping
	public ResponseEntity<List<BookDTO>> findAllBooks(){
		List<BookDTO> dtos = bookService.findAllBooks();
		return new ResponseEntity<>(dtos , HttpStatus.OK);
	}
	@GetMapping("/findById/{bookId}")
 	public ResponseEntity<BookDTO> findBookById(@PathVariable("bookId") Long id){
		BookDTO dto = bookService.findBookById(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	@PutMapping("/update/{bookId}")
	public ResponseEntity<Void> updateBook(@PathVariable("bookId") Long id , @RequestBody BookDTO dto){
		BookDTO bookFromDB = bookService.findBookById(id);
		if(bookFromDB != null){
			dto.setId(id);
			bookService.create(dto);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<BookDTO> deleteBookById(@PathVariable("bookId") Long id){
		BookDTO dto = bookService.findBookById(id);
		if(dto != null){
			bookService.deleteBook(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
