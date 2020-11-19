package mainStart;

import java.util.Scanner;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

public class BotChat extends Thread {
	Scanner scan;
	JDA jda;

	public BotChat(JDA jda) {
		this.jda = jda;
		scan = new Scanner(System.in);
	}

	@Override
	public void run() {
		String id = "630193396232749089";
		while (true) {
			if (scan.hasNext()) {
				String str = scan.nextLine();
				if (str.equals("exit")) {
					return;
				} else if (str.equals("1")) {
					id = "630193396232749089";
				} else if (str.equals("2")) {
					id = "600296449603010565";
				} else if (str.equals("3")) {
					id = "649635556220731402";
				} else {
					TextChannel tc = jda.getTextChannelById(id);
					tc.sendMessage(str ).queue();
				}
			}
		}
	}
}
