package dao;

import java.util.List;

import model.User_info;

public interface UserDao {
	void insertUser(User_info user_info);
	User_info selectUserById(String user_id);
	List<String> selectUserIdByNameAndEmail(User_info user_info);
	String selectUserPassword(User_info user_info);
	void updateUser(User_info user_info);
	void updateUserStat(User_info user_info);
}
