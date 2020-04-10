package main;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;

public class Main{
	public static JDA jda;
	public static void main(String[] args) {
		JDABuilder jb = new JDABuilder(AccountType.BOT);
		jb.setAutoReconnect(true);
		jb.setStatus(OnlineStatus.DO_NOT_DISTURB);
		jb.setToken("NjkzODQyMDE0MTI2NDczMjM3.XoC9LQ.a_YEDtMJz7Pkb8x4fB3JMyE2J2M");
		jb.addEventListener(new TListener());
		new BotTimer().start();
		try {
			jda= jb.buildBlocking();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
