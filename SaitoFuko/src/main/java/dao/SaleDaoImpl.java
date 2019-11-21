package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Emoticon_sale;
import model.Have_emoticon;
import model.Refund_emoticon;
@Repository
public class SaleDaoImpl implements SaleDao {
	@Autowired
	private SqlSession session;
	
	public void buyEmoticon(Emoticon_sale sale) {
	session.insert("buyEmoticon",sale);	

	}
	public String selectOrdCode(Emoticon_sale sale) {
		return session.selectOne("selectOrdCode",sale);
	}
	
	public void refundEmoticon(Refund_emoticon refund) {
		session.insert("refundEmoticon",refund);	

	}

	public String getSaleId() {
		String id= session.selectOne("getSaleId");
		if(id==null) {
			id="SA0000";
		}
		return id;
	}
	public void deleteHaveEmo(Have_emoticon have) {
		session.delete("deleteHaveEmo",have);
	}

}
