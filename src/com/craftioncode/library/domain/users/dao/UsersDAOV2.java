package com.craftioncode.library.domain.users.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.craftioncode.library.db.DBManager;
import com.craftioncode.library.domain.users.User;
import com.craftioncode.library.domain.users.UserBuilder;

public class UsersDAOV2 {

	public static void addTestData() {
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

	public static void add(User user, Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		String sql = insertUserToDB(user);
		statement.executeUpdate(sql);
		statement.close();

	}

	public static List<User> getAll() {
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

	private static String insertUserToDB(User user) {
		return String.format("INSERT INTO user (`name`, `surname`, `role`, `login`, `password`, `city`)" +
						" VALUES ('%s','%s','%s','%s','%s','%s')",
				user.getName(),
				user.getSurname(),
				user.getRole(),
				user.getLogin(),
				user.getPassword(),
				user.getCity());
	}

}
