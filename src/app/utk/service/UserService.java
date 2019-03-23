package app.utk.service;

import java.util.List;

import app.utk.model.User;

public interface UserService {
	public List<User> getAllUsers();
	public User getUser(long userId);
	public User getUserByName(String name);
	public long addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(long userId);
}
