import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
public class ChooseWindow  {
	JRadioButton r1,r2,r3,r4,r5;
	JButton ok;
	int number=0;
	JButton book;
	JTextField fname,lname,phone,seatn,bust,fromt,destinationt;
	String fname1,lname1,phone1,seatn1,bust1,fromt1,destinationt1;
	JFrame booking;
	JFrame choose;
	JFrame busdetails;
	public void choosewindow() {
		choose=new JFrame();
		choose.setLayout(new FlowLayout(FlowLayout.CENTER));
		ButtonGroup group=new ButtonGroup();
		
		JLabel label=new JLabel("Choose");
		label.setPreferredSize(new Dimension(200,25));
		label.setForeground(Color.RED);
		choose.add(label);
		r1=new JRadioButton("Available tickets");
		r1.setPreferredSize(new Dimension(220,25));
		choose.add(r1);
		r2=new JRadioButton("Book Tickets");
		r2.setPreferredSize(new Dimension(220,25));
		choose.add(r2);
		r3=new JRadioButton("Update Ticket");
		r3.setPreferredSize(new Dimension(220,25));
		choose.add(r3);
		r4=new JRadioButton("Delete Booked Ticket");
		r4.setPreferredSize(new Dimension(220,25));
		choose.add(r4);
		r5=new JRadioButton("Delete Booked Ticket");
		r5.setPreferredSize(new Dimension(220,25));
		choose.add(r5);
		ok=new JButton("OK");
		ok.setPreferredSize(new Dimension(200,25));
		ok.setBackground(Color.green);
//		ok.setForeground(Color.white);
		choose.add(ok);
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(r1.isSelected()) {
					number=1;
					Main main=new Main();
					try {
						main.mainwindow(number);
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
				if(r2.isSelected()) {
					number=2;
						bookingDetails();
				}
				if(r3.isSelected()) {
					number=3;
					Main main=new Main();
					try {
						main.mainwindow(number);
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
				if(r4.isSelected()) {
					number=4;
					Main main=new Main();
					try {
						main.mainwindow(number);
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
				if(r5.isSelected()) {
					number=5;
					Main main=new Main();
					try {
						main.mainwindow(number);
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
		group.add(r1);
		group.add(r2);
		group.add(r3);
		group.add(r4);
		group.add(r5);
		
		choose.setSize(400,300);
		choose.setLocation(450,200);
		choose.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		choose.setVisible(true);
	}
	
	public void bookingDetails() {
		JFrame booking= new JFrame();
		booking.setLayout(null);
		JLabel firstname=new JLabel("First Name");
		firstname.setBounds(5,5,100,25);
		booking.add(firstname);
		
		fname=new JTextField();
		fname.setBounds(120,5,180,25);
		booking.add(fname);
		
		JLabel lastname=new JLabel("Last Name");
		lastname.setBounds(5,35,100,25);
		booking.add(lastname);
		
		lname=new JTextField();
		lname.setBounds(120,35,180,25);
		booking.add(lname);
		
		JLabel phonenumber=new JLabel("Phone Number");
		phonenumber.setBounds(5,65,100,25);
		booking.add(phonenumber);
		
		phone=new JTextField();
		phone.setBounds(120,65,180,25);
		booking.add(phone);
		
		JLabel seat=new JLabel("Seat No");
		seat.setBounds(5,95,100,25);
		booking.add(seat);
		
		seatn=new JTextField();
		seatn.setBounds(120,95,180,25);
		booking.add(seatn);
		
		JLabel busno=new JLabel("Bus No");
		busno.setBounds(5,125,100,25);
		booking.add(busno);
		
		bust=new JTextField();
		bust.setBounds(120,125,180,25);
		booking.add(bust);
		
		JLabel from=new JLabel("From");
		from.setBounds(5,155,100,25);
		booking.add(from);
		
		fromt=new JTextField();
		fromt.setBounds(120,155,180,25);
		booking.add(fromt);
		
		JLabel destination=new JLabel("Destination");
		destination.setBounds(5,185,100,25);
		booking.add(destination);
		
		destinationt=new JTextField();
		destinationt.setBounds(120,185,180,25);
		booking.add(destinationt);
		
		JButton book=new JButton("Book");
		book.setBounds(120,250,100,25);
		booking.add(book);
		book.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==book) {
				fname1=fname.getText();
				lname1=lname.getText();
				phone1=(String)phone.getText();
				seatn1=seatn.getText();
				bust1=bust.getText();
				fromt1=fromt.getText();
				destinationt1=destinationt.getText();
				Main main=new Main();
				try {
					main.mainwindow(2);
				}catch(SQLException ex) {
					
				}finally {
					booking.dispose();
					choosewindow();
				}
			}
		}
	});
		System.out.println("not");
		
		booking.setSize(400,400);
		booking.setLocation(450,200);
		booking.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		booking.setVisible(true);
	}
	
	
	public String getFname1() {
		return fname1;
	}
	public String getLname1() {
		return lname1;
	}
	public String getPhone1() {
		return phone1;
	}
	public String getSeatn1() {
		return seatn1;
	}
	public String getBust1() {
		return bust1;
	}
	public String getFrom1() {
		return fromt1;
	}
	public String getDestinationt1() {
		return destinationt1;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void displayBusdetails(String[][] arr) {
		busdetails=new JFrame();
		busdetails.setLayout(new FlowLayout(FlowLayout.LEADING));
		String columns[]= {"ID","Bus Name","From","To","Price","Bus No"};
		JPanel p=new JPanel();
		busdetails.add(p);
		JTable table=new JTable(arr,columns);
		table.setPreferredSize(new Dimension(600,500));
		JScrollPane scroll=new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(600,400));
		table.setRowHeight(40);
		p.add(scroll);
		
		busdetails.setSize(650,400);
		busdetails.setLocation(450,200);
		busdetails.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		busdetails.setVisible(true);
		
	}

	public static void main(String[] args) {
		
		ChooseWindow mainwin=new ChooseWindow();
		mainwin.choosewindow();
		
		
	}

}
