package com.craftioncode.library.domain.books;

import java.util.Objects;

public class Book {

	private final int id;

	private String author;

	private String title;

	private String isbn;

	private int year;

	public Book(int id, String author, String title, String isbn, int year) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.isbn = isbn;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Book book = (Book) o;
		return id == book.id &&
				year == book.year &&
				Objects.equals(author, book.author) &&
				Objects.equals(title, book.title) &&
				Objects.equals(isbn, book.isbn);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, author, title, isbn, year);
	}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", author='" + author + '\'' +
				", title='" + title + '\'' +
				", isbn='" + isbn + '\'' +
				", year=" + year +
				'}';
	}
}
