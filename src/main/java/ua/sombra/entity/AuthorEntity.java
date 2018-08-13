package ua.sombra.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "author")
public class AuthorEntity extends BaseEntity{
	
	private String name;
	
	private String gender;
	
	private Date born;
	
	@ManyToMany(mappedBy = "authors")
	private List<BookEntity> books;


	public AuthorEntity(){

	}
	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public Date getBorn() {
		return born;
	}

	public List<BookEntity> getBooks() {
		return books;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	public void setBooks(List<BookEntity> books) {
		this.books = books;
	}

}
