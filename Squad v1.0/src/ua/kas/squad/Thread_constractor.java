package ua.kas.squad;

import java.util.ArrayList;
import java.util.List;

public class Thread_constractor implements Runnable{

	List<String>l = new ArrayList<String>();
	static String player;
	static String player_second;
	int size;
	
	public  Thread_constractor (List<String> l){
		this.l=l;
	}

	@Override
	public void run() {
		l.sort(null);
		size = l.size();
		
		player = l.get(size-1);
		player = player.substring((player.indexOf(" "))+1);
		
		try{
			player_second = l.get(size-2);
			player_second = player_second.substring((player_second.indexOf(" "))+1);
		}catch(Exception ex){}	
	}
}
