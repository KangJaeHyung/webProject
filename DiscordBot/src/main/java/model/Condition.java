package model;

public class Condition {
	private String startDate;
	private String endDate;
	private String user_code;
	private Integer round;
	private Integer named;
	private Integer next_time;
	private String attack_date;
	public Integer getRound() {
		return round;
	}
	public void setRound(Integer round) {
		this.round = round;
	}
	public Integer getNamed() {
		return named;
	}
	public void setNamed(Integer named) {
		this.named = named;
	}
	public Integer getNext_time() {
		return next_time;
	}
	public void setNext_time(Integer next_time) {
		this.next_time = next_time;
	}
	public String getAttack_date() {
		return attack_date;
	}
	public void setAttack_date(String attack_date) {
		this.attack_date = attack_date;
	}

	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	
}
