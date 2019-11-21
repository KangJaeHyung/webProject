package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.User_info;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession session;
	
	
	public void insertUser(User_info user_info) {
		session.insert("mapper.myMapper.insertUser",user_info);
		
	}


	public User_info selectUserById(String user_id) {
		return session.selectOne("mapper.myMapper.selectUserById",user_id);
	}
	public List<String> selectUserIdByNameAndEmail(User_info user_info) {
		return session.selectList("mapper.myMapper.selectUserIdByNameAndEmail",user_info);
	}


	public String selectUserPassword(User_info user_info) {
		return session.selectOne("mapper.myMapper.selectUserPassword",user_info);
	}


	public void updateUser(User_info user_info) {
		session.update("mapper.myMapper.updateUser",user_info);
	}


	public void updateUserStat(User_info user_info) {
		session.update("mapper.myMapper.updateUserStat",user_info);
		
	}

	
}
