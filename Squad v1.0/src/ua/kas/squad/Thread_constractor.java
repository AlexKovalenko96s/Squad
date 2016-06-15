package ua.kas.squad;

import java.util.ArrayList;
import java.util.List;

public class Thread_constractor implements Runnable{

	List<String>l = new ArrayList<String>();
	static String player;
	static String skill, skill_second, skill_third;
	static String player_second;
	static String player_third;
	int size;
	
	public  Thread_constractor (List<String> l){
		this.l=l;
	}

	@Override
	public void run() {
		l.sort(null);
		size = l.size();
		player = l.get(size-1);
		skill = player.substring(0, 2);
		player = player.substring((player.indexOf(" "))+1);
		

		try{
			player_second = l.get(size-2);
			player_second = player_second.substring((player_second.indexOf(" "))+1);
			skill_second = player.substring(0, 2);
		}catch(Exception ex){}	
		
		try{
			player_third = l.get(size-3);
			player_third = player_third.substring((player_third.indexOf(" "))+1);
			skill_third = player.substring(0, 2);
		}catch(Exception ex){}	
	}
}
