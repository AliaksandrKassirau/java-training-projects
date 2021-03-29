package com.epam.webapplication.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.epam.webapplication.domain.User;
import com.epam.webapplication.domain.UserRole;
import com.epam.webapplication.services.UserService;

public class ListUserService implements UserService {

	private static UserService service;

	private List<User> users = new ArrayList<User>();

	private ListUserService() {
		users.add(new User(1, "max", "max", "Maxim", UserRole.ADMIN));
		users.add(new User(2, "alex", "alex", "Alexander", UserRole.USER));
		users.add(new User(3, "max1", "max", "Maxim", UserRole.USER));
		users.add(new User(4, "max2", "max", "Maxim", UserRole.USER));
		users.add(new User(5, "max3", "max", "Maxim", UserRole.USER));
	}

	public static UserService getService() {
		if (service == null) {
			service = new ListUserService();
		}
		return service;
	}

	public List<User> getAllUsers() {
		return users;
	}

	public User getByLogin(String login) {
		return users.stream().filter(u -> u.getLogin().equals(login)).findAny().orElse(null);
	}

	public void deleteUser(Integer id) {
		User toBeDeleted = users.stream().filter(u -> u.getId().equals(id)).findAny().orElse(null);
		users.remove(toBeDeleted);
	}

}
