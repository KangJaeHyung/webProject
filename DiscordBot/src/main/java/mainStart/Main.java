package mainStart;

import java.util.List;

import crud.CrudProcess;
import model.Boss_count;
import model.Clan_date;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Game.GameType;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;

public class Main {
	public static JDA jda;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		JDABuilder jb = new JDABuilder(AccountType.BOT);
		jb.setAutoReconnect(true);
		jb.setStatus(OnlineStatus.DO_NOT_DISTURB);
		jb.setToken("NjkzODQyMDE0MTI2NDczMjM3.");//Xu92tQ.Sv1C54Uxz6ywBRNLPgu94SqwPeM
		jb.addEventListener(new TListener());
		jb.setGame(Game.of(GameType.DEFAULT, "귀여운 막둥이 일"));
		jb.setStatus(OnlineStatus.ONLINE);

		try {
			jda = jb.buildBlocking();
			List<Guild> glist = jda.getGuilds();
			for (Guild guild : glist) {
				System.out.println(guild.getName() + " : " + guild.getId());
				System.out.println(guild.getOwner().getEffectiveName()+guild.getOwner().getAsMention());
			}
//		

			new BotChat(jda).start();
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
