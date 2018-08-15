package ua.sombra.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor



@Entity
@Table(name = "book")
public class BookEntity extends BaseEntity {
	
	private String name;
	
	private String published;
	
	private String genre;

	private int rating;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "author_book" , joinColumns = @JoinColumn(name = "book_id"), 
	inverseJoinColumns = @JoinColumn (name = "author_id"))
	private List<AuthorEntity> authors;
}
