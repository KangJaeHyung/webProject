package mainStart;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import crud.CrudProcess;
import model.Clan_date;
import net.dv8tion.jda.api.JDA;

public class BotTimer extends Thread {
	CrudProcess crud;
	JDA jda;

	public BotTimer(JDA jda) {
		crud = new CrudProcess();
		this.jda = jda;
	}

	@Override
	public void run() {
		while (true) {
			Calendar c = Calendar.getInstance();
			if (c.get(Calendar.HOUR_OF_DAY) == 5 && c.get(Calendar.MINUTE) == 0) {
				crud.resetCp();
				crud.resetBr();
				try {
					checkDay();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Clan_date cd = crud.selectDay();
				if (TListener.day != 0) {
					jda.getTextChannelById("600297082703577088")
							.sendMessage(TListener.day + "일차 입니다. cp가 초기화 되었어요! 오늘 하루도 힘내보죠!").queue();
					jda.getTextChannelById("600296449603010565")
							.sendMessage(TListener.day + "일차 입니다. cp가 초기화 되었어요! 오늘 하루도 힘내보죠!").queue();
				}

			}
			if (c.get(Calendar.HOUR_OF_DAY) == 0 && c.get(Calendar.MINUTE) == 0) {
				crud.resetGateCp();
				Clan_date day = crud.selectDay();
				if (day != null) {
					String start = day.getStart_day();
					String end = day.getEnd_day();
					SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd");
					Date startDate = null;
					Date endDate = null;
					try {
						startDate = smp.parse(start);
						endDate = smp.parse(end);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Date date = new Date();
					int a = date.compareTo(startDate);
					int b = date.compareTo(endDate);
					if (a >= 0 && b >= 0) {
						crud.deleteDate();
						crud.resetDmg();
						jda.getTextChannelById("600297082703577088").sendMessage("클랜전이 끝났습니다! 모두 수고하셧어요!").queue();
					}
				} else {
					TListener.day = 0;
				}
			}
			try {
				Thread.sleep(59998);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void checkDay() throws ParseException {
		Clan_date day = crud.selectDay();
		if (day != null) {
			String start = day.getStart_day();
			String end = day.getEnd_day();
			SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = smp.parse(start);
			Date endDate = smp.parse(end);
			Date date = new Date();
			int a = date.compareTo(startDate);
			int b = date.compareTo(endDate);

			if (a >= 0 && b < 0) {
				crud.updateDay();
				day.setDay(day.getDay() + 1);
			}
			if (a >= 0 && b >= 0) {
				crud.deleteDate();
				
				jda.getTextChannelById("600297082703577088").sendMessage("클랜전이 끝났습니다! 모두 수고하셧어요!").queue();
			}
			TListener.day = day.getDay();
			if (TListener.day == 1) {
				jda.getTextChannelById("600297082703577088").sendMessage("클랜전이 시작됬어요! 모두 힘내보죠!").queue();
			}
		} else {
			TListener.day = 0;
		}
	}

}
