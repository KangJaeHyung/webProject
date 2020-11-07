package model;

public class User_table {
	private String user_name;
	private String user_code;
	private Integer cp_count;
	private Integer carry;
	private Integer carry_named;
	private Integer carry_time;
	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Integer getCp_count() {
		return cp_count;
	}

	public void setCp_count(Integer cp_count) {
		this.cp_count = cp_count;
	}

	public Integer getCarry() {
		return carry;
	}

	public void setCarry(Integer carry) {
		this.carry = carry;
	}

	public Integer getCarry_named() {
		return carry_named;
	}

	public void setCarry_named(Integer carry_named) {
		this.carry_named = carry_named;
	}

	public Integer getCarry_time() {
		return carry_time;
	}

	public void setCarry_time(Integer carry_time) {
		this.carry_time = carry_time;
	}

}
