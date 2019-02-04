package com.craftioncode.library.domain.users.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.craftioncode.library.domain.users.User;
import com.craftioncode.library.domain.users.UserBuilder;

public class UsersDAO {

	private static List<User> users = new ArrayList<>();

	static {
		User user1 = UserBuilder.builder().setName("test").setSurname("test").setRole("test").setLogin("test")
				.setPassword("test").setCity("test").build();
		User user2 = UserBuilder.builder().setName("test").setSurname("test").setRole("test").setLogin("Admin")
				.setPassword("admin").setCity("test").build();
		users.add(user1);
		users.add(user2);
	}

	public static boolean add(User user) {
		Optional<User> userOpt = getById(user.getId());
		boolean doesUserAlreadyExists = userOpt.isPresent();
		if (!doesUserAlreadyExists) {
			users.add(user);
		}
		return !doesUserAlreadyExists;
	}

	public static List<User> getAll() {
		return users;
	}

	public static boolean delete(int id) {
		return users.removeIf(user -> user.getId().equals(id));
	}

	public static boolean update(int id, String name, String surname, String login, String password, String city,
	                             String role) {
		Optional<User> userOpt = getById(id);
		userOpt.ifPresent(user -> {
			user.setName(name);
			user.setSurname(surname);
			user.setLogin(login);
			user.setPassword(password);
			user.setCity(city);
			user.setRole(role);
		});
		return userOpt.isPresent();
	}

	public static Optional<User> getByLogin(String login) {
		return users.stream()
				.filter(user -> user.getLogin().equals(login))
				.findFirst();
	}

	private static Optional<User> getById(int id) {
		return users.stream()
				.filter(user -> user.getId().equals(id))
				.findFirst();
	}


}
