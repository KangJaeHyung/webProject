package mainStart;

import java.util.List;

import crud.CrudProcess;
import model.Boss_count;
import model.Clan_date;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.internal.requests.WebSocketClient;

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
			jda = JDABuilder.createDefault("NjkzODQyMDE0MTI2NDczMjM3.XoC8uw.").build();//nUic48pVYIzfgDu5EywsLVSCi0o
			jda.addEventListener(new TListener());
			List<Guild> glist = jda.getGuilds();
			for (Guild guild : glist) {
				System.out.println(guild.getName() + " : " + guild.getId());
				System.out.println(guild.getOwner().getEffectiveName() + guild.getOwner().getAsMention());
			}
			BotTimer timer = new BotTimer(jda);
			timer.start();
			CrudProcess crud = new CrudProcess();
			Clan_date date=crud.selectDay();
			if(date!=null) {
				TListener.day= date.getDay();	
				Boss_count bs = crud.selectRN();
				System.out.println(TListener.day);
			}else {
				TListener.day= 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
