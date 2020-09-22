import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseAccess {
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3366/projectchandan?characterEncoding=latin1&useConfigs=maxPerformance", "root",
						"");
			} catch (SQLException ex) {
				System.out.println("Failed to create the database connection.");
				System.out.println(ex.getMessage());
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver not found.");
		}
		return con;
	}
	
	public String getCreateBusDetails() {
		String sql="Create table BusDetails(ID int(10) AUTO_INCREMENT,BusName varchar(20),From_location varchar(20),To_location varchar(20),Price int(20),BusNo varchar(20),PRIMARY KEY(ID))";
		return sql;
	}
	
	public String getInsertBusDetails() {
		String sql="Insert into BusDetails(BusName,From_location,To_location,Price,BusNo) values(?,?,?,?,?)";
		return sql;
	}
	
	public String getBookingDetail() {
		String sql="Create table bookingDetail(id int(10) AUTO_INCREMENT,first_name varchar(20),last_name varchar(20),phone_no int(10),seat_no varchar(10),bus_no varchar(20),from_loacation varchar(20),to_location varchar(20),PRIMARY KEY(id))";
		return sql;
	}
}
