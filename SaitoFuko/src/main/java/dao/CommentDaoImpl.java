package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Comment_post;
@Repository
public class CommentDaoImpl implements CommentDao {

	@Autowired
	private SqlSession session;
	
	
	public List<Comment_post> selectCommentList(Integer post_no) {
	
		return session.selectList("selectCommentList",post_no);
	}

	public void insertComment(Comment_post comment_post) {
		session.insert("insertComment",comment_post);

	}

	public void deleteCommentOne(Integer comment_no) {
		session.delete("deleteCommentOne",comment_no);

	}

	public void deleteCommentAll(Comment_post comment_post) {
		session.delete("deleteCommentAll", comment_post);
	}

	public Integer selectMaxCommentNo() {
		Integer a= session.selectOne("selectMaxCommentNo");
		if(a==null) {
			a=0;
		}
		return a;
	}

	public Comment_post selectComment(Integer comment_no) {
		return session.selectOne("selectComment",comment_no );
	}

}
