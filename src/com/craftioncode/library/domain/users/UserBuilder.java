package com.craftioncode.library.domain.users;

public class UserBuilder {
	private Integer id;
	private String name;
	private String surname;
	private String role;
	private String login;
	private String password;
	private String city;

	public static UserBuilder builder(){
		return new UserBuilder();
	}

	public UserBuilder setId(Integer id) {
		this.id = id;
		return this;
	}

	public UserBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public UserBuilder setSurname(String surname) {
		this.surname = surname;
		return this;
	}

	public UserBuilder setRole(String role) {
		this.role = role;
		return this;
	}

	public UserBuilder setLogin(String login) {
		this.login = login;
		return this;
	}

	public UserBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	public UserBuilder setCity(String city) {
		this.city = city;
		return this;
	}

	public User build() {
		return new User(id, name, surname, role, login, password, city);
	}
}