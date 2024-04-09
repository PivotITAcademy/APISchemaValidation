package pojo;

public class CreateBookingRequest {

	private String firstname;

	private String lastname;

	private double totalprice;
	private boolean depositpaid;
	
	private BookingDates bookingdates;
	
	private  String additionalneeds;

	

	

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public BookingDates getBookingdates() {
		return bookingdates;
	}

	public void setBookingdates(BookingDates bookingdates) {
		this.bookingdates = bookingdates;
	}

	public boolean isDepositpaid() {
		return depositpaid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}

	public BookingDates getBookingDates() {
		return bookingdates;
	}

	public void setBookingDates(BookingDates bookingDates) {
		this.bookingdates = bookingDates;
	}

	public String getAdditionalneeds() {
		return additionalneeds;
	}

	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}
	
	
}
