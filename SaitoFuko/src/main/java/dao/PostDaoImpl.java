package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Condition;
import model.Post;

@Repository
public class PostDaoImpl implements PostDao{
	
	@Autowired
	private SqlSession session;
	

	public void insertPost(Post p) {
		session.insert("insertPost",p);
	}

	public List<Post> selectPostList(Condition c) {

		return session.selectList("selectPostList", c);
	}

	public Post selectPostDetail(Integer post_no) {
		return session.selectOne("selectPostDetail",post_no);
	}

	public void deletePost(Post p) {
		session.delete("deletePost",p);
	}

	public void updatePost(Post p) {
		session.update("updatePost",p);
		
	}

	public Integer selectMaxPostNo() {
		Integer a = session.selectOne("selectMaxPostNo");
		if(a==null) {
			a=0;
		}
		return a;
	}

	public Integer selectMaxGruopLayer() {
		Integer a = session.selectOne("selectMaxGruopLayer");
		if(a==null) {
			a=0;
		}
		return a;
	}

	public void updateGroupReply(Post p) {
		session.update("updateGroupReply");
	}

	public Integer selectboardCnt(Integer board_id) {
		Condition c = new Condition(); c.setBoard_id(board_id);
		Integer a= session.selectOne("selectboardCnt",c);
		if(a==null) {
			a=0;
		}
		return a;
	}

	public List<Post> selectPostListAll(Condition c) {
		return session.selectList("selectPostListAll",c);
	}

}
