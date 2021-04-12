package mainStart;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import crud.CrudProcess;
import model.Boss_count;
import model.Boss_reservation;
import model.Clan_date;
import model.Condition;
import model.User_table;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class TListener extends ListenerAdapter {
	static int day = 0;
	static int round;
	static int named;
	

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		User user = event.getAuthor();
		TextChannel tc = event.getTextChannel();
		Message msg = event.getMessage();
		String[] spmsg = msg.getContentRaw().split(" ");
		CrudProcess crud = new CrudProcess();
		Guild guild = event.getGuild();
		String message = msg.getContentRaw();

		if (spmsg[0].equals("!권한")&&user.getAsMention().equals("<@363657198347485186>")) {
			String mem=spmsg[1].replace("<", "").replace(">", "").replace("!", "").replace("@", "");
			Member member= guild.getMemberById(mem);
			System.out.println(member.getRoles());
			guild.addRoleToMember(member, guild.getRoles().get(5));
			System.out.println(member.getRoles());
			tc.sendMessage("권한을 드렸습니다.").queue();
			return;
		}
		if(spmsg[0].equals("!권한해제")&&user.getAsMention().equals("<@363657198347485186>")) {
			String mem=spmsg[1].replace("<", "").replace(">", "").replace("!", "").replace("@", "");
			guild.removeRoleFromMember(guild.getMemberById(mem), guild.getRoles().get(5));
			tc.sendMessage("권한을 삭제했습니다.").queue();
			return;
		}

		if (user.isBot())
			return;
		if (message.length() < 1) {
			return;
		}

		if (spmsg[0].equals("!개발자")) {
			tc.sendMessage("저를 만드신분은 Fuko에요.").queue();
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
		// 전국리마협회 가테지부

		// 아카리뿌
		if (guild.getId().equals("600296449603010563")) {
			

			if (spmsg[0].equals("!계산1")) {
				if (spmsg.length < 3) {
					tc.sendMessage("명령어가 잘못되었어요!\r\n ex)!계산 1000000 2000000").queue();
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
					tc.sendMessage("명령어가 잘못되었어요!\r\n ex)!계산 1000000 2000000").queue();
				}
				return;
			}
			if (spmsg[0].equals("!계산2")) {
				if (spmsg.length < 2) {
					tc.sendMessage("명령어가 잘못되었어요!\r\n ex)!계산2 2000000").queue();
					return;
				}
				try {
					float damge = Integer.parseInt(spmsg[1]);
					float hp = damge * 2 / 9F;
					tc.sendMessage(Math.round(hp + 0.5) + "이하로 남으면 풀이월 받을수 있어요!").queue();

				} catch (Exception e) {
					tc.sendMessage("명령어가 잘못되었어요!\r\n ex)!계산2 2000000").queue();
				}
				return;
			}
			if (spmsg[0].equals("!계산3")) {
				if (spmsg.length < 2) {
					tc.sendMessage("명령어가 잘못되었어요!\r\n ex)!계산3 2000000").queue();
					return;
				}
				try {
					float hp = Integer.parseInt(spmsg[1]);
					float damage = hp * 4.3F;
					tc.sendMessage((int) damage + "이상 넣으면 풀이월 받을수 있어요!").queue();

				} catch (Exception e) {
					tc.sendMessage("명령어가 잘못되었어요!\r\n ex)!계산3 2000000").queue();
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
			if (spmsg[0].equals("!이월")) {
				List<User_table> userList = crud.selectUserList();
				String user_name = "```\r\n";
				user_name = user_name + "**이월자 목록**\r\n";
				for (User_table userL : userList) {
					if (userL.getCarry() == null || userL.getCarry() == 0) {

					} else {
						user_name = user_name + userL.getUser_name() + ":" + userL.getCarry_named() + "네임드 "
								+ userL.getCarry_time() + "초" + "\r\n";
					}
				}
				user_name = user_name + "```";
				tc.sendMessage(user_name).queue();
				return;
			}

			if (spmsg[0].equals("!cp") || spmsg[0].equals("!CP")) {
				List<User_table> userList = crud.selectUserList();
				EmbedBuilder emb = new EmbedBuilder();
				emb.setTitle("현재 남은 cp");
				emb.setColor(Color.yellow);
				Integer cp = 0;
				for (User_table us : userList) {
					if (us.getCp_count() != 0) {

						if (us.getCarry() == null || us.getCarry() == 0) {
							emb.addField(us.getUser_name(), us.getCp_count() + "타", true);
							cp += us.getCp_count();
						} else {
							emb.addField(us.getUser_name(),
									us.getCp_count() + "타 (이월" + us.getCarry_named() + "넴 " + us.getCarry_time() + "초)",
									true);
							cp += us.getCp_count();
						}
					}
				}
				emb.setFooter("총 " + cp + "번 남았습니다.", null);
				tc.sendMessage(emb.build()).queue();
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
					if (spmsg.length == 1) {
						crud.deleteBossReservAll(user.getAsMention());
						tc.sendMessage(user.getAsMention() + "씨에 모든 예약이 삭제되었어요!").queue();
					} else {
						tc.sendMessage("명령어가 잘못됬어요! \r\n ex)!예약취소 [회차] [네임드]").queue();
						return;
					}
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

			if (spmsg[0].equals("!호출")) {
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
			if (spmsg[0].equals("!확인")) {
				if (spmsg.length == 1) {
					serchBossCount(user.getAsMention(), crud, tc);
				} else {
					String user_code = spmsg[1].replace("!", "");
					serchBossCount(user_code, crud, tc);
				}
				return;
			}

			if (tc.getName().equals("3타완료보고")) {
				if (spmsg[0].equals("!입력")) {
					if (spmsg.length < 3 || spmsg.length > 4) {
						tc.sendMessage(user.getAsMention() + "데미지등록에 실패했어욧!! 우리 다시한번 형식에 맞게 입력해봐요.").queue();
					} else {
						inputDamage(spmsg, tc, user.getAsMention(), crud);
					}
				}
				if (spmsg[0].equals("!대리입력")) {
					if (spmsg.length < 4 || spmsg.length > 5) {
						tc.sendMessage("데미지등록에 실패했어욧!! 우리 다시한번 형식에 맞게 입력해봐요.").queue();
					} else {
						String user_code = spmsg[1];
						user_code = user_code.replace("!", "");
						String newSpmsg[] = new String[spmsg.length - 1];
						newSpmsg[0] = spmsg[0];
						for (int i = 2; i < spmsg.length; i++) {
							newSpmsg[i - 1] = spmsg[i];
						}
						inputDamage(newSpmsg, tc, user_code, crud);
					}
				}

				if (spmsg[0].equals("!전체삭제")) {
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

					tc.sendMessage("오늘 넣으신 딜량이 초기화 되었어요!").queue();

					return;
				}
				if (spmsg[0].equals("!최근삭제")) {
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

					List<Boss_count> bc = crud.selectBossCount(c);
					if (bc.size() == 0 || bc.isEmpty()) {
						tc.sendMessage(user.getAsMention() + "님은 오늘 친 기록이 없습니다.").queue();
						return;
					}
					Boss_count lastbc = bc.get(bc.size() - 1);
					Integer round = lastbc.getRound();
					Integer named = lastbc.getNamed();
					Integer next = lastbc.getNext_time();
					String date = lastbc.getAttack_date();

					c.setNamed(named);
					c.setRound(round);
					c.setAttack_date(date);

					User_table user_table = new User_table();
					user_table.setUser_code(user.getAsMention());
					user_table = crud.selectUser(user_table);
					try {
						crud.deleteDamgeOne(c);
						if (next == 0) {
							crud.addCpUser(user.getAsMention());
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					tc.sendMessage("방금전 입력한 딜량을 삭제했어요!").queue();
					return;

				}

			}

			if (tc.getName().equals("커맨드")/* && user.getAsMention().equals("<@363657198347485186>")*/) {
				if (spmsg[0].equals("!명령어")) {
					EmbedBuilder emb = new EmbedBuilder();
					emb.setColor(Color.yellow);
					emb.setTitle("커맨드 명령어 모음");
					emb.addField("!날짜지정 yyyy-mm-dd yyyy-mm-dd", "클랜 날짜지정 앞에는 시작 날짜 뒤에는 종료날짜+1", false);
					emb.addField("!날짜삭제", "등록한 날짜 삭제", false);
					emb.addField("!유저추방 [유저명]", "닉네임 입니다 맨션아닙니다.", false);
					tc.sendMessage(emb.build()).queue();
					return;
				}
				if (spmsg[0].equals("!날짜지정")) {
					if (spmsg.length < 3) {
						tc.sendMessage("잘못된 형식입니다.").queue();
						return;
					}
					String start = spmsg[1];
					String end = spmsg[2];
					Date startD = null;
					Date endD = null;
					try {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						dateFormat.setLenient(false);
						startD = dateFormat.parse(start);
						endD = dateFormat.parse(end);
					} catch (ParseException e) {
						tc.sendMessage("날짜 형식이 잘못된 형식입니다.").queue();
					}
					Date d = new Date();
					long cha = d.getTime() - startD.getTime();
					if (cha >= 0) {
						day = (int) (cha / (24 * 60 * 60 * 1000)) + 1;
					}
					Clan_date cd = new Clan_date();
					cd.setDay(day);
					cd.setEnd_day(end);
					cd.setStart_day(start);
					crud.insertClanDate(cd);
					tc.sendMessage("등록되었습니다. " + day).queue();
				}
				if (spmsg[0].equals("!날짜삭제")) {

					crud.deleteClanDate();
					day=0;
					tc.sendMessage("삭제되었습니다.").queue();
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

			}else {
				if (spmsg[0].equals("!명령어")) {
					EmbedBuilder emb = new EmbedBuilder();
					emb.setColor(Color.yellow);
					emb.setTitle("명령어 모음");
					emb.addField("!주사위", "0~100까지 숫자중 랜덤으로 하나 출력", false);
					emb.addField("!유저등록 [자신의 닉네임]", "자신을 DB에 등록합니다.", false);
					emb.addField("!계산1 [보스체력] [데미지]", "이월 시간 계산", false);
					emb.addField("!계산2 [자신이넣은딜량]", "풀이월받으려면 남아있는 보스의 hp", false);
					emb.addField("!계산3 [보스의남은hp]", "풀이월받으려면 넣어야할 딜량", false);
					emb.addField("!cp확인", "오늘 남은 cp를 보여드립니다.", false);
					emb.addField("!확인 [@맨션]", "오늘 자신이 친 이력확인 뒤에 맨션 붙일시 그사람 확인", false);
					emb.addField("!확인", "현재 이월자 확인", false);
					emb.addField("!호출 [회차][네임드]", "해당 회차 네임드를 예약한 유저를 호출합니다", false);
					emb.addField("!예약확인 [회차] [네임드]", "회차랑 네임드 안적을시 모든 예약 정보가 나옵니다.", false);
					emb.addField("!예약 [회차] [네임드] [예상데미지] [이월]", "회차랑 네임드는 필수로 적고 데미지랑 이월은 필수가 아닙니다.", false);
					emb.addField("!예약취소 [회차] [네임드]", "해당회차 예약 취소. 회차랑 네임드 적지 않을시 전체취소", false);
					emb.addField("===3타완료보고서에 써주세요.===", "", false);
					emb.addField("!입력 [회차] [네임드] [이월시간]", "자신이 해당 회차 네임드에 넣은 딜량을 DB에 입력합니다. 마무리 했을 경우 이월시간을 입력하면 됩니다.",
							false);
					emb.addField("!대리입력 [유저맨션] [회차] [네임드] [이월시간]",
							"해당 유저의 회차 네임드에 넣은 딜량을 DB에 입력합니다. 마무리 했을 경우 이월시간을 입력하면 됩니다.", false);
					emb.addField("!전체삭제", "오늘 자신이 넣은 데미지 전체를 삭제합니다.", false);
					emb.addField("!최근삭제", "방금 자신이 입력한 데미지를 삭제합니다.", false);
					tc.sendMessage(emb.build()).queue();
					return;
				}
			}
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

	private void serchBossCount(String user_code, CrudProcess crud, TextChannel tc) {
		User_table user = new User_table();
		user.setUser_code(user_code);
		user = crud.selectUser(user);
		if (user == null || user.getUser_code() == null || user.getUser_code().equals("")) {
			tc.sendMessage(user_code + "등록되지 않은 유저에요! 일단 유저 등록부터 해보죠!").queue();
			return;
		}
		Condition c = new Condition();
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
		c.setStartDate(startDateF);
		c.setEndDate(endDateF);
		c.setUser_code(user_code);
		List<Boss_count> bcList = crud.selectBossCount(c);
		String str = user_code + "씨의 오늘histroy\r\n";
		for (Boss_count bc : bcList) {
			if (bc.getNext_time() == null || bc.getNext_time() == 0) {
				str += +bc.getRound() + "회차 " + bc.getNamed() + "네임드 \r\n";
			} else {
				str += +bc.getRound() + "회차 " + bc.getNamed() + "네임드 [이월] \r\n";
			}
		}
		tc.sendMessage(str).queue();
	}

	public void inputDamage(String[] spmsg, TextChannel tc, String user_code, CrudProcess crud) {
		if (day == 0) {
			tc.sendMessage("아직 클랜전이 아니에요!").queue();
			return;
		}
		tc.sendMessage(user_code + "데미지 등록중이에요! 잠시만기달려주세요!").queue();
		int size = spmsg.length;
		for (int i = 0; i < size; i++) {
			if (spmsg[i] == null || spmsg[i].equals("")) {
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
		Integer carry_time = 0;
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
			if (spmsg.length == 4) {
				carry_time = Integer.parseInt(spmsg[3]);
				next_time = 1;
			}
		} catch (NumberFormatException e) {
			tc.sendMessage("'" + spmsg[3] + "' 부분이 잘못된 형식입니다.").queue();
			return;
		}
		Boss_count boss_count = new Boss_count();
		Date date = new Date();
		SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String attack_date = smp.format(date);
		boss_count.setAttack_date(attack_date);
		boss_count.setNamed(named);
		boss_count.setNext_time(next_time);
		boss_count.setRound(round);
		boss_count.setUser_code(user_code);
		User_table usert = new User_table();
		usert.setUser_code(user_code);
		usert.setCarry(1);
		usert.setCarry_named(named);
		usert.setCarry_time(carry_time);
		try {
			crud.insertBossDamage(boss_count);
			if (next_time == 1) {
				crud.updateUserCarryCount(usert);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (next_time == 1) {
			tc.sendMessage(round + "회차 " + named + "네임드 이월 " + carry_time + "초 입력이  완료되었어요!").queue();
		} else {
			tc.sendMessage(round + "회차 " + named + "네임드 " + " 입력이  완료되었어요!").queue();
		}
		if (next_time == 0) {
			if (selUser.getCp_count() == 1) {
				tc.sendMessage("와! " + selUser.getUser_code() + "씨는 오늘 3번 다 치셨군요! 오늘 수고하셨습니다!").queue();
			}
		}
	}
}
