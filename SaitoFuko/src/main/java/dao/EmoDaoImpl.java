package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Condition;
import model.Emo_cart;
import model.Emoticon_info;
import model.Have_emo_info;
import model.Have_emoticon;
@Repository
public class EmoDaoImpl implements EmoDao {

	@Autowired
	private SqlSession session;
	
	
	public List<Emoticon_info> selectEmoticonList(Condition c) {
		return session.selectList("mapper.myMapper.selectEmoticonList",c);
	}
	public Integer selectEmoCount() {
		return session.selectOne("mapper.myMapper.selectEmoCount");
	}
	public List<Emo_cart> selectEmoCart(String user_id) {
		return session.selectList("mapper.myMapper.selectEmoCart",user_id);
	}
	public void inCart(Emo_cart emo_cart) {
		session.insert("mapper.myMapper.inCart",emo_cart);
	}
	public void outCart(Emo_cart emo_cart) {
		session.delete("mapper.myMapper.outCart",emo_cart);
		
	}
	public List<Have_emoticon> selectHaveEmoticon(String user_id) {
		return session.selectList("mapper.myMapper.selectHaveEmoticon",user_id);
	}
	public Emoticon_info selectEmoticon(String emo_id) {
		return session.selectOne("mapper.myMapper.selectEmoticon", emo_id);
	}
	public List<Have_emo_info> selectHaveEmoInfo(String user_id) {
		// TODO Auto-generated method stub
		return  session.selectList("mapper.myMapper.selectHaveEmoInfo", user_id);
	}
	public List<Have_emo_info> selectCartEmoInfo(String user_id) {
		// TODO Auto-generated method stub
		return session.selectList("mapper.myMapper.selectCartEmoInfo", user_id);
	}
	public void intsertHaveEmo(Have_emoticon have) {
		session.insert("insertHaveEmo",have);
		
	}
	
	
	
}
