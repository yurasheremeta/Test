package ua.sombra.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;;



@Entity
@Table(name = "book")
public class BookEntity extends BaseEntity {
	
	private String name;
	
	private String published;
	
	private String genre;

	private int rating;
	@ManyToMany
	@JoinTable(name = "author_book" , joinColumns = @JoinColumn(name = "book_id"), 
	inverseJoinColumns = @JoinColumn (name = "author_id"))
	private List<AuthorEntity> authors;

	public BookEntity(){

	}

	public String getName() {
		return name;
	}

	public String getPublished() {
		return published;
	}

	public String getGenre() {
		return genre;
	}

	public int getRating() {
		return rating;
	}

	public List<AuthorEntity> getAuthors() {
		return authors;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setAuthors(List<AuthorEntity> authors) {
		this.authors = authors;
	}
}
