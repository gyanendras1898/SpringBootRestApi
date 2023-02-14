package com.gyan.model.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gyan.bean.User;
import com.gyan.model.helper.UserRowMapper;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User getUser(User user) {
		String query="select * from MyUser where username=? and pwd=?";
		User usr=jdbcTemplate.queryForObject(query, new UserRowMapper(), user.getUserName(),user.getPassword());
		return usr;
	}

}
