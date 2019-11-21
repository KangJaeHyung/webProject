package model;

import java.util.List;

public class Condition {
	private Integer startRow;
	private Integer endRow;
	private List<Have_emoticon> have_emoticon;
	private Integer board_grade;
	private Integer board_id;
	public List<Have_emoticon> getHave_emoticon() {
		return have_emoticon;
	}
	public void setHave_emoticon(List<Have_emoticon> have_emoticon) {
		this.have_emoticon = have_emoticon;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getEndRow() {
		return endRow;
	}
	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}
	public Integer getBoard_grade() {
		return board_grade;
	}
	public void setBoard_grade(Integer board_grade) {
		this.board_grade = board_grade;
	}
	public Integer getBoard_id() {
		return board_id;
	}
	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}

}
