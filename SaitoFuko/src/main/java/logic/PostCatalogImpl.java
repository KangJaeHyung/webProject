package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CommentDao;
import dao.PostDao;
import model.Comment_post;
import model.Condition;
import model.Post;

@Service
public class PostCatalogImpl implements PostCatalog {
	
	@Autowired
	private PostDao postDao;
	@Autowired
	private CommentDao commentDao;
	
	public void insertPost(Post p) {
		postDao.insertPost(p);

	}

	public List<Post> selectPostList(Condition c) {
		return postDao.selectPostList(c);
	}
	public List<Post> selectPostListAll(Condition c) {
		return postDao.selectPostListAll(c);
	}

	public Post selectPostDetail(Integer post_id) {
		return postDao.selectPostDetail(post_id);
	}

	public Integer selectMaxPostNo() {

		return postDao.selectMaxPostNo();
	}

	public Integer selectMaxGruopLayer() {
		return postDao.selectMaxGruopLayer();
	}

	public void deletePost(Post p) {
		postDao.deletePost(p);

	}

	public void updatePost(Post p) {
		postDao.updatePost(p);

	}

	public void updateGroupReply(Post p) {
		postDao.updateGroupReply(p);
		
	}

	public Integer selectboardCnt(Integer board_id) {
		
		return postDao.selectboardCnt(board_id);
	}

	
	
	public List<Comment_post> selectCommentList(Integer post_no) {

		return commentDao.selectCommentList(post_no);
	}

	public void insertComment(Comment_post comment_post) {
		commentDao.insertComment(comment_post);
		
	}

	public void deleteCommentOne(Integer comment_no) {
		commentDao.deleteCommentOne(comment_no);
		
	}

	public void deleteCommentAll(Comment_post comment_post) {
		commentDao.deleteCommentAll(comment_post);
		
	}

	public Integer selectMaxCommentNo() {
		return commentDao.selectMaxCommentNo();
	}

	public Comment_post selectComment(Integer comment_no) {
		
		return commentDao.selectComment(comment_no);
	}

	
	
}
