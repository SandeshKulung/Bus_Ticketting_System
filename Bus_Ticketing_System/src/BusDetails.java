public class BusDetails {

	private int id;
	private String busName;
	private String from;
	private String to;
	private double price;
	private String busNo;

	@Override
	public String toString() {
		return "BusDetails id= " + id + "\nbusName=" + busName + "\n from=" + from + "\n to=" + to + "\nprice=" + price
				+ "\n busNo=" + busNo ;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
