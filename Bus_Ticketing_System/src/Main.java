import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
		String[][] arr=new String[10][6];
		int i=0;
	public void mainwindow(int number) throws SQLException  {
		Scanner sc = new Scanner(System.in);
		DatabaseAccess dao = new DatabaseAccess();
		Connection con = dao.getConnection();
		Statement stmt = con.createStatement();
//		System.out.println("1. Get available tickets    \n2. Book Ticket    \n3.Update ticket    \n4.Delete ticket available    \n5.Insert Bus Details");
//		int number = sc.nextInt();
		switch (number) {
		case 1:
			System.out.println("case 1");
			ResultSet rs=null;
				
			try {
				rs = stmt.executeQuery("select * from BusDetails");
			}catch(Exception ex) {
				System.out.println("table not created in database");
			}
			System.out.println("List of available tickets and price: ");
			try {
				while (rs.next()) {
	//				System.out.println(rs.getInt(1));
	//				System.out.println(rs.getString(2));
	//				System.out.println(rs.getString(3));
	//				System.out.println(rs.getString(4));
	//				System.out.println(rs.getInt(5));
	//				System.out.println(rs.getString(6));
	//				System.out.println();
					
					BusDetails busDetails = new BusDetails();
					arr[i][0]=String.valueOf(rs.getInt(1));
					busDetails.setId(rs.getInt(1));
					busDetails.setBusName(rs.getString(2));
					arr[i][1]=rs.getString(2);
					busDetails.setFrom(rs.getString(3));
					arr[i][2]=rs.getString(3);
					busDetails.setTo(rs.getString(4));
					arr[i][3]=rs.getString(4);
					busDetails.setPrice(rs.getInt(5));
					arr[i][4]=rs.getString(5);
					busDetails.setBusNo(rs.getString(6));
					arr[i][5]=rs.getString(6);
					System.out.println(busDetails.toString());
					
				}
				ChooseWindow win=new ChooseWindow();
				win.displayBusdetails(arr);
			}catch(NullPointerException ex) {
				System.out.println("No data found");
			}
			break;
		case 2:
			try {
				String createbooktable=dao.getBookingDetail();
				Statement stt=(Statement) con.createStatement();
				stt.executeUpdate(createbooktable);
			}catch(Exception ex) {
				System.out.println("table bookingDetails already created");
			}
			System.out.println("in");
			PreparedStatement ps = con.prepareStatement("insert into bookingDetail(first_name,last_name,phone_no,seat_no ,bus_no,from_loacation,to_location) values (?,?,?,?,?,?,?)");
//			System.out.println("Enter first name: ");
			ChooseWindow win=new ChooseWindow();
			ps.setString(1, win.getFname1());
//			System.out.println("Enter last name: ");
			ps.setString(2, win.getLname1());
//			System.out.println("Enter phone Number: ");
			ps.setString(3, win.getPhone1());
//			System.out.println("Enter seat no.: ");
			ps.setString(4, win.getSeatn1());
//			System.out.println("Enter bus number: ");
			ps.setString(5, win.getBust1());
//			System.out.println("Enter from: ");
			ps.setString(6, win.getFrom1());
//			System.out.println("Enter destination: ");
			ps.setString(7, win.getDestinationt1());
			ps.execute();
//			System.out.println("Ticket booked successfully");
			JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
		
			break;
		case 3:
			System.out.println("Enter id: ");
			int id = sc.nextInt();
			PreparedStatement update = con.prepareStatement(
					"update bookingDetail set first_name=?,last_name=?,phone_no=?,seat_no=?,bus_no=?,from_location=?,to_location=? where id="
							+ id);
			System.out.println("Enter first name: ");
			update.setString(1, sc.next());
			System.out.println("Enter last name: ");
			update.setString(2, sc.next());
			System.out.println("Enter phone Number: ");
			update.setString(3, sc.next());
			System.out.println("Enter seat no.: ");
			update.setString(4, sc.next());
			System.out.println("Enter bus number: ");
			update.setString(5, sc.next());
			System.out.println("Enter from: ");
			update.setString(6, sc.next());
			System.out.println("Enter destination: ");
			update.setString(7, sc.next());
			update.execute();
			System.out.println("Updated successfully");
			break;
		case 4:
			PreparedStatement delete = con.prepareStatement("delete from busDetails where id=?");
			System.out.println("Enter ticket id: ");
			delete.setInt(1, sc.nextInt());
			delete.execute();
			System.out.println("Successfully deleted");
			break;
			
		case 5:
			try {
				String sql=dao.getCreateBusDetails();
				Statement st=(Statement)con.createStatement();
				st.executeUpdate(sql);
			}catch(Exception er) {
				System.out.println("Table already exxisted insert into table");
			}
			String sqlinsert=dao.getInsertBusDetails();
			PreparedStatement stmtp=(PreparedStatement) con.prepareStatement(sqlinsert);
			System.out.println("Enter price ");
			stmtp.setInt(4, sc.nextInt());
			System.out.println("Enter Bus name");
			stmtp.setString(1, sc.next());
			System.out.println("Enter From location");
			stmtp.setString(2, sc.next());
			System.out.println("Enter To location");
			stmtp.setString(3, sc.next());
			System.out.println("Enter Bus no");
			stmtp.setString(5, sc.next());
			stmtp.executeUpdate();
			System.out.println("Bus details inserted");
			stmtp.close();
			
			break;
		default:
			System.out.println("invalid choose of number");
			break;
		}
//		con.close();
	}

}
