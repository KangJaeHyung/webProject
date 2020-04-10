package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import crud.CrudProcess;
import model.Boss_count;
import model.Condition;
import model.User_table;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class TListener extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		User user = event.getAuthor();
		TextChannel tc = event.getTextChannel();
		Message msg = event.getMessage();
		String[] spmsg = msg.getContentRaw().split(" ");
		CrudProcess crud = new CrudProcess();
		if (user.isBot())
			return;
		if(spmsg[0].equals("!명령어")) {
			String str="============명령어 모음=============\r\n";
			str+="!주사위: 0~100까지 숫자중 랜덤으로 하나 출력 \r\n";
			str+="!유저등록: 자신을 DB에 등록합니다.\r\n";
			str+="!유저목록: DB에 등록된 유저목록을 보여드립니다.\r\n";
			str+="!cp확인: 오늘 남은 cp를 보여드립니다.\r\n";
			str+="!딜량 [@유저명]:유저명에 아무것도 입력안하면 오늘 내가 넣은 딜량을 보여드립니다. 넣을시 해당유저의 딜량을 보여드립니다.\r\n\r\n";
			
			str+="=====3타완료 보고서 채팅방에서만=====";
			str+="!데미지입력 [회차] [네임드] [딜량] [이월] !\r\n";
			str+="자신이 해당 회차 네임드에 넣은 딜량을 DB에 입력합니다. 이월했을 경우 이월이라고 입력하면 됩니다.\r\n";
			str+="ex)!데미지입력 3 5 2500000 이월\r\n";
			str+="ex)!데미지입력 23 1 3000000\r\n\r\n";
			
			str+="!대리입력 [@유저명] [회차] [네임드] [딜량] [이월] !\r\n";
			str+="해당 유저가 회차 네임드에 넣은 딜량을 DB에 입력합니다. 이월했을 경우 이월이라고 입력하면 됩니다.\r\n";
			str+="ex)!대리입력 @fuko 3 5 2500000 이월\r\n";
			str+="ex)!대리입력 @fuko 23 1 3000000\r\n";
			tc.sendMessage(str).queue();
		}
		if(spmsg[0].equals("!사리뿌")) {
			tc.sendMessage("일해라!! <@352820030330765312>").queue();
			
		}
		if (spmsg[0].equals("!안녕")) {
			tc.sendMessage("안녕하세요!"+user.getAsMention()+ "씨").queue();
			return;
		}
		if (spmsg[0].equals("!할로윈쿄우카봇")) {
			int rnd = (int) (Math.random() * 8);
			switch (rnd) {
			case 0:
				tc.sendMessage("냐, 냐~! 뭘 보는 거예요?").queue();
				break;
			case 1:
				tc.sendMessage("저기⋯ 해피 할로윈!").queue();
				break;
			case 2:
				tc.sendMessage("에헤헤, 깨물 거예요.").queue();
				break;
			case 3:
				tc.sendMessage("과자랑 장난 어떤게 좋아요? 흠흠 수상한 변태씨가 틀림없군요!").queue();
				break;
			case 4:
				tc.sendMessage("잔난칠꺼에욧! 뭐얏.. 으어어 할로윈 블룸 댄스!").queue();
				break;
			case 5:
				tc.sendMessage("할로윈 같이... 돌아주시겠어요? 무서운게 아니에요! 정말, 당신은 어쩔수 없는 사람이군요!").queue();
				break;
			case 6:
				tc.sendMessage("에? 과자 저에게 주는건가요? 으 음~ 달고 맛있어요! 앗 손에 묻었다. 할짝 무... 무엇을 보고있나요옷!").queue();
				break;
			case 7:
				tc.sendMessage("과자, 있나요? 없다고요? 그러면 장난이에요. 무..물어버릴꺼에요! 에-에잇!").queue();
				break;
			}
			return;
		}
		if (spmsg[0].equals("!주사위")) {
			int rnd = (int) (Math.random() * 101);
			tc.sendMessage("와!"+user.getAsMention() + "씨의 주사위는 " + rnd + "에요.").queue();
			return;
		}
		if (spmsg[0].equals("!유저등록")) {
			User_table userT = new User_table();
			
			userT.setUser_name(user.getName());
			userT.setUser_code(user.getAsMention());
			userT.setCp_count(3);
			String result = crud.insertUser(userT);
			if (result.equals("성공")) {
				tc.sendMessage(user.getAsMention() + "씨 등록 완료됬어요! 으으.. 또 한명에 수상한 변태씨가 늘었어요!").queue();
			} else if (result.equals("실패")) {
				tc.sendMessage(user.getAsMention() + "씨 등록에 실패했어요! \r\n 이미 등록되있는거같은데요?").queue();
				tc.sendMessage("").queue();
			}
			return;
		}
		if (spmsg[0].equals("!유저목록")) {
			List<User_table> userList = crud.selectUserList();
			String user_name = "";
			for (User_table userL : userList) {
				user_name = user_name + userL.getUser_name() + "\r\n";
			}
			tc.sendMessage("===へんたい不審者さんたち===").queue();
			tc.sendMessage(user_name).queue();
		}
		if (spmsg[0].equals("!cp확인")) {
			List<User_table> userList = crud.selectUserList();
			String str = "";
			Integer cp = 0;
			for (User_table us : userList) {
				str = str + us.getUser_name() + " " + us.getCp_count() + "번" + "\r\n";
				cp += us.getCp_count();
			}
			tc.sendMessage(str + "총 " + cp + "번 남았습니다.").queue();
		}
		if (spmsg[0].equals("!딜량")) {
			String user_code = "";
			if (spmsg.length == 1) {
				user_code = user.getAsMention();
			} else {
				user_code = spmsg[1];
				user_code = user_code.replace("!", "");
			}
			serchDamage(user_code, crud, tc);
		}
		if (tc.getName().equals("3타완료보고")) {
			if (spmsg[0].equals("!데미지입력")) {
				if (spmsg.length < 4 || spmsg.length > 5) {
					tc.sendMessage(user.getAsMention() + "데미지등록에 실패했어욧!! 우리 다시한번 형식에 맞게 입력해봐요.").queue();
				} else {
					inputDamage(spmsg, tc, user.getAsMention(), crud);
				}
			}
			if (spmsg[0].equals("!대리입력")) {
				if (spmsg.length < 5 || spmsg.length > 6) {
					tc.sendMessage("데미지등록에 실패했어욧!! 우리 다시한번 형식에 맞게 입력해봐요.").queue();
				} else {
					String user_code = spmsg[1];
					user_code = user_code.replace("!", "");
					for (int i = 1; i < spmsg.length - 1; i++) {
						spmsg[i] = spmsg[i + 1];
					}
					inputDamage(spmsg, tc, user_code, crud);
				}
			}
			
			if(spmsg[0].equals("!딜량삭제")) {
				Condition c = new Condition();
				Calendar cal = Calendar.getInstance();
				Calendar startDate = Calendar.getInstance();
				Calendar endDate = Calendar.getInstance();
				String startDateF = "";
				String endDateF = "";
				SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				if (cal.get(Calendar.HOUR) >= 5) {
					startDate.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 5, 0, 0);
					endDate.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) + 1, 5, 0, 0);
					startDateF = smp.format(new Date(startDate.getTimeInMillis()));
					endDateF = smp.format(new Date(endDate.getTimeInMillis()));

				} else {
					startDate.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) - 1, 5, 0, 0);
					endDate.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 5, 0, 0);
					startDateF = smp.format(new Date(startDate.getTimeInMillis()));
					endDateF = smp.format(new Date(endDate.getTimeInMillis()));
				}
				c.setStartDate(startDateF);
				c.setEndDate(endDateF);
				c.setUser_code(user.getAsMention());
				crud.resetDamage(c);
				tc.sendMessage("오늘 넣으신 딜량이 초기화 되었어요!").queue();
			}
		}
		if(tc.getName().equals("커맨드")&&user.getAsMention().equals("<@363657198347485186>")) {
			if (spmsg[0].equals("!cp초기화")) {
				crud.resetCp();
				tc.sendMessage("하으으.. 초기화 되었어요!!").queue();
			}
			if(spmsg[0].equals("!유저초기화")) {
				crud.resetUser();
				tc.sendMessage("하으으.. 초기화 되었어요!!").queue();
			}
			if(spmsg[0].equals("!유저추방")) {
				if(spmsg.length!=2) {
					tc.sendMessage("명령어를 정확하게 사용해주세요. \r\n ex)!유저추방 [유저명]").queue();
					return;
				}
				String user_name= spmsg[1];
				crud.deleteUser(user_name);
				tc.sendMessage(user_name+"님이 추방 되었습니다.").queue();
			}
		}
	}

	public void serchDamage(String user_code, CrudProcess crud, TextChannel tc) {
		Calendar cal = Calendar.getInstance();
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		String startDateF = "";
		String endDateF = "";
		SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (cal.get(Calendar.HOUR) >= 5) {
			startDate.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 5, 0, 0);
			endDate.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) + 1, 5, 0, 0);
			startDateF = smp.format(new Date(startDate.getTimeInMillis()));
			endDateF = smp.format(new Date(endDate.getTimeInMillis()));

		} else {
			startDate.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) - 1, 5, 0, 0);
			endDate.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 5, 0, 0);
			startDateF = smp.format(new Date(startDate.getTimeInMillis()));
			endDateF = smp.format(new Date(endDate.getTimeInMillis()));
		}
		Condition c = new Condition();
		c.setStartDate(startDateF);
		c.setEndDate(endDateF);
		c.setUser_code(user_code);
		List<Boss_count> cp = crud.selectBossCount(c);
		if (cp.size() == 0) {
			tc.sendMessage(user_code + "님은 오늘 친 기록이 없습니다.").queue();
			return;
		}
		String str = user_code + "님이 오늘 넣은 딜량은\r\n";
		for (Boss_count userCp : cp) {
			str = str + userCp.getRound() + "회차 " + userCp.getNamed() + "네임드 를 '" + userCp.getDamage() + "' 넣";
			if (userCp.getNext_time() == 1) {
				str += "고 이월 되었습니다.\r\n";
			} else {
				str += "었습니다.\r\n";
			}
		}
		tc.sendMessage(str).queue();
	}

	public void inputDamage(String[] spmsg, TextChannel tc, String user_code, CrudProcess crud) {
		tc.sendMessage(user_code + "데미지 등록중이에요! 잠시만기달려주세요!").queue();
		int size = spmsg.length;
		for (int i = 0; i < size; i++) {
			if (spmsg[i].equals("") || spmsg[i] == null) {
				tc.sendMessage("등록 실패했어요.. 띄어쓰기를 다시 한 번 확인 해 주시겠어요?").queue();
				return;
			}
		}
		User_table selUser = null;
		try {
			User_table userT = new User_table();
			userT.setUser_code(user_code);
			selUser = crud.selectUser(userT);
		} catch (Exception e) {
			tc.sendMessage(user_code + "등록 실패했어요.. 관리자에게 문의주세요!!").queue();
			tc.sendMessage("에러코드 : 001").queue();
			e.printStackTrace();
			return;
		}
		if (selUser == null || selUser.getUser_code() == null || selUser.getUser_code().equals("")) {
			tc.sendMessage(user_code + "등록되지 않은 유저에요! 일단 유저 등록부터 해보죠!").queue();
			return;
		}
		if (selUser.getCp_count() == 0) {
			tc.sendMessage(user_code + "씨는 오늘 클랜전을 다치셨어요! 대단해!").queue();
			return;
		}
		Integer round = 0;
		Integer named = 0;
		Integer damage = 0;
		Integer next_time = 0;
		try {
			round = Integer.parseInt(spmsg[1]);
		} catch (NumberFormatException e) {
			tc.sendMessage("'" + spmsg[1] + "' 부분이 잘못된 형식입니다.").queue();
			return;
		}
		try {
			named = Integer.parseInt(spmsg[2]);
		} catch (NumberFormatException e) {
			tc.sendMessage("'" + spmsg[2] + "' 부분이 잘못된 형식입니다.").queue();
			return;
		}
		try {
			damage = Integer.parseInt(spmsg[3]);
		} catch (NumberFormatException e) {
			tc.sendMessage("'" + spmsg[3] + "' 부분이 잘못된 형식입니다.").queue();
			return;
		}
		for (int i = 0; i < spmsg.length; i++) {
			if (spmsg[i].equals("이월")) {
				next_time = 1;
			}
		}
		Boss_count boss_count = new Boss_count();
		Date date = new Date();
		SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String attack_date = smp.format(date);
		boss_count.setAttack_date(attack_date);
		boss_count.setDamage(damage);
		boss_count.setNamed(named);
		boss_count.setNext_time(next_time);
		boss_count.setRound(round);
		boss_count.setUser_code(user_code);
		try {
			crud.insertBossDamage(boss_count);
			if (next_time == 1) {

			} else {
				crud.updateCount(user_code);
			}
		} catch (Exception e) {
			tc.sendMessage(user_code + "등록 실패했어요.. 다시 시도해주세요.").queue();
			return;
		}
		tc.sendMessage(round + "회차 " + named + "네임드 " + damage + "입력이  완료되었어요!").queue();
		if(next_time==0) {
			if(selUser.getCp_count()==1) {
				tc.sendMessage("와! "+selUser.getUser_code()+"씨는 오늘 3번 다 치셨군요! 오늘 수고하셨습니다!").queue();
			}
		}
	}
}
