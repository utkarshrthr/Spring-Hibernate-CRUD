package app.utk.dao;

import java.util.List;

import app.utk.model.User;

public interface UserDAO {
	public List<User> getAllUsers();
	public User getUser(long userId);
	public User getUserByName(String userName);
	public long addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(long userId);
}
