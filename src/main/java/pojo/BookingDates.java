package pojo;

public class BookingDates {

	
	private String checkin;
	private String checkout;
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public BookingDates(String checkin, String checkout) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
	}
	public BookingDates() {
		super();
	}
}
