package model;

public class Comment_post {
	private Integer comment_no;
	private Integer post_no;
	private Integer comment_parent;
	private String user_id;
	private String nickname;
	private String comment_date;
	private String comment_content;
	private String emo_id;
	private String emo_picture;
	public void setEmo_picture(String emo_picture) {
		this.emo_picture = emo_picture;
	}
	public String getEmo_picture() {
		return emo_picture;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNickname() {
		return nickname;
	}
	
	public Integer getComment_no() {
		return comment_no;
	}
	public void setComment_no(Integer comment_no) {
		this.comment_no = comment_no;
	}
	public Integer getPost_no() {
		return post_no;
	}
	public void setPost_no(Integer post_no) {
		this.post_no = post_no;
	}
	public Integer getComment_parent() {
		return comment_parent;
	}
	public void setComment_parent(Integer comment_parent) {
		this.comment_parent = comment_parent;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getComment_date() {
		return comment_date;
	}
	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getEmo_id() {
		return emo_id;
	}
	public void setEmo_id(String emo_id) {
		this.emo_id = emo_id;
	}
}
