package com.craftioncode.library.domain.books;

public class BookBuilder {
	private int id;
	private String author;
	private String title;
	private String isbn;
	private int year;

	private BookBuilder() {
	}

	public static BookBuilder builder() {
		return new BookBuilder();
	}

	public BookBuilder setAuthor(String author) {
		this.author = author;
		return this;
	}

	public BookBuilder setTitle(String title) {
		this.title = title;
		return this;
	}

	public BookBuilder setIsbn(String isbn) {
		this.isbn = isbn;
		return this;
	}

	public BookBuilder setYear(int year) {
		this.year = year;
		return this;
	}

	public BookBuilder setId(int id) {
		this.id = id;
		return this;
	}

	public Book build() {
		return new Book(id, author, title, isbn, year);
	}
}