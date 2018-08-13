package ua.sombra.domain;

import java.util.List;

import ua.sombra.entity.AuthorEntity;

public class BookDTO {
	
	private Long id;
	
	private String name;
	
	private String published;
	
	private String genre;
	
	private int rating;
	
	private List<AuthorEntity> authors;
	
	public BookDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	


}
