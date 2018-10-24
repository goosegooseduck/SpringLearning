package com.ninjaswithguitars.SpringBootTutorial.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Book 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String isbn;
	private String title;
	private String publisher;
	
	@ManyToMany
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors = new HashSet<>();
	
	public Book()
	{	
	}
	
	public Book(String title, String isbn, String publisher)
	{
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
	}
	
	public Book(String title, String isbn, String publisher, Set<Author> authors)
	{
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
		this.authors = authors;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public Long getId()
	{
		return this.id;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}
	
	public String getIsbn()
	{
		return this.isbn;
	}
	
	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}
	
	public String getPublisher()
	{
		return publisher;
	}
	
	public void setAuthors(Set<Author> authors)
	{
		this.authors = authors;
	}
	
	public Set<Author> getAuthors()
	{
		return this.authors;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		
		if (o == null || getClass() != o.getClass())
			return false;
		
		Book book = (Book)o;
		
		return id != null ? id.equals(book.id): book.id == null; 
	}
	
	@Override
	public int hashCode()
	{
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() 
	{
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", publisher=" + publisher + ", authors="
				+ authors + "]";
	}
	
	
}
