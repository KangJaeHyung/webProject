package mainStart;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import crud.CrudProcess;
import googleSheet.inputSheet;
import model.Boss_count;
import model.Boss_reservation;
import model.Character_db;
import model.Clan_date;
import model.Condition;
import model.User_boss_count;
import model.User_table;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class TListener extends ListenerAdapter {

	inputSheet sheet = new inputSheet();
	static int day = 2;

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		User user = event.getAuthor();
		TextChannel tc = event.getTextChannel();
		Message msg = event.getMessage();
		String[] spmsg = msg.getContentRaw().split(" ");
		CrudProcess crud = new CrudProcess();
		Guild guild = event.getGuild();
		String message = msg.getContentRaw();
		
//		System.out.println(
//				"체널:" + tc.getName() + "(" + tc.getId() + ")," + tc.getType() + "," + user.getName() + ":" + message);
		if (user.isBot())
			return;
		if (message.length() < 1) {
			return;
		}
//		if (spmsg[0].equals("!캐릭터DB복사")) {
//		List<Character_db> ul = crud.selectCharAll();
//		System.out.println(ul.size());
//		for (Character_db bc : ul) {
//			String str = "insert into character_db values(";
//			str += "'" + bc.getC_name() + "'" + ",\r\n";
//			str += "'" + bc.getC_keyword() + "'" + ",\r\n";
//			str += bc.getC_age() + ",\r\n";
//			str += bc.getC_height() + ",\r\n";
//			str += bc.getC_weight() + ",\r\n";
//			str += "'" +bc.getC_birthday() + "'" + ",\r\n";
//			str += "'" +bc.getC_guild() + "'" + ",\r\n";
//			str += "'" +bc.getC_position() + "'" + ",\r\n";
//			str += bc.getC_location() + ",\r\n";
//			str += "'" +bc.getC_attack_type() + "'" + ",\r\n";
//			str += "'" +bc.getC_class() + "'" + ",\r\n";
//			str += bc.getC_rare() + ",\r\n";
//			str += "'" +bc.getC_voice() + "'" + ",\r\n";
//			str += "'" +bc.getC_rare6() + "'" + ",\r\n";
//			str += "'" +bc.getC_equipment() + "'" + ",\r\n";
//			str += "'" +bc.getC_ub() + "'" + ",\r\n";
//			str += "'" +bc.getC_skill1() + "'" + ",\r\n";
//			str += "'" +bc.getC_skill2() + "'" + ",\r\n";
//			str += "'" +bc.getC_exSkill() + "'" + ",\r\n";
//			str += "'" +bc.getC_image() + "'" + ",\r\n";
//			str += "'" +bc.getC_sub_image() + "'" + "\r\n"
//					+ ");"
//					+ "\r\n\r\n";
//			System.out.println(str);
//		}
//		return;
//	}
//

		if (spmsg[0].equals("!개발자")) {
			tc.sendMessage("저를 만드신분은 Fuko에요.").queue();
			return;
		}
		if (String.valueOf(message.charAt(0)).equals("-")) {
			String keyword = "";
			if (message.length() == 1) {
				tc.sendMessage("명령어를 정확히 작성해 주세요!").queue();
				return;
			}
			message = message.replace("-", "");
			keyword = message.replace(" ", "");
			serchChar(keyword, crud, tc);
			return;
		}
		if (spmsg[0].equals("!전열")) {
			List<Character_db> chrList = crud.selectCharLoca("전열");
			EmbedBuilder emb = new EmbedBuilder();
			emb.setColor(Color.yellow);
			emb.setTitle("전열 캐릭터");
			String str = "";
			for (Character_db chr : chrList) {
				str += "**" + chr.getC_name() + "** : " + chr.getC_location() + "\r\n";
			}
			emb.setDescription(str);
			tc.sendMessage(emb.build()).queue();
			return;
		}
		if (spmsg[0].equals("!중열")) {
			List<Character_db> chrList = crud.selectCharLoca("중열");
			EmbedBuilder emb = new EmbedBuilder();
			emb.setColor(Color.yellow);
			emb.setTitle("중열 캐릭터");
			String str = "";
			for (Character_db chr : chrList) {
				str += "**" + chr.getC_name() + "** : " + chr.getC_location() + "\r\n";
			}
			emb.setDescription(str);
			tc.sendMessage(emb.build()).queue();
			return;
		}
		if (spmsg[0].equals("!후열")) {
			List<Character_db> chrList = crud.selectCharLoca("후열");
			EmbedBuilder emb = new EmbedBuilder();
			emb.setColor(Color.yellow);
			emb.setTitle("후열 캐릭터");
			String str = "";
			for (Character_db chr : chrList) {
				str += "**" + chr.getC_name() + "** : " + chr.getC_location() + "\r\n";
			}
			emb.setDescription(str);
			tc.sendMessage(emb.build()).queue();
			return;
		}

		if (spmsg[0].equals("!위치값확인")) {

			File file = new File("c:/image/image.png");
			System.out.println(file.getAbsolutePath());
			tc.sendFile(file, "image.jpg").queue();
			return;
		}
		if (spmsg[0].equals("!안녕")) {
			tc.sendMessage("안녕하세요!" + user.getAsMention() + "씨").queue();
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
				tc.sendMessage("장난칠꺼에욧! 뭐얏.. 으어어 할로윈 블룸 댄스!").queue();
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
			tc.sendMessage("와!" + user.getAsMention() + "씨의 주사위는 " + rnd + "에요.").queue();
			return;
		}
		if (guild.getId().equals("600296449603010563")) {
			if (spmsg[0].equals("!명령어")) {
				EmbedBuilder emb = new EmbedBuilder();
				emb.setColor(Color.yellow);
				emb.setTitle("명령어 모음");
				emb.addField("!주사위", "0~100까지 숫자중 랜덤으로 하나 출력", false);
				emb.addField("!유저등록 [자신의 닉네임]", "자신을 DB에 등록합니다.", false);
				emb.addField("!이월계산1 [보스체력] [데미지]", "이월 시간 계산", false);
				emb.addField("!이월계산2 [자신이넣은딜량]", "풀이월받으려면 남아있는 보스의 hp", false);
				emb.addField("!이월계산3 [보스의남은hp]", "풀이월받으려면 넣어야할 딜량", false);
				emb.addField("!cp확인", "오늘 남은 cp를 보여드립니다.", false);
				emb.addField("!딜량 [@유저명]", "유저명에 아무것도 입력안하면 오늘 내가 넣은 딜량을 보여드립니다. 넣을시 해당유저의 딜량을 보여드립니다.", false);
				emb.addField("!예약자호출 [회차][네임드]", "해당 회차 네임드를 예약한 유저를 호출합니다", false);
				emb.addField("!예약확인 [회차] [네임드]", "회차랑 네임드 안적을시 모든 예약 정보가 나옵니다.", false);
				emb.addField("!예약 [회차] [네임드] [예상데미지] [이월]", "회차랑 네임드는 필수로 적고 데미지랑 이월은 필수가 아닙니다.", false);
				emb.addField("!예약취소 [회차] [네임드]", "해당회차 예약 취소.", false);
				emb.addField("===3타완료보고서에 써주세요.===", "", false);
				emb.addField("!데미지입력 [회차] [네임드] [딜량] [이월]", "자신이 해당 회차 네임드에 넣은 딜량을 DB에 입력합니다. 이월했을 경우 이월이라고 입력하면 됩니다.",
						false);
				emb.addField("!데미지삭제", "오늘 자신이 넣은 데미지 전체를 삭제합니다.", false);
				tc.sendMessage(emb.build()).queue();
				return;
			}

			if (spmsg[0].equals("!이월계산1")) {
				if (spmsg.length < 3) {
					tc.sendMessage("명령어가 잘못되었어요!\r\n ex)!이월계산 1000000 2000000").queue();
					return;
				}
				try {
					float hp = Integer.parseInt(spmsg[1]);
					float damge = Integer.parseInt(spmsg[2]);
					float sec = (damge - hp) / damge * 90 + 20;
					if (sec > 90) {
						sec = 90;
					}
					tc.sendMessage(sec + "초에요!").queue();
				} catch (Exception e) {
					tc.sendMessage("명령어가 잘못되었어요!\r\n ex)!이월계산 1000000 2000000").queue();
				}
				return;
			}
			if (spmsg[0].equals("!이월계산2")) {
				if (spmsg.length < 2) {
					tc.sendMessage("명령어가 잘못되었어요!\r\n ex)!이월계산2 2000000").queue();
					return;
				}
				try {
					float damge = Integer.parseInt(spmsg[1]);
					float hp = damge * 2 / 9F;
					tc.sendMessage(Math.round(hp + 0.5) + "이하로 남으면 풀이월 받을수 있어요!").queue();

				} catch (Exception e) {
					tc.sendMessage("명령어가 잘못되었어요!\r\n ex)!이월계산2 2000000").queue();
				}
				return;
			}
			if (spmsg[0].equals("!이월계산3")) {
				if (spmsg.length < 2) {
					tc.sendMessage("명령어가 잘못되었어요!\r\n ex)!이월계산3 2000000").queue();
					return;
				}
				try {
					float hp = Integer.parseInt(spmsg[1]);
					float damage = hp * 9 / 2F;
					tc.sendMessage(Math.round(damage + 0.5) + "이상 넣으면 풀이월 받을수 있어요!").queue();

				} catch (Exception e) {
					tc.sendMessage("명령어가 잘못되었어요!\r\n ex)!이월계산3 2000000").queue();
				}
				return;
			}

			if (spmsg[0].equals("!유저등록")) {
				try {
					User_table userT = new User_table();

					userT.setUser_name(spmsg[1]);
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
				} catch (Exception e) {
					tc.sendMessage("등록중에 오류가 났나봐요! 형식에 맞게 다시 등록해보죠! \r\n ex)!유저등록 fuko").queue();
				}

			}
			if (spmsg[0].equals("!유저목록")) {
				List<User_table> userList = crud.selectUserList();
				String user_name = "";
				for (User_table userL : userList) {
					user_name = user_name + userL.getUser_name() + "\r\n";
				}
				user_name += "총 " + userList.size() + "명";
				tc.sendMessage("===へんたい不審者さんたち===").queue();
				tc.sendMessage(user_name).queue();
				return;
			}
			if (spmsg[0].equals("!cp확인")) {
				List<User_table> userList = crud.selectUserList();
				EmbedBuilder emb = new EmbedBuilder();
				emb.setTitle("현재 남은 cp");
				emb.setColor(Color.yellow);
				Integer cp = 0;
				for (User_table us : userList) {
					if (us.getCp_count() != 0) {
						emb.addField(us.getUser_name(), us.getCp_count() + "번", true);
						cp += us.getCp_count();
					}
				}
				emb.setFooter("총 " + cp + "번 남았습니다.", null);
				tc.sendMessage(emb.build()).queue();
				return;
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
				return;
			}
			if (spmsg[0].equals("!오늘전체딜량")) {
				serchTodayDamage(crud, tc);
				return;
			}
			if (spmsg[0].equals("!이번달딜량")) {
				if (spmsg.length == 1) {
					serchMonthDamge(user.getAsMention(), crud, tc);
				} else {
					if (spmsg[1].equals("상세"))
						serchMonthDamgeAll(user.getAsMention(), crud, tc);
					else
						tc.sendMessage("명령어가 잘못됬어요! \r\n ex)!이번달딜량 상세").queue();
					;
				}
				return;
			}
			if (spmsg[0].equals("!예약")) {
				Integer damage = -1;
				Integer round = 0;
				Integer named = 0;
				Integer next_time = 0;
				String user_code = user.getAsMention();
				if (spmsg.length < 3) {
					tc.sendMessage("명령어가 잘못됬어요! \r\n ex)!예약 20 3").queue();
					return;
				} else if (spmsg.length == 3) {
					try {
						round = Integer.parseInt(spmsg[1]);
						named = Integer.parseInt(spmsg[2]);
					} catch (Exception e) {
						tc.sendMessage("명령어가 잘못됬어요! \r\n ex)!예약 [회차] [네임드] [예상딜량] [이월여부]").queue();
						return;
					}
				} else if (spmsg.length == 4) {
					if (spmsg[3].equals("이월")) {
						try {
							round = Integer.parseInt(spmsg[1]);
							named = Integer.parseInt(spmsg[2]);
							next_time = 1;
						} catch (Exception e) {
							tc.sendMessage("명령어가 잘못됬어요! \r\n ex)!예약 [회차] [네임드] [예상딜량] [이월여부]").queue();
							return;
						}
					} else {
						try {
							round = Integer.parseInt(spmsg[1]);
							named = Integer.parseInt(spmsg[2]);
							damage = Integer.parseInt(spmsg[3]);
						} catch (Exception e) {
							tc.sendMessage("명령어가 잘못됬어요! \r\n ex)!예약 [회차] [네임드] [예상딜량] [이월여부]").queue();
							return;
						}
					}
				} else if (spmsg.length == 5) {
					if (spmsg[4].equals("이월")) {
						try {
							round = Integer.parseInt(spmsg[1]);
							named = Integer.parseInt(spmsg[2]);
							damage = Integer.parseInt(spmsg[3]);
							next_time = 1;
						} catch (Exception e) {
							tc.sendMessage("명령어가 잘못됬어요! \r\n ex)!예약 [회차] [네임드] [예상딜량] [이월여부]").queue();
							return;
						}
					} else {
						tc.sendMessage("명령어가 잘못됬어요! \r\n ex)!예약 [회차] [네임드] [예상딜량] [이월여부]").queue();
						return;
					}

				}
				Boss_reservation br = new Boss_reservation();
				br.setDamage(damage);
				br.setNamed(named);
				br.setNext_time(next_time);
				br.setRound(round);
				br.setUser_code(user_code);
				try {
					reservation(br, crud, tc, user_code);
				} catch (Exception e) {
					tc.sendMessage("뭔가 오류가 놧나봐요 ㅜㅜ 다시한번 해보죠.").queue();
					return;
				}
				return;
			}
			if (spmsg[0].equals("!예약취소")) {
				if (spmsg.length < 3) {
					tc.sendMessage("명령어가 잘못됬어요! \r\n ex)!예약취소 [회차] [네임드]").queue();
					return;
				} else {
					try {
						Integer round = Integer.parseInt(spmsg[1]);
						Integer named = Integer.parseInt(spmsg[2]);
						Boss_reservation br = new Boss_reservation();
						br.setNamed(named);
						br.setRound(round);
						br.setUser_code(user.getAsMention());
						List<Boss_reservation> brList = crud.selectBossReserv(br);
						if (brList.size() == 0 || brList == null) {
							tc.sendMessage("예약 정보를 찾을수 없어요! 회차랑 네임드를 다시한번 확인해 주세요!").queue();
							return;
						}
						crud.deleteBossReserv(br);
						tc.sendMessage("삭제가 완료되었습니다!").queue();
					} catch (Exception e) {
						tc.sendMessage("회차랑 네임드는 숫자로 입력해 주세요!!").queue();
						return;
					}
				}
				return;
			}
			if (spmsg[0].equals("!예약확인")) {
				Boss_reservation br = new Boss_reservation();
				Integer round = 0;
				Integer named = 0;
				if (spmsg.length == 1) {
					br.setNamed(named);
					br.setRound(round);
					serchReserv(tc, crud, br);
				} else if (spmsg.length == 3) {
					try {
						round = Integer.parseInt(spmsg[1]);
						named = Integer.parseInt(spmsg[2]);
						br.setNamed(named);
						br.setRound(round);
						serchReserv(tc, crud, br);
					} catch (Exception e) {
						tc.sendMessage("회차랑 네임드는 숫자로 입력해 주세요!!").queue();
						e.printStackTrace();
						return;
					}
				} else {
					tc.sendMessage("명령어가 잘못됬어요! \r\n ex)!예약확인 [회차] [네임드]").queue();
				}
				return;
			}

			if (spmsg[0].equals("!예약자호출")) {
				Boss_reservation br = new Boss_reservation();
				Integer round = 0;
				Integer named = 0;
				if (spmsg.length == 3) {
					try {
						round = Integer.parseInt(spmsg[1]);
						named = Integer.parseInt(spmsg[2]);
						br.setNamed(named);
						br.setRound(round);
						callReserv(tc, crud, br);
					} catch (Exception e) {
						tc.sendMessage("회차랑 네임드는 숫자로 입력해 주세요!!").queue();
						e.printStackTrace();
						return;
					}
				} else {
					tc.sendMessage("명령어가 잘못됬어요! \r\n ex)!예약자호출 [회차] [네임드]").queue();
				}
				return;
			}
			if (spmsg[0].equals("!몇일차")) {
				if (day == 0) {
					tc.sendMessage("지금 클랜배틀 시즌이 아니에요!").queue();
					return;
				}
				tc.sendMessage("지금 클랜배틀은" + day + "일차입니다!").queue();
				return;
			}
			if (spmsg[0].equals("!시트")) {
				tc.sendMessage("https://docs.google.com/spreadsheets/d/1-0MOSCHnl2AvRowrXiUetEJJ2max3qM-9tD-HXGCBF4/edit#gid=761571887").queue();
				return;
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

				if (spmsg[0].equals("!데미지삭제")) {
					Condition c = new Condition();
					Calendar cal = Calendar.getInstance();
					Calendar startDate = Calendar.getInstance();
					Calendar endDate = Calendar.getInstance();
					String startDateF = "";
					String endDateF = "";
					SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					if (cal.get(Calendar.HOUR_OF_DAY) >= 5) {
						startDate.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
								5, 0, 0);
						endDate.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) + 1,
								5, 0, 0);
						startDateF = smp.format(new Date(startDate.getTimeInMillis()));
						endDateF = smp.format(new Date(endDate.getTimeInMillis()));

					} else {
						startDate.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
								cal.get(Calendar.DAY_OF_MONTH) - 1, 5, 0, 0);
						endDate.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 5,
								0, 0);
						startDateF = smp.format(new Date(startDate.getTimeInMillis()));
						endDateF = smp.format(new Date(endDate.getTimeInMillis()));
					}
					c.setStartDate(startDateF);
					c.setEndDate(endDateF);
					c.setUser_code(user.getAsMention());
					crud.resetDamage(c);
					User_table user_table = new User_table();
					user_table.setUser_code(user.getAsMention());
					user_table = crud.selectUser(user_table);
					crud.resetCpUser(user.getAsMention());
					try {
						sheet.deleteSheets(day, user_table.getUser_name());
					} catch (IOException e) {
						e.printStackTrace();
					}
					tc.sendMessage("오늘 넣으신 딜량이 초기화 되었어요!").queue();
					return;
				}
			}

			if (tc.getName().equals("커맨드") && user.getAsMention().equals("<@363657198347485186>")) {
				if (spmsg[0].equals("!날짜지정")) {
					if (spmsg.length < 3) {
						tc.sendMessage("잘못된 형식입니다.").queue();
						return;
					}
					String start = spmsg[1];
					String end = spmsg[2];
					try {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

						dateFormat.setLenient(false);
						dateFormat.parse(start);
						dateFormat.parse(end);

					} catch (ParseException e) {
						tc.sendMessage("날짜 형식이 잘못된 형식입니다.").queue();
					}
					Clan_date cd = new Clan_date();
					cd.setEnd_day(end);
					cd.setStart_day(start);
					crud.insertClanDate(cd);
					tc.sendMessage("등록되었습니다.").queue();
				}

				if (spmsg[0].equals("!cp초기화")) {
					crud.resetCp();
					tc.sendMessage("하으으.. 초기화 되었어요!!").queue();
					return;
				}
				if (spmsg[0].equals("!유저초기화")) {
					crud.resetUser();
					tc.sendMessage("하으으.. 초기화 되었어요!!").queue();
					return;
				}
				if (spmsg[0].equals("!유저추방")) {
					if (spmsg.length != 2) {
						tc.sendMessage("명령어를 정확하게 사용해주세요. \r\n ex)!유저추방 [유저명]").queue();
						return;
					}
					String user_name = spmsg[1];
					crud.deleteUser(user_name);
					tc.sendMessage(user_name + "님이 추방 되었습니다.").queue();
					return;
				}
				if (spmsg[0].equals("!유저DB복사")) {
					List<User_table> ul = crud.selectUserList();
					for (User_table user_table : ul) {
						String str = "insert into user_table values(";
						str += "'" + user_table.getUser_code() + "'" + ",";
						str += "'" + user_table.getUser_name() + "'" + ",";
						str += user_table.getCp_count() + ");";
						System.out.println(str);
					}
					return;
				}
				if (spmsg[0].equals("!보스DB복사")) {
					List<Boss_count> ul = crud.selectBossList();
					for (Boss_count bc : ul) {
						String str = "insert into boss_count values(";
						str += "'" + bc.getUser_code() + "'" + ",";
						str += bc.getRound() + ",";
						str += bc.getNamed() + ",";
						str += bc.getDamage() + ",";
						str += bc.getNext_time() + ",";
						str += "'" + bc.getAttack_date() + "'" + ");";
						System.out.println(str);
					}
					return;
				}
				if (spmsg[0].equals("!예약DB복사")) {
					Boss_reservation br = new Boss_reservation();
					br.setNamed(0);
					br.setRound(0);
					List<Boss_reservation> ul = crud.selectBossReservAll(br);
					for (Boss_reservation bc : ul) {
						String str = "insert into boss_reservation values(";
						str += "'" + bc.getUser_code() + "'" + ",";
						str += "'" + bc.getUser_name() + "'" + ",";
						str += bc.getRound() + ",";
						str += bc.getNamed() + ",";
						str += bc.getDamage() + ",";
						str += bc.getNext_time() + ",";
						str += "'" + bc.getReserv_date() + "'" + ");";
						System.out.println(str);

					}
					return;
				}
			}
		} else {
			if (message.equals("!명령어")) {
				EmbedBuilder emb = new EmbedBuilder();
				emb.setColor(Color.yellow);
				emb.setTitle("명령어 모음");
				emb.addField("!주사위", "0~100까지 숫자중 랜덤으로 하나 출력", false);
				emb.addField("!전열or중열or후열", "해당 포지션의 캐릭터들을 보여줍니다.", false);
				emb.addField("-캐릭터키워드", "해당캐릭터의 정보를 보여줍니다 ex)-페코린느,ex)-마망", false);
				tc.sendMessage(emb.build()).queue();
				return;
			}
		}

	}

	private void serchChar(String keyword, CrudProcess crud, TextChannel tc) {
		try {
			Character_db chr = crud.selectChar("%" + keyword + "%");
			EmbedBuilder emb = new EmbedBuilder();
			String rare = "";
			if (chr.getC_rare() == 1) {
				rare = "★";
			} else if (chr.getC_rare() == 2) {
				rare = "★★";
			} else if (chr.getC_rare() == 3) {
				rare = "★★★";
			}
			String[] ub = chr.getC_ub().split(":");
			String[] skill1 = chr.getC_skill1().split(":");
			String[] skill2 = chr.getC_skill2().split(":");
			String[] exSkill = chr.getC_exSkill().split(":");
			String[] equ = chr.getC_equipment().split(":");
			String[] rare6 = chr.getC_rare6().split(":");
			equ[2] = equ[2].replace("\\r\\n", "\r\n");
			ub[1] = ub[1].replace("\\r\\n", "\r\n");
			skill1[1] = skill1[1].replace("\\r\\n", "\r\n");
			skill2[1] = skill2[1].replace("\\r\\n", "\r\n");
			rare6[1] = rare6[1].replace("\\r\\n", "\r\n");
			exSkill[1] = exSkill[1].replace("\\r\\n", "\r\n");
			emb.setTitle(chr.getC_name());
			emb.setColor(Color.yellow);
			String height = "";
			String weight = "";
			String age = "";
			if (chr.getC_height() == 999) {
				height = "알수없음";
			} else {
				height = chr.getC_height() + "cm";
			}
			if (chr.getC_weight() == 999) {
				weight = "알수없음";
			} else {
				weight = chr.getC_weight() + "kg";
			}
			if (chr.getC_age() == 999) {
				age = "알수없음";
			} else {
				age = chr.getC_age() + "살";
			}
			emb.addField("**`신장`**", height, true);
			emb.addField("**`체중`**", weight, true);
			emb.addField("**`나이`**", age, true);
			emb.addField("**`생일`**", chr.getC_birthday(), true);
			emb.addField("**`길드`**", chr.getC_guild(), true);
			emb.addField("**`성우`**", chr.getC_voice(), true);
			emb.addField("**`포지션`**", chr.getC_position() + "(" + chr.getC_location() + ")", true);
			emb.addField("**`초기레어도`**", rare, true);
			emb.addField("**`UB`**:" + ub[0], ub[1], false);
			emb.addField("**`1스킬`**:" + skill1[0], skill1[1], false);
			emb.addField("**`2스킬`**:" + skill2[0], skill2[1], false);
			emb.addField("**`EX스킬`**:" + exSkill[0], exSkill[1], false);
			emb.addField("**`전용장비`**:" + equ[0] + "(" + equ[1] + ")", equ[2], false);
			emb.addField("**`6성`**:" + rare6[0], rare6[1], false);
			emb.setImage(chr.getC_image());
			emb.setThumbnail(chr.getC_sub_image());
			tc.sendMessage(emb.build()).queue();
		} catch (NullPointerException e) {

		} catch (Exception e) {
			e.printStackTrace();
			tc.sendMessage("오류가 낫나봐요. 다시 시도해주세요.").queue();
		}
	}

	private void callReserv(TextChannel tc, CrudProcess crud, Boss_reservation br) {
		List<Boss_reservation> brList = crud.selectBossReservAll(br);
		if (brList.size() == 0 || brList == null) {
			tc.sendMessage("예약자가 없습니다.").queue();
			return;
		}

		String str = "";
		for (Boss_reservation list : brList) {
			str += list.getUser_code() + "씨! ";
		}
		str += br.getRound() + "회차 " + br.getNamed() + "네임드 예약자 호출이에요!!";
		tc.sendMessage(str).queue();
	}

	private void serchReserv(TextChannel tc, CrudProcess crud, Boss_reservation br) {
		List<Boss_reservation> brList = crud.selectBossReservAll(br);
		if (brList.size() == 0 || brList == null) {
			tc.sendMessage("예약자가 없습니다.").queue();
			return;
		}
		int round = 0;
		int named = 0;
		String str = "";
		for (Boss_reservation list : brList) {
			if (round != list.getRound()) {
				if (str.length() != 0) {
					str += "```";
					tc.sendMessage(str).queue();
				}
				str = "```cs";
				round = list.getRound();
				named = 0;
				str += "\r\n#=====" + round + "회차=====\r\n";
			}
			if (named != list.getNamed()) {
				named = list.getNamed();
				str += "\r\n'" + named + "넴'\r\n";

			}
			if (list.getNext_time() == 1) {
				str += list.getUser_name() + " 이월 ";
			} else {
				str += list.getUser_name() + " ";
			}
			if (list.getDamage() > 0) {
				str += "예상 데미지 : " + list.getDamage() + "\r\n";
			} else {
				str += "\r\n";
			}
		}
		str += "```";
		tc.sendMessage(str).queue();
	}

	private void reservation(Boss_reservation br, CrudProcess crud, TextChannel tc, String user_code) {
		Date date = new Date();
		SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String reserv_date = smp.format(date);
		br.setReserv_date(reserv_date);
		User_table user_table = new User_table();
		user_table.setUser_code(user_code);
		user_table = crud.selectUser(user_table);
		br.setUser_name(user_table.getUser_name());
		crud.insertReserv(br);
		tc.sendMessage(user_code + "씨! " + br.getRound() + "회차 " + br.getNamed() + "네임드 예약이 완료 되었습니다!").queue();
	}

	public void serchDamage(String user_code, CrudProcess crud, TextChannel tc) {
		Calendar cal = Calendar.getInstance();
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		String startDateF = "";
		String endDateF = "";
		SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (cal.get(Calendar.HOUR_OF_DAY) >= 5) {
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

	public void serchMonthDamge(String user_code, CrudProcess crud, TextChannel tc) {
		Calendar cal = Calendar.getInstance();
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		String startDateF = "";
		String endDateF = "";
		SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		startDate.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 0, 0, 0, 0);
		endDate.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, 0, 0, 0, 0);
		startDateF = smp.format(new Date(startDate.getTimeInMillis()));
		endDateF = smp.format(new Date(endDate.getTimeInMillis()));
		Condition c = new Condition();
		c.setStartDate(startDateF);
		c.setEndDate(endDateF);
		c.setUser_code(user_code);
		List<Boss_count> damageList = crud.selectBossCount(c);
		String str = "";
		int[][] boss = new int[damageList.get(damageList.size() - 1).getRound()][5];
		int[][] bossV = new int[damageList.get(damageList.size() - 1).getRound()][5];

		for (Boss_count userCp : damageList) {
			int score = userCp.getDamage();
			if (userCp.getRound() <= 3) {
				if (userCp.getNamed() == 1 || userCp.getNamed() == 2) {
					score *= 1;
				} else if (userCp.getNamed() == 4 || userCp.getNamed() == 3) {
					score *= 1.3;
				} else {
					score *= 1.5;
				}
				boss[userCp.getRound() - 1][userCp.getNamed() - 1] = userCp.getDamage();
				bossV[userCp.getRound() - 1][userCp.getNamed() - 1] = score;
			}
			if (userCp.getRound() <= 10 && userCp.getRound() >= 4) {
				if (userCp.getNamed() == 1 || userCp.getNamed() == 2) {
					score *= 1.4;
				} else if (userCp.getNamed() == 4 || userCp.getNamed() == 3) {
					score *= 1.8;
				} else {
					score *= 1.2;
				}
				boss[userCp.getRound() - 1][userCp.getNamed() - 1] = userCp.getDamage();
				bossV[userCp.getRound() - 1][userCp.getNamed() - 1] = score;
			}
			if (userCp.getRound() >= 11) {
				if (userCp.getNamed() == 1 || userCp.getNamed() == 2) {
					score *= 2;
				} else if (userCp.getNamed() == 4 || userCp.getNamed() == 3) {
					score *= 2.5;
				} else {
					score *= 3;
				}
				boss[userCp.getRound() - 1][userCp.getNamed() - 1] = userCp.getDamage();
				bossV[userCp.getRound() - 1][userCp.getNamed() - 1] = score;
			}
		}
		int fullDamge = 0;
		int[][] damge = new int[3][5];
		for (int i = 0; i < boss.length; i++) {
			for (int j = 0; j < boss[i].length; j++) {
				if (i <= 2) {
					damge[0][j] += boss[i][j];
				} else if (i <= 9 || i >= 3) {
					damge[1][j] += boss[i][j];
				} else if (i >= 10) {
					damge[3][j] += boss[i][j];
				}
				fullDamge += boss[i][j];
			}
		}
		String[][] damageS = new String[3][5];
		for (int i = 0; i < damge.length; i++) {
			for (int j = 0; j < damge[i].length; j++) {
				damageS[i][j] = String.format("%07d", damge[i][j]);
			}
		}

		int fullDamgeV = 0;
		int[][] damgeV = new int[3][5];
		for (int i = 0; i < bossV.length; i++) {
			for (int j = 0; j < bossV[i].length; j++) {
				if (i <= 2) {
					damgeV[0][j] += bossV[i][j];
				} else if (i <= 9 || i >= 3) {
					damgeV[1][j] += bossV[i][j];
				} else if (i >= 10) {
					damgeV[3][j] += bossV[i][j];
				}
				fullDamgeV += bossV[i][j];
			}
		}
		String[][] damageSV = new String[3][5];
		for (int i = 0; i < damgeV.length; i++) {
			for (int j = 0; j < damgeV[i].length; j++) {
				damageSV[i][j] = String.format("%07d", damgeV[i][j]);
			}
		}
		str += user_code + "\r\n";
		str += "=================배율미적용================\r\n";
		str += "================1단계 총딜량================\r\n";
		str += "  1네임드      2네임드      3네임드      4네임드      5네임드\r\n";
		str += damageS[0][0] + "  " + damageS[0][1] + "  " + damageS[0][2] + "  " + damageS[0][3] + "  " + damageS[0][4]
				+ "\r\n ";
		str += "================2단계 총딜량================\r\n";
		str += "  1네임드      2네임드      3네임드      4네임드      5네임드\r\n";
		str += damageS[1][0] + "  " + damageS[1][1] + "  " + damageS[1][2] + "  " + damageS[1][3] + "  " + damageS[1][4]
				+ "\r\n";
		str += "================3단계 총딜량================\r\n";
		str += "  1네임드      2네임드      3네임드      4네임드      5네임드\r\n";
		str += damageS[2][0] + "  " + damageS[2][1] + "  " + damageS[2][2] + "  " + damageS[2][3] + "  " + damageS[2][4]
				+ "\r\n ";
		str += "이번달 총 딜 : " + fullDamgeV + "점 입니다.\r\n \r\n";

		str += "==================배율적용=================\r\n";
		str += "================1단계 총딜량================\r\n";
		str += "  1네임드      2네임드      3네임드      4네임드      5네임드\r\n";
		str += damageSV[0][0] + "  " + damageSV[0][1] + "  " + damageSV[0][2] + "  " + damageSV[0][3] + "  "
				+ damageSV[0][4] + "\r\n ";
		str += "================2단계 총딜량================\r\n";
		str += "  1네임드      2네임드      3네임드      4네임드      5네임드\r\n";
		str += damageSV[1][0] + "  " + damageSV[1][1] + "  " + damageSV[1][2] + "  " + damageSV[1][3] + "  "
				+ damageSV[1][4] + "\r\n";
		str += "================3단계 총딜량================\r\n";
		str += "  1네임드      2네임드      3네임드      4네임드      5네임드\r\n";
		str += damageSV[2][0] + "  " + damageSV[2][1] + "  " + damageSV[2][2] + "  " + damageSV[2][3] + "  "
				+ damageSV[2][4] + "\r\n ";
		str += "이번달 배율 적용 총 딜 : " + fullDamge + "점 입니다.";

		tc.sendMessage(str).queue();
	}

	public void serchMonthDamgeAll(String user_code, CrudProcess crud, TextChannel tc) {
		Calendar cal = Calendar.getInstance();
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		String startDateF = "";
		String endDateF = "";
		SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		startDate.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 0, 0, 0, 0);
		endDate.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, 0, 0, 0, 0);
		startDateF = smp.format(new Date(startDate.getTimeInMillis()));
		endDateF = smp.format(new Date(endDate.getTimeInMillis()));
		Condition c = new Condition();
		c.setStartDate(startDateF);
		c.setEndDate(endDateF);
		c.setUser_code(user_code);
		List<Boss_count> damageList = crud.selectBossCount(c);
		String str = "";
		str += user_code + "\r\n";
		int[][] boss = new int[damageList.get(damageList.size() - 1).getRound()][5];
		int[][] bossV = new int[damageList.get(damageList.size() - 1).getRound()][5];

		for (Boss_count userCp : damageList) {
			int score = userCp.getDamage();
			if (userCp.getRound() <= 3) {
				if (userCp.getNamed() == 1 || userCp.getNamed() == 2) {
					score *= 1;
				} else if (userCp.getNamed() == 4 || userCp.getNamed() == 3) {
					score *= 1.3;
				} else {
					score *= 1.5;
				}
				boss[userCp.getRound() - 1][userCp.getNamed() - 1] = userCp.getDamage();
				bossV[userCp.getRound() - 1][userCp.getNamed() - 1] = score;
			}
			if (userCp.getRound() <= 10 && userCp.getRound() >= 4) {
				if (userCp.getNamed() == 1 || userCp.getNamed() == 2) {
					score *= 1.4F;
				} else if (userCp.getNamed() == 4 || userCp.getNamed() == 3) {
					score *= 1.8F;
				} else {
					score *= 1.2F;
				}
				boss[userCp.getRound() - 1][userCp.getNamed() - 1] = userCp.getDamage();
				bossV[userCp.getRound() - 1][userCp.getNamed() - 1] = score;
			}
			if (userCp.getRound() >= 11) {
				if (userCp.getNamed() == 1 || userCp.getNamed() == 2) {
					score *= 2;
				} else if (userCp.getNamed() == 4 || userCp.getNamed() == 3) {
					score *= 2.5F;
				} else {
					score *= 3;
				}
				boss[userCp.getRound() - 1][userCp.getNamed() - 1] = userCp.getDamage();
				bossV[userCp.getRound() - 1][userCp.getNamed() - 1] = score;
			}
			str = str + userCp.getRound() + "회차 " + userCp.getNamed() + "네임드 를 '" + userCp.getDamage() + "' 넣";
			if (userCp.getNext_time() == 1) {
				str += "고 이월 되었습니다.\r\n";
			} else {
				str += "었습니다.\r\n";
			}
		}
		int fullDamge = 0;
		int[][] damge = new int[3][5];
		for (int i = 0; i < boss.length; i++) {
			for (int j = 0; j < boss[i].length; j++) {
				if (i <= 2) {
					damge[0][j] += boss[i][j];
				} else if (i <= 9 || i >= 3) {
					damge[1][j] += boss[i][j];
				} else if (i >= 10) {
					damge[2][j] += boss[i][j];
				}
				fullDamge += boss[i][j];
			}
		}
		String[][] damageS = new String[3][5];
		for (int i = 0; i < damge.length; i++) {
			for (int j = 0; j < damge[i].length; j++) {
				damageS[i][j] = String.format("%07d", damge[i][j]);
			}
		}

		int fullDamgeV = 0;
		int[][] damgeV = new int[3][5];
		for (int i = 0; i < bossV.length; i++) {
			for (int j = 0; j < bossV[i].length; j++) {
				if (i <= 2) {
					damgeV[0][j] += bossV[i][j];
				} else if (i <= 9 || i >= 3) {
					damgeV[1][j] += bossV[i][j];
				} else if (i >= 10) {
					damgeV[2][j] += bossV[i][j];
				}
				fullDamgeV += bossV[i][j];
			}
		}
		String[][] damageSV = new String[3][5];
		for (int i = 0; i < damgeV.length; i++) {
			for (int j = 0; j < damgeV[i].length; j++) {
				damageSV[i][j] = String.format("%07d", damgeV[i][j]);
			}
		}

		str += "=================배율미적용================\r\n";
		str += "================1단계 총딜량================\r\n";
		str += "  1네임드      2네임드      3네임드      4네임드      5네임드\r\n";
		str += damageS[0][0] + "  " + damageS[0][1] + "  " + damageS[0][2] + "  " + damageS[0][3] + "  " + damageS[0][4]
				+ "\r\n ";
		str += "================2단계 총딜량================\r\n";
		str += "  1네임드      2네임드      3네임드      4네임드      5네임드\r\n";
		str += damageS[1][0] + "  " + damageS[1][1] + "  " + damageS[1][2] + "  " + damageS[1][3] + "  " + damageS[1][4]
				+ "\r\n";
		str += "================3단계 총딜량================\r\n";
		str += "  1네임드      2네임드      3네임드      4네임드      5네임드\r\n";
		str += damageS[2][0] + "  " + damageS[2][1] + "  " + damageS[2][2] + "  " + damageS[2][3] + "  " + damageS[2][4]
				+ "\r\n ";
		str += "이번달 총 딜 : " + fullDamge + "점 입니다.\r\n \r\n";

		str += "==================배율적용=================\r\n";
		str += "================1단계 총딜량================\r\n";
		str += "  1네임드      2네임드      3네임드      4네임드      5네임드\r\n";
		str += damageSV[0][0] + "  " + damageSV[0][1] + "  " + damageSV[0][2] + "  " + damageSV[0][3] + "  "
				+ damageSV[0][4] + "\r\n ";
		str += "================2단계 총딜량================\r\n";
		str += "  1네임드      2네임드      3네임드      4네임드      5네임드\r\n";
		str += damageSV[1][0] + "  " + damageSV[1][1] + "  " + damageSV[1][2] + "  " + damageSV[1][3] + "  "
				+ damageSV[1][4] + "\r\n";
		str += "================3단계 총딜량================\r\n";
		str += "  1네임드      2네임드      3네임드      4네임드      5네임드\r\n";
		str += damageSV[2][0] + "  " + damageSV[2][1] + "  " + damageSV[2][2] + "  " + damageSV[2][3] + "  "
				+ damageSV[2][4] + "\r\n ";
		str += "이번달 배율 적용 총 딜 : " + fullDamgeV + "점 입니다.";

		tc.sendMessage(str).queue();

	}

	public void serchTodayDamage(CrudProcess crud, TextChannel tc) {
		Calendar cal = Calendar.getInstance();
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		String startDateF = "";
		String endDateF = "";
		SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (cal.get(Calendar.HOUR_OF_DAY) >= 5) {
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
		List<User_boss_count> damageList = crud.selectTodayAllDamage(c);
		String str = "=====오늘전체딜량=====";
		String name = "";
		for (User_boss_count list : damageList) {
			if (!name.equals(list.getUser_name())) {
				name = list.getUser_name();
				tc.sendMessage(str).queue();
				str = "";
			}
			str += list.getUser_name() + "님 " + list.getRound() + "회차 " + list.getNamed() + "네임드 를 '" + list.getDamage()
					+ "' 넣";
			if (list.getNext_time() == 1) {
				str += "고 이월 되었습니다.\r\n";
			} else {
				str += "었습니다.\r\n";
			}

		}

	}

	public void inputDamage(String[] spmsg, TextChannel tc, String user_code, CrudProcess crud) {
		if (day == 0) {
			tc.sendMessage("아직 클랜전이 아니에요!").queue();
			return;
		}
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
		try {
			Boss_reservation br = new Boss_reservation();
			br.setNamed(named);
			br.setRound(round);
			br.setUser_code(user_code);
			crud.deleteBossReserv(br);
			sheet.inputSheets(day, selUser.getUser_name(), round, named, damage, next_time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tc.sendMessage(round + "회차 " + named + "네임드 " + damage + "입력이  완료되었어요!").queue();
		if (next_time == 0) {
			if (selUser.getCp_count() == 1) {
				tc.sendMessage("와! " + selUser.getUser_code() + "씨는 오늘 3번 다 치셨군요! 오늘 수고하셨습니다!").queue();
			}
		}
	}
}
