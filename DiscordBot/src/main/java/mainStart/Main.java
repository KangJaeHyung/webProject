package mainStart;

import java.util.List;

import crud.CrudProcess;
import model.Boss_count;
import model.Clan_date;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.audit.ActionType;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Activity.ActivityType;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {
	public static JDA jda;

	public static void main(String[] args) {
//		JDABuilder jb = new JDABuilder(AccountType.BOT);
//		jb.setAutoReconnect(true);
//		jb.setStatus(OnlineStatus.DO_NOT_DISTURB);
//		jb.setToken("");//
//		jb.addEventListeners(new TListener());
//		jb.setStatus(OnlineStatus.ONLINE);
		try {
			jda = JDABuilder.create("NjkzODQyMDE0MTI2NDczMjM3",//nUic48pVYIzfgDu5EywsLVSCi0o//.XoC8uw.
					GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS).setActivity(Activity.of(ActivityType.DEFAULT, "귀여운 막둥이 일")).build();//
			jda.addEventListener(new TListener());
			List<Guild> glist = jda.getGuilds();
			BotTimer timer = new BotTimer(jda);
			timer.start();
			CrudProcess crud = new CrudProcess();
			Clan_date date = crud.selectDay();
			if (date != null) {
				TListener.day = date.getDay();
				Boss_count bs = crud.selectRN();
				System.out.println(TListener.day);
			} else {
				TListener.day = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
