package model;

public class Emoticon_info {
	private String emo_id;
	private String emo_name;
	private String emo_info;
	private Integer emo_price;
	private String emo_picture;
	private boolean emo_cart=false;
	public boolean isEmo_cart() {
		return emo_cart;
	}
	public void setEmo_cart(boolean emo_cart) {
		this.emo_cart = emo_cart;
	}
	
	public String getEmo_id() {
		return emo_id;
	}
	public void setEmo_id(String emo_id) {
		this.emo_id = emo_id;
	}
	public String getEmo_name() {
		return emo_name;
	}
	public void setEmo_name(String emo_name) {
		this.emo_name = emo_name;
	}
	public String getEmo_info() {
		return emo_info;
	}
	public void setEmo_info(String emo_info) {
		this.emo_info = emo_info;
	}

	public Integer getEmo_price() {
		return emo_price;
	}
	public void setEmo_price(Integer emo_price) {
		this.emo_price = emo_price;
	}
	public String getEmo_picture() {
		return emo_picture;
	}
	public void setEmo_picture(String emo_picture) {
		this.emo_picture = emo_picture;
	}
}
