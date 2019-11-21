package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EmoDao;
import dao.SaleDao;
import model.Condition;
import model.Emo_cart;
import model.Emoticon_info;
import model.Emoticon_sale;
import model.Have_emo_info;
import model.Have_emoticon;
import model.Refund_emoticon;
@Service
public class ShopCatalogImpl implements ShopCatalog{
	@Autowired
	private EmoDao emoDao;
	@Autowired SaleDao saleDao;
	
	public List<Emoticon_info> selectEmoticonList(Condition c) {
		return emoDao.selectEmoticonList(c);
	}
	public Integer selectEmoCount() {
		return emoDao.selectEmoCount();
	}
	public List<Emo_cart> selectEmoCart(String user_id){
		return emoDao.selectEmoCart(user_id);
	}
	public void inCart(Emo_cart emo_cart) {
		emoDao.inCart(emo_cart);
		
	}
	public void outCart(Emo_cart emo_cart) {
		emoDao.outCart(emo_cart);
		
	}
	public List<Have_emoticon> selectHaveEmoticon(String user_id) {
		return emoDao.selectHaveEmoticon(user_id);
	}
	public Emoticon_info selectEmoticon(String emo_id) {
		return emoDao.selectEmoticon(emo_id);
	}
	public List<Have_emo_info> selectHaveEmoInfo(String user_id) {
		return emoDao.selectHaveEmoInfo(user_id);
	}
	public void buyEmoticon(Emoticon_sale sale) {
		saleDao.buyEmoticon(sale);
	}
	public void refundEmoticon(Refund_emoticon refund) {
		saleDao.refundEmoticon(refund);
		
	}
	public String getSaleId() {
		return saleDao.getSaleId();
	}
	public void intsertHaveEmo(Have_emoticon have) {
		emoDao.intsertHaveEmo(have);
		
	}
	public List<Have_emo_info> selectCartEmoInfo(String user_id) {
		return emoDao.selectCartEmoInfo(user_id);
	}
	public String selectOrdCode(Emoticon_sale sale) {
		return saleDao.selectOrdCode(sale);
	}
	public void deleteHaveEmo(Have_emoticon have) {
		saleDao.deleteHaveEmo(have);
		
	}
	
	
}
