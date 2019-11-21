package logic;

import java.util.List;

import model.Comment_post;
import model.Condition;
import model.Post;

public interface PostCatalog {
	void insertPost(Post p);
	List<Post>  selectPostList(Condition c);
	Post selectPostDetail(Integer post_id);
	Integer selectMaxPostNo();
	Integer selectMaxGruopLayer();
	void deletePost(Post p);
	void updatePost(Post p);
	void updateGroupReply(Post p);
	Integer selectboardCnt(Integer board_id);
	List<Post> selectPostListAll(Condition c);
	
	List<Comment_post> selectCommentList(Integer post_no);
	void insertComment(Comment_post comment_post);
	void deleteCommentOne(Integer comment_no);
	void deleteCommentAll(Comment_post comment_post);
	Integer selectMaxCommentNo();
	Comment_post selectComment(Integer comment_no);
}
