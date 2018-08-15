package ua.sombra.domain;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.sombra.entity.AuthorEntity;
@Getter
@Setter
@NoArgsConstructor

public class BookDTO {
	
	private Long id;
	
	private String name;
	
	private String published;
	
	private String genre;
	
	private int rating;
	
	private List<AuthorEntity> authors;

}
