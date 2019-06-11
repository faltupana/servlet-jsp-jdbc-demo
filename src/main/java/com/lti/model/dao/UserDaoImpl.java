package com.lti.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.model.beans.User;
import com.lti.utils.DBConnectionUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public int store(User user) {
		// TODO Auto-generated method stub
		int seqNumber = 0;
		try {
			String seqQuery = "select user_tbale_pk_seq.nextval from dual";
			String insertQuery = "insert into user_table values (?,?,?,?)";
			Connection connection = DBConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(seqQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				seqNumber = resultSet.getInt(1);
			}
			PreparedStatement insertPreparedStatement = connection
					.prepareStatement(insertQuery);
			insertPreparedStatement.setInt(1, seqNumber);
			insertPreparedStatement.setString(2, user.getName());
			insertPreparedStatement.setString(3, user.getPassword());
			insertPreparedStatement.setString(4, user.getPhoneNumber());
			insertPreparedStatement.executeUpdate();
			resultSet.close();
			preparedStatement.close();
			insertPreparedStatement.close();
			connection.close();
		} catch (SQLException exception) {
			exception.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return seqNumber;

	}

	@Override
	public User login(int id, String password) {
		User user = new User();
		try {
			String loginQuery = "select id,name,password,phonenumber from user_table where id=?";
			Connection connection = DBConnectionUtil.getConnection();
			PreparedStatement psmt = connection.prepareStatement(loginQuery);
			psmt.setInt(1, id);
			ResultSet resultSet = psmt.executeQuery();

			if (resultSet.next()) {
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
				user.setPhoneNumber(resultSet.getString(4));
			}
			resultSet.close();
			psmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<User>();
		try {
			String loginQuery = "select id,name,phonenumber from user_table";
			Connection connection = DBConnectionUtil.getConnection();
			PreparedStatement psmt = connection.prepareStatement(loginQuery);
			ResultSet resultSet = psmt.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setPhoneNumber(resultSet.getString(3));
				userList.add(user);
				//resultSet.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User changePassword(int id, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

}
