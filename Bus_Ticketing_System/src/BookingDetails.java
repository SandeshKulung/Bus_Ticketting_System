public class BookingDetails {

	@Override
	public String toString() {
		return "BookingDetail firstName=" + firstName + "\n lastName=" + lastName + "\n phoneNumber=" + phoneNumber
				+ "\n busNo=" + busNo + "\n from=" + from + "\n to=" + to + "\n seatNo=" + seatNo ;
	}

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String busNo;
	private String from;
	private String to;
	private String seatNo;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
}
