package model;

public class Board {
	private Integer board_id;
	private String board_name;
	private Integer board_grade;
	private Integer board_location;
	public Integer getBoard_id() {
		return board_id;
	}
	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public Integer getBoard_grade() {
		return board_grade;
	}
	public void setBoard_grade(Integer board_grade) {
		this.board_grade = board_grade;
	}
	public Integer getBoard_location() {
		return board_location;
	}
	public void setBoard_location(Integer board_location) {
		this.board_location = board_location;
	}
}
