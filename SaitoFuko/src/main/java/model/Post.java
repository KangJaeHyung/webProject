package model;

public class Post {
	private Integer post_no;
	private String user_id;
	private String title;
	private String content;
	private String post_date;
	private Integer origin_no;
	private Integer group_ord;
	private Integer groupLayer;
	private Integer post_views;

	private Integer board_id;
	private String board_name;
	private Integer board_grade;
	private String nickname;
	
	public Integer getPost_no() {
		return post_no;
	}
	public void setPost_no(Integer post_no) {
		this.post_no = post_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getPost_date() {
		return post_date;
	}
	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}
	public Integer getOrigin_no() {
		return origin_no;
	}
	public void setOrigin_no(Integer origin_no) {
		this.origin_no = origin_no;
	}
	public Integer getGroup_ord() {
		return group_ord;
	}
	public void setGroup_ord(Integer group_ord) {
		this.group_ord = group_ord;
	}
	public Integer getGroupLayer() {
		return groupLayer;
	}
	public void setGroupLayer(Integer groupLayer) {
		this.groupLayer = groupLayer;
	}
	public Integer getBoard_id() {
		return board_id;
	}
	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}
	public Integer getPost_views() {
		return post_views;
	}
	public void setPost_views(Integer post_views) {
		this.post_views = post_views;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickName(String nickname) {
		this.nickname = nickname;
	}
	public void setBoard_grade(Integer board_grade) {
		this.board_grade = board_grade;
	}
	public Integer getBoard_grade() {
		return board_grade;
	}
}
