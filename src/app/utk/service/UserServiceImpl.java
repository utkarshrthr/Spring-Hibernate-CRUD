package app.utk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.utk.dao.UserDAO;
import app.utk.model.User;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public User getUser(long userId) {
		return userDAO.getUser(userId);
	}

	@Override
	public long addUser(User user) {
		return userDAO.addUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return userDAO.updateUser(user);
	}

	@Override
	public boolean deleteUser(long userId) {
		return userDAO.deleteUser(userId);
	}

	@Override
	public User getUserByName(String name) {
		return userDAO.getUserByName(name);
	}
}
