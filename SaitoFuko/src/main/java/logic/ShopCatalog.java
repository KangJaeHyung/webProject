package logic;

import java.util.List;

import model.Condition;
import model.Emo_cart;
import model.Emoticon_info;
import model.Emoticon_sale;
import model.Have_emo_info;
import model.Have_emoticon;
import model.Refund_emoticon;

public interface ShopCatalog {
	List<Emoticon_info> selectEmoticonList(Condition c);
	Integer selectEmoCount();
	List<Emo_cart> selectEmoCart(String user_id);
	void inCart(Emo_cart emo_cart);
	void outCart(Emo_cart emo_cart);
	List<Have_emoticon> selectHaveEmoticon(String user_id);
	Emoticon_info selectEmoticon(String emo_id);
	List<Have_emo_info> selectHaveEmoInfo(String user_id);
	List<Have_emo_info> selectCartEmoInfo(String user_id);
	void buyEmoticon(Emoticon_sale sale);
	void refundEmoticon(Refund_emoticon refund);
	String getSaleId();
	void intsertHaveEmo(Have_emoticon have);
	String selectOrdCode(Emoticon_sale sale);
	void deleteHaveEmo(Have_emoticon have);
}
