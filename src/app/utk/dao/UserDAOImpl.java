package app.utk.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.utk.model.User;

@Repository("User")
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory factory;
	
	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		try(Session session = factory.openSession()) {
			users = session.createQuery("from User").getResultList();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getUser(long userId) {
		User user = null;
		try(Session session = factory.openSession()) {
			user = session.get(User.class, userId);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	
		return user;
	}

	@Override
	public long addUser(User user) {
		long userId = 0;
		try(Session session = factory.openSession()) {
			userId = (long) session.save(user);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}

	@Override
	public boolean updateUser(User user) {
		boolean isUserUpdated = false;
		try(Session session = factory.openSession()) {
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
			isUserUpdated = true;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return isUserUpdated;
	}

	@Override
	public boolean deleteUser(long userId) {
		boolean isUserDeleted = false;
		try(Session session = factory.openSession()) {
			User user = session.get(User.class, userId);
			if(user!=null) {
				session.beginTransaction();
				session.delete(user);
				session.getTransaction().commit();
				isUserDeleted = true;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return isUserDeleted;
	}

	@Override
	public User getUserByName(String userName) {
		User user = null;
		try(Session session = factory.openSession()) {
			Query<User> query =  session.createQuery("from User where name=:name");
			query.setParameter("name", userName);
			user = (User) query.getSingleResult();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
