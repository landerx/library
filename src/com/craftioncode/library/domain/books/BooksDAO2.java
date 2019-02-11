package com.craftioncode.library.domain.books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.craftioncode.library.db.DBManager;

@Stateless
public class BooksDAO2 {

	private Connection connection;

	@EJB
	private DBManager dbManager;

	@PostConstruct
	public void init() {
		connection = dbManager.openConnection();
	}

	@PreDestroy
	public void close() {
		dbManager.closeConnection(connection);
	}

	public void addTestData() {
		try {
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

	public void add(Book book) {
		try {
			add(book, connection);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void add(Book book, Connection connection) throws SQLException {
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

	public List<Book> getAll() {
		List<Book> books = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM book");
			while (resultSet.next()) {
				Book book = BookBuilder.builder()
						.setAuthor(resultSet.getString("author"))
						.setIsbn(resultSet.getString("title"))
						.setTitle(resultSet.getString("isbn"))
						.setYear(resultSet.getInt("year"))
						.setId(resultSet.getInt("id"))
						.build();
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	public void delete(int id) {
		try {
			PreparedStatement statement = connection.prepareStatement(
					"DELETE FROM book WHERE id =?;");
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void update(int id, String author, String title, String isbn, int year) {
		try {
			PreparedStatement statement = connection.prepareStatement(
					"Update book SET author = ?, title = ?, isbn =?, year =? WHERE id = ?;");
			statement.setString(1, author);
			statement.setString(2, title);
			statement.setString(3, isbn);
			statement.setInt(4, year);
			statement.setInt(5, id);
			statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public Book getById(int id) {
		Book book = null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM book WHERE id=?;");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				book = BookBuilder.builder()
						.setAuthor(resultSet.getString("author"))
						.setIsbn(resultSet.getString("title"))
						.setTitle(resultSet.getString("isbn"))
						.setYear(resultSet.getInt("year"))
						.setId(resultSet.getInt("id"))
						.build();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return book;
	}

}
