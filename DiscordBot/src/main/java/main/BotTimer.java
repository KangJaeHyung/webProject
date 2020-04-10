package main;

import java.util.Calendar;

import crud.CrudProcess;

public class BotTimer extends Thread {
	CrudProcess crud;
	public BotTimer() {
		crud=new CrudProcess();
	}
	@Override
	public void run() {
		while (true) {
			Calendar c = Calendar.getInstance();
			if(c.get(Calendar.HOUR)==5&&c.get(Calendar.MINUTE)==0&&c.get(Calendar.SECOND)==0) {
				crud.resetCp();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
