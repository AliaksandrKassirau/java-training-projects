package com.epam.webapplication.services;

import java.util.List;

import com.epam.webapplication.domain.User;

public interface UserService {

	List<User> getAllUsers();

	User getByLogin(String login);

	void deleteUser(Integer id);

}
