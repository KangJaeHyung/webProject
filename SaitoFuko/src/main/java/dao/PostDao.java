package dao;

import java.util.List;

import model.Condition;
import model.Post;

public interface PostDao {
	void insertPost(Post p);
	List<Post> selectPostList(Condition c);
	List<Post> selectPostListAll(Condition c);
	Post selectPostDetail(Integer post_id);
	Integer selectMaxPostNo();
	Integer selectMaxGruopLayer();
	void deletePost(Post p);
	void updatePost(Post p);
	void updateGroupReply(Post p);
	Integer selectboardCnt(Integer board_id);
	
}
