package com.gyan.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gyan.bean.User;
import com.gyan.model.persistence.UserDao;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean loginCheck(User user) {
		User usr=null;
		try {
		usr=userDao.getUser(user);
		}
		catch(EmptyResultDataAccessException exception) {
			
		}
		return usr!=null;
	}

}
