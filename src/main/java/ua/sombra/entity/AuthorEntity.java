package ua.sombra.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "author")
public class AuthorEntity extends BaseEntity{
	
	private String name;
	
	private String gender;
	
	private Date born;
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "authors")
	private List<BookEntity> books;

}
