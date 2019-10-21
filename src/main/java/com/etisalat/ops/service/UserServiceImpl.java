package com.etisalat.ops.service;

import java.time.LocalDate;
import java.util.List;

import com.etisalat.ops.dao.UserDAO;
import com.etisalat.ops.dao.UserDaoImpl;
import com.etisalat.ops.domain.User;
import com.etisalat.ops.exception.UserException;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO =new UserDaoImpl();
	@Override
	public Integer addNewUser(User user) throws UserException {
		try {			
			user.setCreateDate(LocalDate.of(2019, 10, 15));
			
			//System.out.println(user);
			return userDAO.addNewUser(user);
		}catch(Exception e) {
			e.printStackTrace();
			throw new UserException(e.getMessage(),e);
		}
		
	}
	@Override
	public User getUserDetails(Integer userId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User getUserDetails(String userName, String password) throws UserException {
		try {									
			return userDAO.getUserDetails(userName, password);
		}catch(Exception e) {
			throw new UserException(e.getMessage(),e);
		}
	}
	@Override
	public List<User> getAllUsers() throws UserException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
