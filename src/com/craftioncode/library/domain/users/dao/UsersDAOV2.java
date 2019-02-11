package com.craftioncode.library.domain.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;

import com.craftioncode.library.db.DBManager;
import com.craftioncode.library.domain.users.User;
import com.craftioncode.library.domain.users.UserBuilder;

@Stateless
public class UsersDAOV2 {

	public void addTestData() {
		try {
			Random random = new Random();

			Connection connection = DBManager.openConnection();
			User user1 = UserBuilder.builder().setName("test").setSurname("test").setRole("test")
					.setLogin("test" + random.nextInt())
					.setPassword("test").setCity("test").build();
			User user2 = UserBuilder.builder().setName("test").setSurname("test").setRole("test")
					.setLogin("Admin" + random.nextInt())
					.setPassword("admin").setCity("test").build();
			add(user1, connection);
			add(user2, connection);
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void add(User user, Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		String sql = insertUserToDB(user);
		statement.executeUpdate(sql);
		statement.close();
	}

	public void add(User user) {
		try (Connection connection = DBManager.openConnection()) {
			add(user, connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		try (Connection connection = DBManager.openConnection()) {
			//use prepared statement -> sql injection avoid
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
			while (resultSet.next()) {
				User user = UserBuilder.builder()
						.setSurname(resultSet.getString("surname"))
						.setLogin(resultSet.getString("login"))
						.setCity(resultSet.getString("city"))
						.setName(resultSet.getString("name"))
						.setPassword(resultSet.getString("password"))
						.setRole(resultSet.getString("role"))
						.setId(resultSet.getInt("id"))
						.build();
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	public User getByLogin(String name) {
		User user = null;
		try (Connection connection = DBManager.openConnection()) {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE login=?;");
			statement.setString(1, name);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				user = UserBuilder.builder()
						.setSurname(resultSet.getString("surname"))
						.setLogin(resultSet.getString("login"))
						.setCity(resultSet.getString("city"))
						.setName(resultSet.getString("name"))
						.setPassword(resultSet.getString("password"))
						.setRole(resultSet.getString("role"))
						.setId(resultSet.getInt("id"))
						.build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	private String insertUserToDB(User user) {
		return String.format("INSERT INTO user (`name`, `surname`, `role`, `login`, `password`, `city`)" +
						" VALUES ('%s','%s','%s','%s','%s','%s')",
				user.getName(),
				user.getSurname(),
				user.getRole(),
				user.getLogin(),
				user.getPassword(),
				user.getCity());
	}

	public void update(User user) {
		try (Connection connection = DBManager.openConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"Update user SET name = ?, surname = ?, role = ?, login = ?, " +
							"password = ?, city = ? WHERE id = ?;");
			statement.setString(1, user.getName());
			statement.setString(2, user.getSurname());
			statement.setString(3, user.getRole());
			statement.setString(4, user.getLogin());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getCity());
			statement.setInt(7, user.getId());
			statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void delete(int id) {
		try (Connection connection = DBManager.openConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"DELETE FROM user WHERE id =?;");
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
