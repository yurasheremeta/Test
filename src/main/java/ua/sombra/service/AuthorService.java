package ua.sombra.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;
import ua.sombra.domain.AuthorDTO;
import ua.sombra.entity.AuthorEntity;

public interface AuthorService {
	
	void SaveAuthor(AuthorDTO dto);
	
	List<AuthorDTO> findAllAuthors();
	
	AuthorDTO findAuthorById(Long id);
	
	void updateAuthor(AuthorDTO dto);
	
	void deleteAuthor(Long id);
	List<AuthorDTO> findAuthorOlder55();

}
