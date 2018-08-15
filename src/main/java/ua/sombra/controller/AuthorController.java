package ua.sombra.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.sombra.domain.AuthorDTO;
import ua.sombra.entity.AuthorEntity;
import ua.sombra.service.AuthorService;
@RestController
@RequestMapping("author")
public class AuthorController {
	
	private final AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}
	@PostMapping
	public ResponseEntity<Void> saveAuthor(@RequestBody AuthorDTO dto){
		authorService.SaveAuthor(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<AuthorEntity>> findAllAuthor(){
		List<AuthorEntity> entity = authorService.findAllAuthors();
		return new ResponseEntity<>(entity , HttpStatus.OK);
	}

	//SELECT *  , count(ab.author_id) FROM author_book ab join author a on ab.book_id = a.id;


	@GetMapping("/findById/{authorId}")
	public ResponseEntity<AuthorDTO> findAuthorById(@PathVariable("authorId") Long id){
		AuthorDTO dto = authorService.findAuthorById(id);
		return new ResponseEntity<>(dto , HttpStatus.OK);
	}
	@PutMapping("/update/{authorId}")
	public ResponseEntity<Void> updateAuthor(@PathVariable("authorId") Long id , @RequestBody AuthorDTO dto){
		AuthorDTO authorDTO = authorService.findAuthorById(id);
		if(authorDTO != null) {
			dto.setId(id);
			authorService.SaveAuthor(dto);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/delete/{authorId}")
	public ResponseEntity<Void> deleteAuthorById(@PathVariable("authorId") Long id){
		AuthorDTO authorDTO = authorService.findAuthorById(id);
		if(authorDTO != null) {
			authorService.deleteAuthor(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("/findOlder55")
	public ResponseEntity<List<AuthorDTO>> findOlder55(){
		List<AuthorDTO> authordto = authorService.findAuthorOlder55();
		return new ResponseEntity<>(authordto, HttpStatus.OK);

	}
	@GetMapping("/findAuthor")
	public ResponseEntity<List<AuthorDTO>> findAuthorWithMostBooks(){
		List<AuthorDTO> dto = authorService.findAuthorWithMostCountOfBooks();
		return new ResponseEntity<>(dto , HttpStatus.OK);
	}

}
