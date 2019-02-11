package com.craftioncode.library.domain.books;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Deprecated
public class BooksDAO {

	private static List<Book> books = new ArrayList<>();

	static {
		Book book1 = BookBuilder.builder().setAuthor("test").setTitle("test").setIsbn("test").setYear(2000)
				.build();
		Book book2 = BookBuilder.builder().setAuthor("test").setTitle("test").setIsbn("test").setYear(2000)
				.build();
		books.add(book1);
		books.add(book2);
	}

	public static boolean add(Book book) {
		Optional<Book> bookOpt = getById(book.getId());
		boolean doesBookAlreadyExists = bookOpt.isPresent();
		if (!doesBookAlreadyExists) {
			books.add(book);
		}
		return !doesBookAlreadyExists;
	}

	public static List<Book> getAll() {
		return books;
	}

	public static boolean delete(int id) {
		return books.removeIf(book -> book.getId() == id);
	}

	public static boolean update(int id, String author, String title, String isbn, int year) {
		Optional<Book> bookOpt = getById(id);

		bookOpt.ifPresent(book -> {
			book.setAuthor(author);
			book.setTitle(title);
			book.setIsbn(isbn);
			book.setYear(year);
		});

		return bookOpt.isPresent();
	}

	public static Optional<Book> getById(int id) {
		return books.stream()
				.filter(book -> book.getId() == id)
				.findFirst();
	}
}
