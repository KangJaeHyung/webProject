package model;

public class User_boss_count {
	private String user_name;
	private String user_code;
	private Integer round;
	private Integer named;
	private Integer damage;
	private Integer next_time;
	private String attack_date;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getUser_code() {
		return user_code;
	}
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
	public void setDamage(Integer damage) {
		this.damage = damage;
	}
	public Integer getDamage() {
		return damage;
	}
}
