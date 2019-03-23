package app.utk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.utk.model.User;
import app.utk.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(path="/user/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody User getUser(@PathVariable long id) {
		return userService.getUser(id);
	}
	
	@RequestMapping(path="/users", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(path="/newuser", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody long addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping(path="/update", method=RequestMethod.PUT, produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody boolean updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@RequestMapping(path="/delete/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody boolean deleteUser(@PathVariable long id) {
		return userService.deleteUser(id);
	}
	
	@RequestMapping(path="/user", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody User getUserByName(@RequestBody String name) {
		return userService.getUserByName(name);
	}
}
