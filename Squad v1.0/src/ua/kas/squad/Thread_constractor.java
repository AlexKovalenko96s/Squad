package ua.kas.squad;

import java.util.ArrayList;
import java.util.List;

public class Thread_constractor implements Runnable {

	List<String> l = new ArrayList<String>();
	static String player, player_second, player_third;
	static String skill, skill_second, skill_third;
	static String condition, condition_second, condition_third;
	int size;

	public Thread_constractor(List<String> l) {
		this.l = l;
	}

	@Override
	public void run() {
		l.sort(null);
		size = l.size();
		player = l.get(size - 1);
		skill = player.substring(0, 2);
		condition = player.substring((player.lastIndexOf("  ")) + 2);
		player = player.substring((player.indexOf("  ")) + 2, player.lastIndexOf("  "));

		try {
			player_second = l.get(size - 2);
			condition_second = player_second.substring((player_second.lastIndexOf("  ")) + 2);
			skill_second = player_second.substring(0, 2);
			player_second = player_second.substring((player_second.indexOf("  ")) + 2, player_second.lastIndexOf("  "));
		} catch (Exception ex) {
		}

		try {
			player_third = l.get(size - 3);
			condition_third = player_third.substring((player_third.lastIndexOf("  ")) + 2);
			skill_third = player_third.substring(0, 2);
			player_third = player_third.substring((player_third.indexOf("  ")) + 2, player_third.lastIndexOf("  "));
		} catch (Exception ex) {
		}
	}
}
