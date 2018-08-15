package ua.sombra.domain;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.sombra.entity.BookEntity;
@Getter
@Setter
@NoArgsConstructor

public class AuthorDTO {
	private Long id;
	
private String name;
	
	private String gender;
	
	private Date born;
	
	private List<BookEntity> books;
	



}
