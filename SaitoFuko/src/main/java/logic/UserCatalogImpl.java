package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import model.User_info;
@Service
public class UserCatalogImpl implements UserCatalog {
	@Autowired
	private UserDao userDao;
	
	public void insertUser(User_info user_info) {
		userDao.insertUser(user_info);
		
	}


	public User_info selectUserById(String user_id) {
		return userDao.selectUserById(user_id);
	}


	public List<String> selectUserIdByNameAndEmail(User_info user_info) {
		
		return userDao.selectUserIdByNameAndEmail(user_info);
	}
	
	public  String selectUserPassword(User_info user_info) {
		return userDao.selectUserPassword(user_info);
	}
	public void updateUser(User_info user_info) {
		userDao.updateUser(user_info);
	}
	public void updateUserStat(User_info user_info) {
		userDao.updateUserStat(user_info);
	}
	
}
