package crud;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Boss_count;
import model.Boss_reservation;
import model.Clan_date;
import model.Condition;
import model.User_boss_count;
import model.User_table;

public class CrudProcess {
	private final String NAMESPACE = "crud.mapper";

	public List<User_table> selectUserList() {
		SqlSession ss = getSession();
		List<User_table> cs = null;
		try {
			String query = NAMESPACE + ".selectUserList";
			cs = ss.selectList(query);
			return cs;
		} finally {
			ss.close();
		}
	}





	public Clan_date selectDay() {
		SqlSession ss = getSession();
		Clan_date cs = null;
		try {
			String query = NAMESPACE + ".selectDay";
			cs = ss.selectOne(query);
			return cs;
		} finally {
			ss.close();
		}
	}

	public List<Boss_count> selectBossList() {
		SqlSession ss = getSession();
		List<Boss_count> cs = null;
		try {
			String query = NAMESPACE + ".selectBossList";
			cs = ss.selectList(query);
			return cs;
		} finally {
			ss.close();
		}
	}

	public User_table selectUser(User_table user) {
		SqlSession ss = getSession();
		User_table cs = null;
		try {
			String query = NAMESPACE + ".selectUser";
			cs = ss.selectOne(query, user);
			return cs;
		} finally {
			ss.close();
		}
	}

	public List<Boss_count> selectBossCount(Condition c) {
		SqlSession ss = getSession();
		List<Boss_count> cs = null;
		try {
			String query = NAMESPACE + ".selectBossCount";
			cs = ss.selectList(query, c);
			return cs;
		} finally {
			ss.close();
		}
	}

	public List<Boss_reservation> selectBossReserv(Boss_reservation br) {
		SqlSession ss = getSession();
		List<Boss_reservation> cs = null;
		try {
			String query = NAMESPACE + ".selectBossReserv";
			cs = ss.selectList(query, br);
			return cs;
		} finally {
			ss.close();
		}
	}

	public List<Boss_reservation> selectBossReservAll(Boss_reservation br) {
		SqlSession ss = getSession();
		List<Boss_reservation> cs = null;
		try {
			String query = NAMESPACE + ".selectBossReservAll";
			cs = ss.selectList(query, br);
			return cs;
		} finally {
			ss.close();
		}
	}

	public List<User_boss_count> selectTodayAllDamage(Condition c) {
		SqlSession ss = getSession();
		List<User_boss_count> cs = null;
		try {
			String query = NAMESPACE + ".selectTodayAllDamage";
			cs = ss.selectList(query, c);
			return cs;
		} finally {
			ss.close();
		}
	}

	
	public Boss_count selectRN() {
		SqlSession ss = getSession();
		Boss_count cs = null;
		try {
			String query = NAMESPACE + ".selectRN";
			cs = ss.selectOne(query);
			return cs;
		} finally {
			ss.close();
		}
	}

	public Integer insertReserv(Boss_reservation br) {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".insertReserv";
			cs = ss.insert(query, br);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	public String insertUser(User_table userT) {
		SqlSession ss = getSession();
		String str = "실패";
		try {
			String query = NAMESPACE + ".insertUser";
			Integer cs = ss.insert(query, userT);
			if (cs > 0) {
				str = "성공";
				ss.commit();
			}
		} catch (Exception e) {
			str = "실패";
		} finally {
			ss.close();
		}
		return str;
	}

	public Integer insertBossDamage(Boss_count boss_count) {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".insertBossDamage";
			cs = ss.insert(query, boss_count);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	public Integer insertClanDate(Clan_date cd) {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".insertClanDate";
			cs = ss.insert(query, cd);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return cs;
	}


	public Integer deleteClanDate() {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".deleteClanDate";
			cs = ss.update(query);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	public Integer resetCpUser(String user_code) {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".resetCpUser";
			cs = ss.update(query, user_code);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	public Integer addCpUser(String user_code) {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".addCpUser";
			cs = ss.update(query, user_code);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	public Integer resetBr() {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".resetBr";
			cs = ss.delete(query);
			if (cs > 0) {
				ss.commit();
			}
		} finally {
			ss.close();
		}
		return cs;
	}

	public Integer resetUser() {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".resetUser";
			cs = ss.delete(query);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	public Integer resetDamage(Condition c) {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".resetDamage";
			cs = ss.delete(query, c);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	public Integer deleteGateUser(String user_name) {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".deleteGateUser";
			cs = ss.delete(query, user_name);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	public Integer deleteUser(String user_name) {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".deleteUser";
			cs = ss.delete(query, user_name);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	public Integer deleteDate() {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".deleteDate";
			cs = ss.delete(query);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	public Integer deleteDamgeOne(Condition c) {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".deleteDamgeOne";
			cs = ss.delete(query, c);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	public Integer deleteBossReservAll(String user_code) {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".deleteBossReservAll";
			cs = ss.delete(query, user_code);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	public Integer deleteBossReserv(Boss_reservation br) {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".deleteBossReserv";
			cs = ss.delete(query, br);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	public Integer updateUserCarryCount(User_table carry_time) {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".updateUserCarryCount";
			cs = ss.update(query, carry_time);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	public Integer updateCount(String user) {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".updateCount";
			cs = ss.update(query, user);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	public Integer updateDay() {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".updateDay";
			cs = ss.update(query);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	public Integer resetGateCp() {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".resetGateCp";
			cs = ss.update(query);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	public Integer resetCp() {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".resetCp";
			cs = ss.update(query);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	public Integer resetDmg() {
		SqlSession ss = getSession();
		Integer cs = 0;
		try {
			String query = NAMESPACE + ".resetDmg";
			cs = ss.delete(query);
			if (cs > 0) {
				ss.commit();
			}
		} catch (Exception e) {
		} finally {
			ss.close();
		}
		return cs;
	}

	private SqlSession getSession() {
		String path = "crud/Mybatics.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(path);
		} catch (Exception e) {
		}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is);
		SqlSession sqlSession = factory.openSession();
		return sqlSession;
	}
}
