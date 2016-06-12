package ua.kas.squad;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller implements Initializable{

	@FXML AnchorPane pane;
	@FXML ImageView lane;
	ObservableList<String>obs_list;
	@FXML ComboBox<String>cb;
	@FXML Label l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
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
	String[] pos4_2_3_1 = {"gk","cb","lb","rb","cm","cam","lm","rm","st"};
	String[] pos3_2_3_2 = {"gk","cb","cm","cam","lm","rm","st"};
	String[] shemas;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		obs_list = FXCollections.observableArrayList("4-2-3-1","3-2-3-2");
		cb.setItems(obs_list);
		lane.setImage(img_lane);
	} 
	
	public void enter_scheme(ActionEvent e){
		pane.setVisible(true);
		if(cb.getSelectionModel().getSelectedItem().equals("4-2-3-1")){
			l0.setText("GK");
			l1.setText("CB");
			l2.setText("CB");
			l3.setText("LB");
			l4.setText("RB");
			l5.setText("CM");
			l6.setText("CM");
			l7.setText("CAM");
			l8.setText("LM");
			l9.setText("RM");
			l10.setText("ST");
			
			l1.setLayoutX(100);
			l1.setLayoutY(286);
			l2.setLayoutX(182);
			l2.setLayoutY(286);
			l3.setLayoutX(16);
			l3.setLayoutY(256);
			l4.setLayoutX(256);
			l4.setLayoutY(256);
			l5.setLayoutX(87);
			l5.setLayoutY(200);
			l6.setLayoutX(189);
			l6.setLayoutY(200);
			l7.setLayoutX(136);
			l7.setLayoutY(131);
			l8.setLayoutX(16);
			l8.setLayoutY(131);
			l9.setLayoutX(256);
			l9.setLayoutY(131);
			l10.setLayoutX(136);
			l10.setLayoutY(66);
		}
		if(cb.getSelectionModel().getSelectedItem().equals("3-2-3-2")){
			l0.setText("GK");
			l1.setText("CB");
			l2.setText("CB");
			l3.setText("CB");
			l5.setText("CM");
			l6.setText("CM");
			l8.setText("LM");
			l7.setText("CAM");
			l9.setText("RM");
			l10.setText("ST");
			l4.setText("ST");
			
			l1.setLayoutX(54);
			l1.setLayoutY(286);
			l2.setLayoutX(136);
			l2.setLayoutY(286);
			l3.setLayoutX(219);
			l3.setLayoutY(286);
			l4.setLayoutX(189);
			l4.setLayoutY(65);
			l5.setLayoutX(87);
			l5.setLayoutY(200);
			l6.setLayoutX(189);
			l6.setLayoutY(200);
			l7.setLayoutX(136);
			l7.setLayoutY(131);
			l8.setLayoutX(16);
			l8.setLayoutY(131);
			l9.setLayoutX(256);
			l9.setLayoutY(131);
			l10.setLayoutX(87);
			l10.setLayoutY(65);
		}
	}
	
	public void select(ActionEvent e) throws SQLException, InterruptedException{

		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/squad", "root", "root");
		java.sql.PreparedStatement ps = myConn.prepareStatement("select * from players where position=?");
		
		if(cb.getSelectionModel().getSelectedItem().equals("4-2-3-1")){
			shemas = pos4_2_3_1;
		}
		if(cb.getSelectionModel().getSelectedItem().equals("3-2-3-2")){
			shemas = pos3_2_3_2;
		}
		
		for(int i=0; i<shemas.length; i++){
			
			ps.setString(1, shemas[i]);
			ResultSet myRs = ps.executeQuery();

			while(myRs.next()){
				if(shemas[i].equals("gk")){
					l_gk.add(myRs.getString("skill")+" "+ myRs.getString("Name"));
					Thread t = new Thread(new Thread_constractor(l_gk));
					t.start();
					t.join();
					l0.setText(Thread_constractor.player);
				}
				if(shemas[i].equals("cb")){
					l_cb.add(myRs.getString("skill")+" "+ myRs.getString("Name"));
					Thread t = new Thread(new Thread_constractor(l_cb));
					t.start();
					t.join();
					if(cb.getSelectionModel().getSelectedItem().equals("4-2-3-1")){
						l1.setText(Thread_constractor.player);
						l2.setText(Thread_constractor.player_second);
					}
					if(cb.getSelectionModel().getSelectedItem().equals("3-2-3-2")){
						l1.setText(Thread_constractor.player);
						l2.setText(Thread_constractor.player_second);
						l3.setText(Thread_constractor.player_third);
					}
				}
				if(shemas[i].equals("rb")){
					l_rb.add(myRs.getString("skill")+" "+ myRs.getString("Name"));
					Thread t = new Thread(new Thread_constractor(l_rb));
					t.start();
					t.join();
					if(cb.getSelectionModel().getSelectedItem().equals("4-2-3-1")){
						l4.setText(Thread_constractor.player);
					}
					if(cb.getSelectionModel().getSelectedItem().equals("3-2-3-2")){
					}				
				}
				if(shemas[i].equals("lb")){
					l_lb.add(myRs.getString("skill")+" "+ myRs.getString("Name"));
					Thread t = new Thread(new Thread_constractor(l_lb));
					t.start();
					t.join();
					if(cb.getSelectionModel().getSelectedItem().equals("4-2-3-1")){
						l3.setText(Thread_constractor.player);
					}
					if(cb.getSelectionModel().getSelectedItem().equals("3-2-3-2")){
					}
				}
				if(shemas[i].equals("cm")){
					l_cm.add(myRs.getString("skill")+" "+ myRs.getString("Name"));
					Thread t = new Thread(new Thread_constractor(l_cm));
					t.start();
					t.join();
					if(cb.getSelectionModel().getSelectedItem().equals("4-2-3-1")){
						l5.setText(Thread_constractor.player);
						l6.setText(Thread_constractor.player_second);
					}
					if(cb.getSelectionModel().getSelectedItem().equals("3-2-3-2")){
						l5.setText(Thread_constractor.player);
						l6.setText(Thread_constractor.player_second);
					}

				}
				if(shemas[i].equals("cam")){
					l_cam.add(myRs.getString("skill")+" "+ myRs.getString("Name"));
					Thread t = new Thread(new Thread_constractor(l_cam));
					t.start();
					t.join();
					if(cb.getSelectionModel().getSelectedItem().equals("4-2-3-1")){
						l7.setText(Thread_constractor.player);
					}
					if(cb.getSelectionModel().getSelectedItem().equals("3-2-3-2")){
						l7.setText(Thread_constractor.player);
					}
				}
				if(shemas[i].equals("lm")){
					l_lm.add(myRs.getString("skill")+" "+ myRs.getString("Name"));
					Thread t = new Thread(new Thread_constractor(l_lm));
					t.start();
					t.join();
					if(cb.getSelectionModel().getSelectedItem().equals("4-2-3-1")){
						l8.setText(Thread_constractor.player);
					}
					if(cb.getSelectionModel().getSelectedItem().equals("3-2-3-2")){
						l8.setText(Thread_constractor.player);
					}
				}
				if(shemas[i].equals("rm")){
					l_rm.add(myRs.getString("skill")+" "+ myRs.getString("Name"));
					Thread t = new Thread(new Thread_constractor(l_rm));
					t.start();
					t.join();
					if(cb.getSelectionModel().getSelectedItem().equals("4-2-3-1")){
						l9.setText(Thread_constractor.player);
					}
					if(cb.getSelectionModel().getSelectedItem().equals("3-2-3-2")){
						l9.setText(Thread_constractor.player);
					}	
				}
				if(shemas[i].equals("st")){
					l_st.add(myRs.getString("skill")+" "+ myRs.getString("Name"));
					Thread t = new Thread(new Thread_constractor(l_st));
					t.start();
					t.join();
					if(cb.getSelectionModel().getSelectedItem().equals("4-2-3-1")){
						l10.setText(Thread_constractor.player);
					}
					if(cb.getSelectionModel().getSelectedItem().equals("3-2-3-2")){
						l10.setText(Thread_constractor.player);
						l4.setText(Thread_constractor.player_second);
					}
				}
			}
		}
		l_gk.clear();
		l_cb.clear();
		l_lb.clear();
		l_rb.clear();
		l_cm.clear();
		l_cam.clear();
		l_lm.clear();
		l_rm.clear();
		l_st.clear();
	}
}