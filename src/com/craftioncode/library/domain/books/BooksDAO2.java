package com.craftioncode.library.domain.books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.craftioncode.library.db.DBManager;

public class BooksDAO2 {

	public static void addTestData() {
		try (Connection connection = DBManager.openConnection()) {
			Book book1 = BookBuilder.builder().setAuthor("test").setTitle("test").setIsbn("test").setYear(2000)
					.build();
			Book book2 = BookBuilder.builder().setAuthor("test").setTitle("test").setIsbn("test").setYear(2000)
					.build();
			add(book1, connection);
			add(book2, connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void add(Book book, Connection connection) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(
				"INSERT INTO book (author, title, isbn, year) " +
						"VALUES (?,?,?,?);");
		statement.setString(1, book.getAuthor());
		statement.setString(2, book.getTitle());
		statement.setString(3, book.getIsbn());
		statement.setInt(4, book.getYear());
		statement.executeUpdate();
		statement.close();
	}

	public static List<Book> getAll() {
		return null;
	}

	public static boolean delete(int id) {
		return false;
	}

	public static boolean update(int id, String author, String title, String isbn, int year) {
		return true;
	}

	public static Optional<Book> getById(int id) {
		return Optional.empty();
	}

}
