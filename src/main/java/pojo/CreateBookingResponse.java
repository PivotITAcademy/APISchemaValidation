package pojo;

public class CreateBookingResponse {

	String bookingid;
	CreateBookingRequest booking;
	public String getBookingid() {
		return bookingid;
	}
	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}
	public CreateBookingRequest getBooking() {
		return booking;
	}
	public void setBooking(CreateBookingRequest booking) {
		this.booking = booking;
	}
}
