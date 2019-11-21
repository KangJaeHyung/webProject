package dao;

import java.util.List;

import model.Comment_post;

public interface CommentDao {
	List<Comment_post> selectCommentList(Integer post_no);
	void insertComment(Comment_post comment_post);
	void deleteCommentOne(Integer comment_no);
	void deleteCommentAll(Comment_post comment_post);
	Integer selectMaxCommentNo();
	Comment_post selectComment(Integer comment_no);
}
