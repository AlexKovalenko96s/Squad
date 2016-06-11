package ua.kas.squad;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller implements Initializable{

	@FXML ImageView lane;
	@FXML Label gk,cb1,cb2,lb,rb,cm1,cm2,cam,lm,rm,st;
	Image img_lane = new Image(getClass().getResourceAsStream("img/FL.jpg"));
	List<String>l_gk = new ArrayList<String>();
	List<String>l_cb = new ArrayList<String>();
	List<String>l_lb = new ArrayList<String>();
	List<String>l_rb = new ArrayList<String>();
	List<String>l_cm = new ArrayList<String>();
	List<String>l_cam = new ArrayList<String>();
	List<String>l_lm = new ArrayList<String>();
	List<String>l_rm = new ArrayList<String>();
	List<String>l_st = new ArrayList<String>();
	String[] pos = {"gk","cb","lb","rb","cm","cam","lm","rm","st"};
	String[] l_pos = {"l_gk","l_cb","l_lb","l_rb","l_cm","l_cam","l_lm","l_rm","l_st"};
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 lane.setImage(img_lane);
	} 
	
	public void select(ActionEvent e) throws SQLException, InterruptedException{
		
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/squad", "root", "root");
		java.sql.PreparedStatement ps = myConn.prepareStatement("select * from players where position=?");
		
		for(int i=0; i<pos.length; i++){
			ps.setString(1, pos[i]);
			ResultSet myRs = ps.executeQuery();

			while(myRs.next()){
				if(pos[i].equals("gk")){
					l_gk.add(myRs.getString("skill")+" "+ myRs.getString("Name"));
					Thread t = new Thread(new Thread_constractor(l_gk));
					t.start();
					t.join();
					gk.setText(Thread_constractor.player);
				}
				if(pos[i].equals("cb")){
					l_cb.add(myRs.getString("skill")+" "+ myRs.getString("Name"));
					Thread t = new Thread(new Thread_constractor(l_cb));
					t.start();
					t.join();
					cb1.setText(Thread_constractor.player);
					cb2.setText(Thread_constractor.player_second);
				}
				if(pos[i].equals("rb")){
					l_rb.add(myRs.getString("skill")+" "+ myRs.getString("Name"));
					Thread t = new Thread(new Thread_constractor(l_rb));
					t.start();
					t.join();
					rb.setText(Thread_constractor.player);
				}
				if(pos[i].equals("lb")){
					l_lb.add(myRs.getString("skill")+" "+ myRs.getString("Name"));
					Thread t = new Thread(new Thread_constractor(l_lb));
					t.start();
					t.join();
					lb.setText(Thread_constractor.player);
				}
				if(pos[i].equals("cm")){
					l_cm.add(myRs.getString("skill")+" "+ myRs.getString("Name"));
					Thread t = new Thread(new Thread_constractor(l_cm));
					t.start();
					t.join();
					cm1.setText(Thread_constractor.player);
					cm2.setText(Thread_constractor.player_second);
				}
				if(pos[i].equals("cam")){
					l_cam.add(myRs.getString("skill")+" "+ myRs.getString("Name"));
					Thread t = new Thread(new Thread_constractor(l_cam));
					t.start();
					t.join();
					cam.setText(Thread_constractor.player);
				}
				if(pos[i].equals("lm")){
					l_lm.add(myRs.getString("skill")+" "+ myRs.getString("Name"));
					Thread t = new Thread(new Thread_constractor(l_lm));
					t.start();
					t.join();
					lm.setText(Thread_constractor.player);
				}
				if(pos[i].equals("rm")){
					l_rm.add(myRs.getString("skill")+" "+ myRs.getString("Name"));
					Thread t = new Thread(new Thread_constractor(l_rm));
					t.start();
					t.join();
					rm.setText(Thread_constractor.player);
				}
				if(pos[i].equals("st")){
					l_st.add(myRs.getString("skill")+" "+ myRs.getString("Name"));
					Thread t = new Thread(new Thread_constractor(l_st));
					t.start();
					t.join();
					st.setText(Thread_constractor.player);
				}
			}
		}
	}
}