package dao;

import model.Emoticon_sale;
import model.Have_emoticon;
import model.Refund_emoticon;

public interface SaleDao {
	void buyEmoticon(Emoticon_sale sale);
	void refundEmoticon(Refund_emoticon refund);
	String selectOrdCode(Emoticon_sale sale);
	String getSaleId();
	void deleteHaveEmo(Have_emoticon have);
}
